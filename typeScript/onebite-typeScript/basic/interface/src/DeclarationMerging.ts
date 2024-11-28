/**
 * 선언 합치기
 */

type Person1 = {
   name: string;
};
type Person1 = {
   age: number;
};
// 이렇게 타입을 두 번 정의하면 오류 발생

// 인터페이스는 오류가 발생하지 않는다
// 인터페이스는 결국 합쳐지기 때문 = 선언 합침
interface Person2 {
   name: string;
}
interface Person2 {
   name: number; // 동일한 프로퍼티를 다르게 선언 = 충돌
   name: 'hello'; // 서브 타입으로도 재정의하면 안 된다.
   name: string; // 동일하게 선언해서 사용해야 한다
   age: number;
}

const person: Person2 = {
   name: '',
   age: 1,
};

/**
 * 모듈 보강
 */
interface Lib {
   a: number;
   b: number;
}

//인터페이스 선언 합침을 사용해 모듈 보강
interface Lib {
   c: string;
}

const lib: Lib = {
   a: 1,
   b: 2,
   c: 'hello', // c 프로퍼티를 추가하는 상황
};
