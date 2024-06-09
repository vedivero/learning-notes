const { populate } = require("dotenv");
const Cart = require("../Model/Cart");
const cartController = {}

cartController.addItemToCart = async (req, res) => {
	try {
		const { userId } = req;
		const { productId, size, qty } = req.body;

		// 유저를 가지고 카트 찾기
		let cart = await Cart.findOne({ userId });

		// 유저가 만든 카트가 없다면 만들기
		if (!cart) {
			cart = new Cart({ userId });
			await cart.save();
		}

		// 이미 카트에 들어가 있는 아이템인지 확인하기 -> 맞으면 에러
		const existItem = cart.items.find(
			// -> productId가 몽구스에서 사용하는 _id 값이여서 equals로 비교
			(item) => item.productId.equals(productId) && item.size === size
		);

		if (existItem) throw new Error("해당 상품이 이미 장바구니에 담겨있습니다.");

		// 카트에 아이템을 추가
		cart.items = [...cart.items, { productId, size, qty }];
		await cart.save();

		return res.status(200).json({
			status: "Success - Saved Product In Cart",
			data: cart,
			cartItemQty: cart.items.length
		});

	} catch (error) {
		return res.status(400).json({
			status: "Fail - Saved Product In Cart",
			error: error,
			message: error.message
		});
	}
}



//카트 리스트
cartController.getCart = async (req, res) => {
	try {
		const { userId } = req;
		const cart = await Cart.findOne({ userId }).populate({
			path: 'items',
			populate: {
				path: 'productId',
				model: "Product"
			}
		});
		return res.status(200).json({ status: "Success Get Cart", data: cart.items });
	} catch (error) {
		return res.status(400).json({
			status: "Fail - Get Cart",
			error: error,
			message: error.message
		});
	}
}

//카트 상품 삭제
cartController.deleteCartItem = async (req, res) => {
	try {
		const { id } = req.params;
		const { userId } = req;
		const cart = await Cart.findOne({ userId });
		cart.items = cart.items.filter((item) => !item._id.equals(id));
		await cart.save();
		return res.status(200).json({ status: "Success - Delete Production", cartItemQty: cart.items.length })
	} catch (error) {
		return res.status(400).json({ status: "Fail - Delete Production", error: error.message });
	}
}


//카트 상품 개수 수정
cartController.editCartItem = async (req, res) => {
	try {
		const { userId } = req;
		const { id } = req.params;

		const { qty } = req.body;
		const cart = await Cart.findOne({ userId }).populate({
			path: "items",
			populate: {
				path: "productId",
				model: "Product",
			},
		});
		if (!cart) throw new Error("카트 정보가 없습니다.");
		const index = cart.items.findIndex((item) => item._id.equals(id));
		if (index === -1) throw new Error("상품을 찾을 수 없습니다.");
		cart.items[index].qty = qty;
		await cart.save();
		return res.status(200).json({ status: "Success - Edit Cart Items", data: cart.item });
	} catch (error) {
		return res.status(400).json({ status: "Fail - Edit Cart Items", error: error.message });
	}
}

//카트 수량
cartController.getCartQty = async (req, res) => {
	try {
		const { userId } = req;
		const cart = await Cart.findOne({ userId });
		if (!cart) throw new Error("카트 정보가 없습니다.");
		return res.status(200).json({ status: "Success - getCartQty", qty: cart.items.length });
	} catch (error) {
		return res.status(400).json({ status: "Fail - getCartQty", error: error.message });
	}
};

module.exports = cartController;