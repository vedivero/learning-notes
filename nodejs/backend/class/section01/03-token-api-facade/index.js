//facade pattern

//1. 휴대폰 번호 자리수 확인
function checkPhone(number) {
   if (number.length < 10 || number.length > 11) {
      //false인 경우를 먼저 사용하기, 에러 처리를 먼저하기
      console.log('핸드폰 번호가 올바르게 입력되지 않았습니다.');
      return false; //해당 함수만 종료
   } else {
      return true;
   }
}

//2. 핸드폰 토큰 6자리 생성
function getToken() {
   const token = String(Math.floor(Math.random() * 1000000)).padStart(6, 0);
   console.log(token);
   return token;
}

//3. 토큰 전송하기
function sendTokenToSMS(number, myToken) {
   console.log(number + ' 번호로 토큰"' + myToken + '"을 전송했습니다.');
}

function createTokenOfPhone(number) {
   //1. 휴대폰 번호 자리수 확인
   const isValid = checkPhone(number);
   if (isValid === false) return;
   //2. 핸드폰 토큰 6자리 생성
   const myToken = getToken();
   //3. 토큰 전송하기
   sendTokenToSMS(number, myToken);
}

createTokenOfPhone('01012344321');
