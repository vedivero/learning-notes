/**
 * 함수 타입의 호환성
 * 특정 함수 타입을
 * 다른 함수 타입으로
 * 취급해도 괜찮은가를 판단
 *
 * 체크 리스트
 * 1. 반환 값의 타입이 호환되는지
 * 2. 매개 변수의 타입이 호환되는지
 *
 * 두 가지가 모두 충족 되어야 함수가 호환
 */

// 기준 1. 반한 값 호환
type A = () => number;
type B = () => 10;

let a: A = () => 10;
let b: B = () => 10;

a = b; // return = Number Type -> Up Casting
b = a; // return = Number Literal Type -> Down Casting

// 다운 캐스팅하는 상황은 호환 되지 않음

// 기준 2. 매개 변수 호환

// 2-1 매개 변수 개수가 같을 때
type C = (value: number) => void;
type D = (value: 10) => void;

let c: C = (value) => {};
let d: D = (value) => {};

c = d;
// number Literal Type을 number Type으로 취급하려는 것
// 반환 값으로 호환 여부를 판단하는 것과 다르게
// 매개 변수 기준으로 호환성을 판단할 때
// Up Cating이 안 된다고 평가

// number Type을 number Literal Type으로 취급하려는 것
// Down Cating이 된다고 평가
d = c;

// 객체 타입으로 설명
type Animal = {
   name: string;
};
type Dog = {
   name: string;
   color: string;
};

let aniamlFunc = (animal: Animal) => {
   console.log(animal.name);
};
let dogFunc = (dog: Dog) => {
   console.log(dog.name);
   console.log(dog.color);
};

// Animal 타입이 슈퍼 타입이므로
// aniamlFunc의 매개 변수 타입이 더 큰 타입
// dogFunc -> animalFunc로 upCasting되는 상황이지만
// 오류 발생
aniamlFunc = dogFunc;

// Animal Type에는 color라는 속성이 없음

// 2-2 매개 변수 개수가 다를 때
type Func1 = (a: number, b: number) => void;
type Func2 = (a: number) => void;

let func1: Func1 = (a, b) => {};
let func2: Func2 = (a) => {};

func1 = func2;
// func2의 매개 변수는 2개이기에
// 1개만 매개 변수로 받는 func1에
// 호환이 안 된다.
func2 = func1;
