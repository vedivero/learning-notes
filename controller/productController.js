const Product = require("../Model/Product");

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


module.exports = productContoller