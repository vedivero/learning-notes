// any: 모든, 누구나
// 특정 변수의 타입을 확실히 알 수 없을 경우 사용
let anyVar: any = 10;
anyVar = 'hello';

anyVar = true;
anyVar = {};
anyVar = () => {};

anyVar.toUpperCase();
anyVar.toFixed();

let num: number = 10;
num = anyVar;

// any Type은 타입 검사를 하지 않기 때문에
// 가능한 사용하지 않는 것이 좋음
