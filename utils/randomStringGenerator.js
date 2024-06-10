//주문 번호 생성 함수
const randomStringGenerator = () => {
	const randomStirng = Array.from(Array(10), () =>
		Math.floor(Math.random() * 36).toString(36)
	).join("");

	return randomStirng;
}

module.exports = { randomStringGenerator };