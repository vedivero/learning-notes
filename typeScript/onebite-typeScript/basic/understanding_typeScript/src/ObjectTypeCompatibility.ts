// Example 1
/**
 * 기본 타입 간 호환성
 * => 특정 타입을 다른 타읍으로 취급해도 괜찮은지 판단
 */
let num1: number = 10;
let num2: 10 = 10;
// 서브타입 => 슈퍼타입인, 업캐스팅 => O
num1 = num2;
// 슈퍼타입 => 서브타입인, 다운캐스팅 => X
//num2= num1;

// Example 2
type Animal = {
   name: string;
   color: string;
};
type Dog = {
   name: string;
   color: string;
   breed: string;
};

let animal: Animal = {
   name: '호랑이',
   color: 'orange',
};

let dog: Dog = {
   name: '댕댕이',
   color: 'white',
   breed: '푸들',
};
// Animal타입이 Dog 타입의 슈퍼타입임을 추론
animal = dog;
// Dog타입이 Animal 타입의 서브타입임을 추론
//dog = animal;

// typsScript = 구조적 타입 시스템
// 조건이 적은 타입이 슈퍼타입이 됨

// Example 3
type Book = {
   name: string;
   price: number;
};

type ProgrammingBook = {
   name: string;
   price: number;
   skill: string;
};

let book: Book;
let programmingBook: ProgrammingBook = {
   name: 'TypeScript',
   price: 30000,
   skill: 'TypeScript',
};

book = programmingBook;
console.log(book);

// programmingBook타입을 book타입으로
// 업캐스팅하는 것은 가능하지만
// book 타입에 정의되지 않은 속성을 초기화하는 것은 안 됨
// => 타입스크립트의 `초과 프로퍼티 검사`
let book2: Book = {
   name: 'TypeScript',
   price: 30000,
   //skill: 'TypeScript',
};

// 객체 리터럴 할당은 `초과 프로퍼티 검사`에 걸리지 않음
let book3: Book = programmingBook;
function func(book: Book) {}
