//구조분해 할당 예제
const profile = {
   name: '홍길동',
   age: 20,
   hobby: '축구',
};

const { name, age, hobby } = profile;
console.log(name, age, hobby);

// 1.일반 변수 전달
function fruit(item) {
   //const item = 'apple';
   console.log(item);
}

fruit('apple');

// 2. 객체 전달
// function foods(item) {
//    console.log(item);
//    console.log(item.chicken);
//    console.log(item.pizza);
//    console.log(item.hamburger);
// }

// const basket = {
//    chicken: 5,
//    pizza: 10,
//    hamburger: 2,
// };

//foods(basket);

//3. 객체 전달 (구조 분해 방식)
function foods({ chicken, pizza, hamburger }) {
   console.log(chicken);
   console.log(pizza);
   console.log(hamburger);
}

//객체{key:value}의 key를 매개변수로 인식하기 때문에
//인자로 전달되는 순서와, 전달된 인자를 받는 매개변수의 순서를
//매칭 시키지 않아도 된다.

const basket = {
   chicken: 5,
   pizza: 10,
   hamburger: 2,
};

foods(basket);
