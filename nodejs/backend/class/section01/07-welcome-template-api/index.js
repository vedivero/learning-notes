function checkEmail(email) {
   if (email === undefined || !email.includes('@')) {
      console.log('Email주소가 올바르지 않습니다.');
      return false;
   } else {
      return true;
   }
}

function getWelcomeTemplate({ name, age, createAt }) {
   const mytemplate = `
         <html>
             <body>
                 <h1>${name}님 가입을 환영합니다.</h1>
                 <hr/>
                 <div>이름 : ${name}</div>
                 <div>나이 : ${age}</div>
                 <div>가입일 : ${createAt}</div>
             </body>
         </html>
     `;
   //console.log(mytemplate);
   return mytemplate;
}

function sendTemplateToEmail(email, mytemplate) {
   console.log(email + ' 이메일로 ' + mytemplate + '"을 전송했습니다.');
}

function createUser({ name, age, email, createAt }) {
   //1. 이메일 유효성 체크(1-존재여부, 2."@"포함여부)
   const isValid = checkEmail(email);
   if (isValid === false) return;
   //2.가입환영 템플릿
   const mytemplate = getWelcomeTemplate({ name, age, createAt });
   //3. 이메일로 템플릿 전송
   sendTemplateToEmail(email, mytemplate);
}

const name = '짱구';
const age = 15;
const email = 'zzangu@1.com';
const createAt = '2024-08-27';

createUser({ name, age, email, createAt });
