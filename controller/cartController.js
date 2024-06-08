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


module.exports = cartController;