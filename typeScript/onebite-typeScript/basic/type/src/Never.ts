// Never => 존재하지 않는 => 불가능한 타입

// 정상적으로 처리되지 않을 함수
// 반환 값이 존재하는 것이 모순되는 경우 사용
function func1(): never {
   while (true) {}
}

// Error로 프로그램이 중지되기 때문에
// 반환 type을 Never로 지정하는게 적합
function func4(): never {
   throw new Error();
}

// 그 어떠한 값도 never Type에는 할당할 수 없다.
let anyVar: any;

let a: never;
a = 1;
a = {};
a = '';
a = undefined;
a = null;
a = anyVar;
