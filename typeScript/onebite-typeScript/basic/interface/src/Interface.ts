/**
 * 인터페이스
 */

// 객체 타입을 정의하는 데 특화

// 타입 별칭에서는 유니온 타입 선언이 가능한 반면
type Type = number | string;
// 인터페이스는 유니온이 불가능
// 타입을 사용하던지
// 타입 주석을 활용

//interface Person {
// 'I'를 붙이는 표기법 : 헝가리안 표기법
interface IPerson {
   //enum을 만들때와 동일
   readonly name: string;
   age?: number;
   sayHi: () => void; // 메서드 타입 정의 - 함수 타입 표현식
   //sayHi(): void; // 메서드 타입 정의 - 호출 시그니처

   // 함수 타입 표현식의 오버로딩 구현
   // 식별자가 중복되는 오류 발생
   sayHi: () => void;
   sayHi: (a: number, b: number) => void;

   // 호출 시그니처 사용시 해결
   sayHi(): void;
   sayHi(a: number, b: number): void;
}

const person: Person = {
   name: '홍길동',
   //age: 27,
   sayHi: function () {
      console.log('hello');
   },
};

//person.name = '임꺽정'

// 함수 오버로딩을 sayHi 메서드에 구현할 때
// 함수 타입 표현식 X
// 호출 시그니처 O
person.sayHi();
person.sayHi(1, 2);
