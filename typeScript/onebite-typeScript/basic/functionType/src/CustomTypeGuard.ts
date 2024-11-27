/**
 * 사용자 정의 타입 가드
 *
 * 함수를 이용하여 원하는대로
 * 타입 가드를 만드는 문법
 */

type Dog = {
   name: string;
   isBark: boolean;
};

type Cat = {
   name: string;
   isScratch: boolean;
};

type Animal = Dog | Cat;

function isDog(animal: Animal): animal is Dog {
   //Dog타입일 경우 true return
   //Cat타입일 경우 false return
   return (animal as Dog).isBark !== undefined;
}

function isCat(animal: Animal): animal is Cat {
   return (animal as Cat).isScratch !== undefined;
}

function warning(animal: Animal) {
   //서로소 유니온 타입을 사용하지 못한다고 가정
   // 이렇게 프로퍼티를 기준으로 타입을 좁히면
   // 직관적으로도 좋지 않고
   // 프로퍼티 명칭이 변경되면 타입이 불정확해짐
   //    if ('isBark' in animal) {
   //    } else if ('isScratch' in animal) {
   //    }
   // 이럴 때 사용자 정의 타입 가드를 사용
   if (isDog(animal)) {
      animal;
   } else if (isCat(animal)) {
      animal;
   }
}
