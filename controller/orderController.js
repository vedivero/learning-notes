const orderController = {};
const Order = require("../Model/Order");
const productContoller = require("./productController");
const { randomStringGenerator } = require("../utils/randomStringGenerator");
const PAGE_SIZE = 10;

//주문 생성
orderController.createOrder = async (req, res) => {
	try {
		//클라이언트 데이터
		const { userId } = req;
		const { shipTo, contact, totalPrice, orderList } = req.body;

		console.log("userId: ", userId)
		console.log("shipTo, contact, totalPrice, orderList: ", shipTo, contact, totalPrice, orderList)

		//재고 체크(재고가 없는 상품 조회)
		const insufficientStockItems = await productContoller.checkItemListStock(orderList);
		console.log("insufficientStockItems: ", insufficientStockItems)

		//재고가 없는 경우
		if (insufficientStockItems.length > 0) {
			const errorMessage = insufficientStockItems.reduce(
				(total, item) => (total += item.errorMessage), ""
			);
			throw new Error(errorMessage);
		}

		//주문 객체 생성
		const newOrder = new Order({
			userId,
			totalPrice,
			shipTo,
			contact,
			items: orderList,
			orderNum: randomStringGenerator()
		});
		//주문 정보 저장
		await newOrder.save();
		//주문 완료된 상품 카트에서 제거

		//저장 결과 리턴
		return res.status(200).json({ status: "Success - Order Create", orderNum: newOrder.orderNum });
	} catch (error) {
		return res.status(400).json({ status: "Fail - Order Create", error: error.message });
	}
}


//관리자 페이지 주문 목록 조회
orderController.getOrder = async (req, res, next) => {
	try {
		//'req' 객체에서 'userId'를 추출하여 변수 'userId'에 할당
		const { userId } = req;
		//'Order' 모델에서 'userId'가 일치하는 주문 목록을 찾아 'orderList'에 할당
		const orderList = await Order.find({ userId }).populate({
			path: "items",// 'items' 경로를 참조하여 연관된 데이터를 가져옴
			populate: {
				path: "productId",
				model: "Product",
				select: "image name",
			},
		});
		//'userId'가 일치하는 주문의 총 개수를 세어 'totalItemNum'에 할당
		const totalItemNum = await Order.find({ userId }).count();
		//'totalItemNum'을 'PAGE_SIZE'로 나누고 올림하여 총 페이지 수를 계산하여 'totalPageNum'에 할당
		const totalPageNum = Math.ceil(totalItemNum / PAGE_SIZE);
		// 응답 상태를 200으로 설정하고 JSON 형식으로 성공 상태와 'orderList', 'totalPageNum'을 응답
		res.status(200).json({ status: "Success - Get Order", data: orderList, totalPageNum });
	} catch (error) {
		return res.status(400).json({ status: "Fail - Get Order", error: error.message });
	}
}


// 주문 목록을 조회하는 함수 정의
orderController.getOrderList = async (req, res, next) => {
	try {
		// 쿼리 파라미터에서 페이지 번호와 주문 번호를 추출
		const { page, ordernum } = req.query;

		// 조건 객체 초기화
		let cond = {};
		// 주문 번호가 있으면 조건 객체에 정규식 조건 추가
		if (ordernum) {
			cond = {
				orderNum: { $regex: ordernum, $options: "i" },
			};
		}

		// 조건에 맞는 주문 목록을 페이징 처리하여 조회
		const orderList = await Order.find(cond)
			.populate("userId")
			.populate({
				path: "items",
				populate: {
					path: "productId",
					model: "Product",
					select: "image name",
				},
			})
			.skip((page - 1) * PAGE_SIZE)
			.limit(PAGE_SIZE);

		// 조건에 맞는 주문의 총 개수를 조회
		const totalItemNum = await Order.find(cond).count();

		// 총 페이지 수 계산
		const totalPageNum = Math.ceil(totalItemNum / PAGE_SIZE);

		// 성공 응답 반환
		return res.status(200).json({ status: "success", data: orderList, totalPageNum });
	} catch (error) {
		// 에러 발생 시 실패 응답 반환
		return res.status(400).json({ status: "fail", error: error.message });
	}
};


// 주문 상태를 업데이트하는 함수 정의
orderController.updateOrder = async (req, res, next) => {
	try {
		// URL 파라미터에서 주문 ID를 추출
		const { id } = req.params;
		// 요청 본문에서 주문 상태를 추출
		const { status } = req.body;

		// 주문 ID에 해당하는 주문을 찾아 상태 업데이트
		const order = await Order.findByIdAndUpdate(
			id,
			{ status: status },
			{ new: true }
		);

		// 주문이 존재하지 않으면 에러 발생
		if (!order) throw new Error("Can't find order");

		// 성공 응답 반환
		return res.status(200).json({ status: "success", data: order });
	} catch (error) {
		// 에러 발생 시 실패 응답 반환
		return res.status(400).json({ status: "fail", error: error.message });
	}
};


module.exports = orderController;