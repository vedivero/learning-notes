//안 좋은 소스 코드 예시
// function createTokenOfPhone(number) {
//    //매개변수 parameter

//    //1. 휴대폰 번호 자리수 확인
//    if (number.length === 11) {
//       //2. 핸드폰 토큰 6자리 생성
//       const token = String(Math.floor(Math.random() * 1000000)).padStart(6, 0);
//       console.log(token);
//       //3. 토큰 전송하기
//       console.log(number + ' 번호로 토큰"' + token + '"을 전송했습니다.');
//    } else {
//       console.log('핸드폰 번호가 올바르게 입력되지 않았습니다.');
//    }
// }

//좋은 소스 코드 예시
function createTokenOfPhone(number) {
   //매개변수 parameter

   //1. 휴대폰 번호 자리수 확인
   if (number.length < 10 || number.length > 11) {
      //false인 경우를 먼저 사용하기, 에러 처리를 먼저하기
      console.log('핸드폰 번호가 올바르게 입력되지 않았습니다.');
      return; //함수 종료. return을 만나면 아래 소스 코드를 실행하지 않는다 early-exit
   }

   //2. 핸드폰 토큰 6자리 생성
   const token = String(Math.floor(Math.random() * 1000000)).padStart(6, 0);
   console.log(token);
   //3. 토큰 전송하기
   console.log(number + ' 번호로 토큰"' + token + '"을 전송했습니다.');
}

createTokenOfPhone('01012344321'); //인자 argument
