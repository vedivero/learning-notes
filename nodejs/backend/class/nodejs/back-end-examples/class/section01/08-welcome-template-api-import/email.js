import { getToday } from './utils.js';

export function checkEmail(email) {
   if (email === undefined || !email.includes('@')) {
      console.log('Email주소가 올바르지 않습니다.');
      return false;
   } else {
      return true;
   }
}

export function getWelcomeTemplate({ name, age, createAt }) {
   const mytemplate = `
          <html>
              <body>
                  <h1>${name}님 가입을 환영합니다.</h1>
                  <hr/>
                  <div>이름 : ${name}</div>
                  <div>나이 : ${age}</div>
                  <div>가입일 : ${getToday()}</div>
              </body>
          </html>
      `;
   //console.log(mytemplate);
   return mytemplate;
}

export function sendTemplateToEmail(email, mytemplate) {
   console.log(email + ' 이메일로 ' + mytemplate + '"을 전송했습니다.');
}
