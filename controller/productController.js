const Product = require("../Model/Product");
const PAGE_SIZE = 4
const productController = {}


//상품 생성
productController.createProduct = async (req, res) => {
	try {
		const { sku, name, size,
			image, category, description,
			price, stock, originalPrice, status } = req.body;

		const product = new Product({
			sku, name, size,
			image, category, description,
			price, stock, originalPrice: price, status, viewCnt: 0
		});

		await product.save();
		return res.status(200).json({ status: "Success - create product" });
	} catch (error) {
		return res.status(500).json({ status: "Fail - create product", error: error.message });
	}
};

//상품 조회
productController.getProducts = async (req, res) => {

	try {
		const { page, name } = req.query;
		//검색 키워드
		const cond = name ? {
			name: { $regex: name, $options: 'i' }, isDeleted: false
		} : { isDeleted: false };
		let query = Product.find(cond);
		const response = { status: "success" };
		if (page) {
			query.skip((page - 1) * PAGE_SIZE).limit(PAGE_SIZE);
			//총 페이지 개수 조회
			const totalItemNum = await Product.find(cond).count();
			const totalPageNum = Math.ceil(totalItemNum / PAGE_SIZE);
			response.totalPageNum = totalPageNum;
		}
		//exec실행 시점 정의
		const productList = await query.exec();
		response.data = productList;
		//조회한 결과를 보내주기
		res.status(200).json(response);
	} catch (error) {
		res.status(500).json({ status: "Fail get Products", error: error.message });
	}

}

//상품 수정
productController.updateProduct = async (req, res) => {
	try {
		//id값 저장
		const productId = req.params.id;
		const { sky, name, size, image, price, description, category, stock, status } = req.body;
		const product = await Product.findByIdAndUpdate(
			{ _id: productId },
			{ sky, name, size, image, price, description, category, stock, status }
		);
		res.status(200).json({ status: "Success - Update Product ", data: product });
	} catch (error) {
		res.status(500).json({ status: "Fail - Update Product", error: error.message });
	}
}


//상품 삭제
productController.deleteProduct = async (req, res) => {
	try {
		const productId = req.params.id;
		const product = await Product.findByIdAndUpdate(
			{ _id: productId },
			{ isDeleted: true }
		);
		return res.status(200).json({ status: "Success - Delete Product" });
	} catch (error) {
		return res.status(500).json({ status: "Fail - Delete Product", error: error.message });
	}
}



productController.getProductById = async (req, res) => {
	try {
		const productId = req.params.id;
		const product = await Product.findById(productId);
		if (!product) throw Error("No item found");
		return res.status(200).json({ status: "Success - get Production", data: product });
	} catch (error) {
		return res.status(500).json({ status: "Fail - get Production", error: error.message });
	}
}


//주문하려는 상품 재고 조회
productController.checkStock = async (item) => {
	//주문하려는 상품 정보 조회
	const product = await Product.findById(item.productId);
	//주문하려는 상품 재고 확인
	if (product.stock[item.size] < item.qty) {
		return { isVerify: false, message: `${product.name}의 ${item.size}재고가 부족합니다. ` }
	}

	const newStock = { ...product.stock };//현재 재고 복사
	newStock[item.size] -= item.qty;//구매 수량만큼 재고 차감
	product.stock = newStock;//업데이트된 재고 설정

	await product.save();//변경된 재고 저장
	return { isVerify: true };//재고가 충분하다면 true 반환
}


//전체 재고 체크(재고가 없는 상품 조회)
productController.checkItemListStock = async (itemList) => {
	//재고가 있으면 빈 값이 전달
	const insufficientStockItems = [];

	await Promise.all(
		//itemList를 하나하나의 재고 체크
		itemList.map(async (item) => {
			const stockCheck = await productController.checkStock(item);
			if (!stockCheck.isVerify) {
				insufficientStockItems.push({ item, message: stockCheck.message });
			}
			return stockCheck;
		})
	);
	return insufficientStockItems;
}


productController.incrementViewCount = async (req, res) => {
	try {
		const product = await Product.findByIdAndUpdate(
			req.params.id,
			{ $inc: { viewCnt: 1 } },
			{ new: true }
		);
		res.status(200).json(product);
	} catch (error) {
		res.status(500).json({ error: error.message });
	}
};


// 조회수 기준으로 내림차순 정렬된 상품 목록 반환
productController.getHottestProducts = async (req, res) => {
	try {
		const products = await Product.find({ isDeleted: false }).sort({ viewCnt: -1 }).exec();
		res.status(200).json(products);
	} catch (error) {
		res.status(500).json({ error: error.message });
	}
};

// 상품 할인율 업데이트
productController.updateProductDiscount = async (req, res) => {
	try {
		const productId = req.params.id;
		const { discount } = req.body;

		if (discount < 0 || discount > 100) {
			return res.status(400).json({ status: "Fail", error: "Invalid discount value" });
		}

		const product = await Product.findById(productId);
		if (!product) {
			return res.status(404).json({ status: "Fail", error: "Product not found" });
		}

		if (!product.originalPrice) {
			product.originalPrice = product.price;
		}

		product.price = Math.floor((product.originalPrice * (1 - discount / 100)) / 100) * 100;
		await product.save();

		return res.status(200).json({ status: "Success", data: product });
	} catch (error) {
		return res.status(500).json({ status: "Fail", error: error.message });
	}
};

// 상품 가격 복구
productController.restoreProductPrice = async (req, res) => {
	try {
		const productId = req.params.id;

		const product = await Product.findById(productId);
		if (!product) {
			return res.status(404).json({ status: "Fail", error: "Product not found" });
		}

		if (product.originalPrice) {
			if (product.price === product.originalPrice) {
				return res.status(200).json({ status: "Success", message: "해당 상품은 정상 가격으로 설정되어 있습니다." });
			}
			product.price = product.originalPrice;
			product.originalPrice = 0;
			await product.save();
			return res.status(200).json({ status: "Success", message: "상품이 할인 전 가격으로 복구되었습니다." });
		} else {
			return res.status(400).json({ status: "Fail", error: "Original price not found" });
		}
	} catch (error) {
		return res.status(500).json({ status: "Fail", error: error.message });
	}
};


// 특정 설정 기간 내의 등록된 상품 목록 반환
productController.getNewArrivalProducts = async (req, res) => {
	try {
		// const sixHoursAgo = new Date(Date.now() - 6 * 60 * 60 * 1000);
		//const tenMinutesAgo = new Date(Date.now() - 10 * 60 * 1000);
		//const twelveHoursAgo = new Date(Date.now() - 12 * 60 * 60 * 1000);
		const oneDayAgo = new Date(Date.now() - 24 * 60 * 60 * 1000);
		//const threeDaysAgo = new Date(Date.now() - 3 * 24 * 60 * 60 * 1000);
		const products = await Product.find({
			isDeleted: false,
			createdAt: { $gte: oneDayAgo }
		}).sort({ createdAt: -1 }).exec();

		res.status(200).json(products);
	} catch (error) {
		res.status(500).json({ error: error.message });
	}
};

module.exports = productController