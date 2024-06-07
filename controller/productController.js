const Product = require("../Model/Product");
const PAGE_SIZE = 4
const productContoller = {}


//상품 생성
productContoller.createProduct = async (req, res) => {
	try {
		const { sku, name, size,
			image, category, description,
			price, stock, status } = req.body;

		const product = new Product({
			sku, name, size,
			image, category, description,
			price, stock, status
		});

		await product.save();
		res.status(200).json({ status: "Success - create product" });
	} catch (error) {
		res.status(400).json({ status: "Fail - create product" })
	}
};

//상품 조회
productContoller.getProducts = async (req, res) => {

	try {
		const { page, name } = req.query;
		//검색 키워드
		const cond = name ? { name: { $regex: name, $options: 'i' } } : {};
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
		res.status(400).json({ status: "Fail get Products", error: error.message });
	}

}

//상품 수정
productContoller.updateProduct = async (req, res) => {


	try {
		//id값 저장
		const productId = req.params.id;
		console.log("req id : ", req.params.id);
		const { sky, name, size, image, price, description, category, stock, status } = req.body;
		const product = await Product.findByIdAndUpdate(
			{ _id: productId },
			{ sky, name, size, image, price, description, category, stock, status }
		);
		console.log("product : ", product);
		res.status(200).json({ status: "Success - Update Product ", data: product });
	} catch (error) {
		res.status(400).json({ status: "Fail - Update Product", error: error.message });
	}

}


module.exports = productContoller