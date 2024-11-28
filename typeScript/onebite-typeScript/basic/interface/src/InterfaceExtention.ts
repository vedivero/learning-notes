/**
 * 인터페이스 확장
 *
 * 인터페이스만 특별히 사용할 수 있는 독특한 기능
 */

interface Animal {
   name: string;
   age: number;
}

// 중복되는 속성(프로퍼티)이 존재
// Animal 인터페이스에 age속성이 없어진다면,
// 서브 타입의 age속성을 일일이 지워야 함
interface Dog extends Animal {
   // 확장 사용 법
   // 1. 중복 되는 프로퍼티 제거
   // 2. 슈퍼 타입으로 부터 받아오기 extends Animal
   // interface dog는 interface animal을 확장하는 interface
   // 기존 것에 추가하는 의미
   //    name: string;
   //    age: number;
   isBark: boolean;
}

const dog: Dog = {
   // 동일한 프로퍼티의 타입을 다시 정의할 수 있다
   // 규칙: 원본 타입의 서브 타입만 가능
   name: 'hello',
   age: 1,
   isBark: true,
};

interface Cat extends Animal {
   //    name: string;
   //    age: number;
   isScratch: boolean;
}

interface Chicken extends Animal {
   //    name: string;
   //    age: number;
   isFly: boolean;
}

// 다중 확장
interface DogCat extends Dog, Cat {}

const dogCat: DogCat = {
   name: '',
   age: 1,
   isBark: true,
   isScratch: false,
};
