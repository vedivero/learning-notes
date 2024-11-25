// void => 공허 => 아무 것도 없다.
// void => 아무 것도 없음을 의미하는 타입

// 문자열을 return
function func1(): string {
   return 'hello';
}

// 아무 것도 return하지 않을 때 사용
function func2(): void {
   console.log('hello');
}

// void대신 undefined을 사용하게 되면
// undefined을 반환하도록 해야한다
function func3(): undefined {
   return;
}

// 마찬가지로 null로 지정하게 되면
// null을 return 해야한다.
function func4(): null {
   return null;
}
