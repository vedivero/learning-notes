/**
 * unknown
 */

// 모든 타입의 슈퍼타입
// 모든 값을 할당할 수 있음
// = 모든 값을 업캐스팅 가능
function unknownExam() {
   let a: unknown = 1;
   let b: unknown = 'hello';
   let c: unknown = true;
   let d: unknown = null;
   let e: unknown = undefined;

   // 반대로 다운캐스팅은 불가능
   let unknownVar: unknown;
   //let num:number= unknownVar;
   //let str:string= unknownVar;
   //let bool:boolean= unknownVar;
}

/**
 * Never
 */

// 공집합
// never타입은 모든 타입의 서브 타입
// 모든 never타입은 다른 타입에 할당 가능
// => 업캐스팅
function neverExam() {
   //반환할 수 있는 값이 아무 것도 없다.
   function neverFunc(): never {
      while (true) {}
   }
   let num: number = neverFunc();
   let str: string = neverFunc();
   let bool: boolean = neverFunc();

   // 다른 타입을 never타입에 할당 불가능
   //let never1: never = 10;
   //let never2: never = 'string';
   //let never3: never = true;
}
// 어떠한 값도 저장되면 안되는 변수로 활용

/**
 * void
 */
function voidExam() {
   function voidFunc(): void {
      console.log('void type');
      //return undefined;
   }
   // void type = super type of undefined type
   let voidVar: void = undefined;
}

/**
 * any
 */

// 타입 계층도를 완벽히 무시하는 타입
// 모든 타입의 슈퍼타입 or 모든 타입의 서브타입(never제외)

function anyExam() {
   let unknownVar: unknown;
   let anyVar: any;
   let undefinedVar: undefined;
   let neverVar: never;

   // 다운 캐스팅 가능(치트키 타입)
   // 왠만하면 사용하지 않는 것이 좋음
   anyVar = unknownVar;
   undefinedVar = anyVar;

   // nerver 타입에는 그 어떠한 타입도 다운캐스팅 할 수 없음
   //neverVar=anyVar;
}
