import {
   checkEmail,
   getWelcomeTemplate,
   sendTemplateToEmail,
} from './email.js';

function createUser({ name, age, email }) {
   //1. 이메일 유효성 체크(1-존재여부, 2."@"포함여부)
   const isValid = checkEmail(email);
   if (isValid === false) return;
   //2.가입환영 템플릿
   const mytemplate = getWelcomeTemplate({ name, age });
   //3. 이메일로 템플릿 전송
   sendTemplateToEmail(email, mytemplate);
}

const name = '짱구';
const age = 15;
const email = 'zzangu@1.com';
// const createAt = '2024-08-27';

createUser({ name, age, email });
