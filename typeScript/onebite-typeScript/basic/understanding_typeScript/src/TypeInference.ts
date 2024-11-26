/**
 * 타입 추론
 */

// 타입스크립트는 자동으로 타입을 추론
// 타입 추론을 활용하면 코드가 간결

// 타입스크립트가 추론하는 원리

// 초기값을 기준으로 타입을 추론
let a = 10; //let a: number
let b = 'hello'; //let b: string

//let c: {id: number;name: string;
//   profile: {
//      nickname: string;
//   };
//}
let c = {
   id: 1,
   name: '홍길동',
   profile: {
      nickname: 'hong',
   },
};

let { id, name, profile } = c;

//let one: number
//let two: string
//let three: boolean
let [one, two, three] = [1, 'hello', true];

//function func1(): string
//함수는 반환되는 return 값에 따라 추론
function func1() {
   return 'hello';
}

// 매개변수에 대한 추론
// (parameter) message: string
function func2(message = 'hello') {
   return message;
}

// let d: any
// 초기값이 없을 때 any Type으로 지정
let d;

// number Type으로 진화
d = 10;
d.toFixed();

// string Type으로 진화
d = 'hello';
d.toUpperCase();

// string Type을 진화되어 number Type사용 불가
//d.toFixed();

// 상수로 선언됐기에 number Type으로 추론
const num = 10;
// 상수로 선언됐기에 string Type으로 추론
const str = 'hello';

// union Type으로 추론
// let arr: (string | number)[]
let arr = [1, 'hello'];
