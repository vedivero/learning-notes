/**
 * 타입 단언
 */

import { title } from 'process';

type Person = {
   name: string;
   age: number;
};

//person객체가 빈 객체로 추론되어 짐
// let person = {};
// person.name = '홍길동';
// person.age = 30;

// as 키워드를 사용하여 해당 타입으로 간주하라고 알려줌
// 개발자가 직접 타입을 단언
// let person: Person
let person = {} as Person;
person.name = '홍길동';
person.age = 30;

type Dog = {
   name: string;
   color: string;
};

// 객체리터럴 사용 시, 초과 프로퍼티 검사 발동
// Dog타입에 존재하지 않는 breed속성에 대해 허용하지 않음
// let dog: Dog = {
//    name: '댕댕이',
//    color: 'white',
//    breed: '푸들',
// };

// breed 속성을 추가해야 하는 상황
// 타입 단언으로 해결
// 값의 타입을 직접 단언
let dog = {
   name: '댕댕이',
   color: 'white',
   breed: '푸들',
} as Dog;

/**
 * 타입 단언을 사용하기 위한 규칙
 * 단언식 => 값 as 단언
 * A as B
 * A가 B의 슈퍼타입이거나,
 * A가 B의 서브타입이어야 함
 * 즉, 겹치는 부분이 존재해야 단언 가능
 */

//예시 1
let num1 = 10 as never;
// 10 : numberType
// nerver : 모든 타입의 서브타입
// 숫자 10이, nerver의 슈퍼타입

//예시 2
// A = B의 슈퍼타입O
// A = B의 서브타입O
let num2 = 10 as never; //let num2: never
let num3 = 10 as unknown; //let num3: unknown

//예시 3
// a: number, b: string
// 교집합 X
// A = B의 슈퍼타입X
// A = B의 서브타입X
let num4 = 10 as string;

// 어떤식으로든 단언하는 방법
// 다중 단언
// *좋은 방법이 아님
let num5 = 10 as unknown as string;

/**
 * const 단언
 */

// number타입으로 추론된 변수에 const 단언
let num6 = 10 as const;
// const를 사용한 것과 동일한 효과를 냄
// const 단언은 객체 타입에서 활용도가 있음

// 이랬던 객체가
// let cat1: {
//    name: string;
//    color: string;
// }
let cat1 = {
   name: '야옹이',
   color: 'gray',
};

//readonly로 추론됨
// let cat: {
//    name: string;
//    color: string;
// }
let cat2 = {
   name: '야옹이',
   color: 'gray',
} as const;

// 속성을 재 할당 할 수 없게 됨
cat2.name = '페르시안';

/**
 * Non Null 단언
 * 값이 null이거나 undefined가 아님을
 * 타입스크립트 컴파일러에게 알려주는 역할
 */
//게시판을 만드는 상황 가정
type Post1 = {
   title: string;
   author: string;
};

// 익명 게시판의 경우, author가 필요하지 않음
// author 항목을 옵셔널로 정의
type Post2 = {
   title: string;
   author?: string;
};

let post1: Post2 = {
   title: 'typeScript',
   author: 'typescript',
};
// 작성자의 이름을 계산
// 옵셔널 연산자로 인해
// 값이 없으면 오류를 반환하지 않고
// undefined를 반환

// len => number Type
// post1.author?.length => undefined를 반환할 가능성
const len1: number = post1.author?.length;

// 이럴 때 non-null 단언 사용
// '!'를 사용하여 해당 값이 null이거나 undefined가 아니라고 전달
const len2: number = post1.author!.length;

// 단언 !== 업캐스팅 || 다운캐스팅
// like 눈 속임수

// 단언 사용에 주의
