/**
 * 함수 오버로딩
 * 하나의 함수를
 * 매개 변수 or 타입에 따라
 * 여러 가지 함수로 선언하는 문법
 */

// 함수 : func
// 모든 매개 변수 타입 : number
// 1. 매개 변수 1개 => 곱하기 20 출력
// 2. 매개 변수 3개 => 다 더한 값 출력

// 타입 스크립트에서 오버로딩 구현하기 위한 조건
// 함수 버전에 대한 정보 -> 오버로드 시그니처
function func(a: number): void;
function func(a: number, b: number, c: number): void;

// 실제 구현부 -> 구현 시그니처

// 이 오버로드 시그니처는 해당 구현 시그니처와 호환되지 않습니다.
// 매개 변수가 3개 있다고 정의하면
// 첫 번째  오버로드 시그니처 존재의 의미가 사라짐
function func(a: number, b: number, c: number) {}

//이렇게 옵셔널을 사용해서 모든 오버로드 시그니처가 의미 있게 설정
function func(a: number, b?: number, c?: number) {
   if (typeof b === 'number' && typeof c === 'number') {
      console.log(a + b + c);
   } else {
      console.log(a * 20);
   }
}

func();
func(1);
func(1, 2);
func(1, 2, 3);
