// Number Array
let numArr: number[] = [1, 2, 3];

// String Array
let strArr: string[] = ['hello', 'type', 'script'];

// boolean Array
let boolArr: Array<boolean> = [true, false];

// Multiple Array
let MultipleArr: (number | string)[] = [1, 'hello'];

// Multi-Array
let doubleArr: number[][] = [
   [1, 2, 3],
   [4, 5],
];

// tuple
// 길이와 타입이 고정됀 배열
let tuple1: [number, number] = [1, 2];
//tup1 = [1, 2, 3];
//tu1 = ['1', '2'];

tuple1.push(1);
tuple1.pop();
tuple1.pop();
tuple1.pop();

let tuple2: [number, string, boolean] = [1, '2', true];

// Use Examples
const users: [string, number][] = [
   ['홍길동', 1],
   ['임꺽정', 1],
   ['고길동', 1],
   ['신짱구', 1],
   //[5, '봉미선'],   //값을 잘못 할당하지 않도록 방지
];