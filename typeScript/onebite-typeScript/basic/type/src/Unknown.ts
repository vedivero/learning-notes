let unknownVar: unknown;

unknownVar = '';
unknownVar = 1;
unknownVar = () => {};

// 여기 까지는 any Type과 동일.
// 단, any와는 다르게 다른 타입에
// unknown 타입을 할당할 수 없음
