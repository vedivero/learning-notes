/**
 * 함수 타입 표현식
 */

// 매개 변수와 반환 값의 타입을 지정하는 방법
const add1 = (a: number, b: number): number => a + b;

// 함수 타입 표현식을 사용하면
// 타입 별칭을 이용해서 함수의 타입 정의 가능

type Operation = (a: number, b: number) => number;
//const add: Operation = (a, b) => a + b;

// 함수 타입 표현식의 좋은 점
const add: Operation = (a, b) => a + b;
const sub: Operation = (a, b) => a - b;
const multiply: Operation = (a, b) => a * b;
const divide: Operation = (a, b) => a / b;

/**
 * 호출 시그니처
 * (콜 시그니처)
 */
type Operation2 = {
   (a: number, b: number): number;
};

const add2: Operation2 = (a, b) => a + b;
const sub2: Operation2 = (a, b) => a - b;
const multiply2: Operation2 = (a, b) => a * b;
const divide2: Operation2 = (a, b) => a / b;
