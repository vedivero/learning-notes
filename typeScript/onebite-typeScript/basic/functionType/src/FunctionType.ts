/**
 * 함수 타입 정의
 */

// 함수는 어떤 매개변수를 받고
// 어떤 결과값을 반환하는지를 의미
// => 어떤 타입의 매개변수를 받고
// 어떤 타입의 결과값을 반환하는지
function func(a: number, b: number) {
   return a + b;
}

/**
 * 화살표 함수 타입
 */
// 매개변수와 반환값에 대해 타입을 정의
const add = (a: number, b: number): number => a + b;

/**
 * 함수의 매개변수
 */
// 선택적 매개변수는 필수 매개변수 앞에 선언되면 안 됨
function menu(food1 = '김밥', ea?: number) {
   // 전달 받지 않을 수도 있는 ea 매개변수를
   // 타입 좁히기로 undefined로 처리되지 않도록 설정
   if (typeof ea === 'number') {
      console.log(`오늘의 음식은 ${food1} ${ea}줄 입니다`);
   }
}
menu('김밥', 1);
menu('김밥');

function getSum(...rest: [number, number, number]) {
   let sum = 0;
   rest.forEach((it) => (sum += it));
   return sum;
}

getSum(1, 2, 3);
getSum(1, 2, 3, 4, 5);
