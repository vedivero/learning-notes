/**
 * 대수 타입
 * => 여러 개의 타입을 합성해서 새롭게 만들어 낸 타입
 * => 합집합 타입
 * => 교집합 타입
 */

/**
 * 1. 합집합 - Union Type
 */

// 정의
// Union Type 지정
let a: string | number | boolean;
a = 1;
a = 'hello';
a = true;

let arr: (number | string | boolean)[] = [1, 'hello', true];

type Dog = {
   name: string;
   color: string;
};

type Person = {
   name: string;
   language: string;
};
type Union1 = Dog | Person;

let union1: Union1 = {
   name: '',
   color: '',
};
let union2: Union1 = {
   name: '',
   language: '',
};

// Person Type과 Dog Type의 속성을 다 가진 객체
let union3: Union1 = {
   name: '',
   color: '',
   language: '',
};

// union1, union2, union3는 합집합, 교집합 조건에 충족
// union4는 name Property밖에 없음
// 합집합, 교집합에 포함되지 않음
// 오류 발생
// let union4: Union1 = {
//    name: '',
// };

/**
 * 2. 교집합 - Intersection Type
 */
// let variable: never => never 타입으로 선언 됨
// 기본 타입은 서로 일치하는 값이 없음
// 교집합은 객체 타입에 많이 사용 됨
let variable: number & string;

type Car = {
   name: string;
   color: string;
};

type Book = {
   name: string;
   language: string;
};

type Intersection = Car & Book;

// 교집합: Car 타입, Book 타입의 속성이 겹쳐지는 속성
// 양쪽 모두 가지고 있는 속성만 해당
let intersection1: Intersection = {
   name: '',
   color: '',
   language: '',
};
