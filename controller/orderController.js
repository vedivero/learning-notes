const orderController = {};
const Order = require("../Model/Order");
const productContoller = require("./productController");
const { randomStringGenerator } = require("../utils/randomStringGenerator");

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


module.exports = orderController;