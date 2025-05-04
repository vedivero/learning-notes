//회원가입 시 발송되는 이메일 템플릿
function getWelcomeTemplate({ name, age, createAt }) {
   const mytemplate = `
        <html>
            <body>
                <h1>홍길동님 가입을 환영합니다.</h1>
                <hr/>
                <div>이름 : ${name}</div>
                <div>나이 : ${age}</div>
                <div>가입일 : ${createAt}</div>
            </body>
        </html>
    `;
   console.log(mytemplate);
}

const name = '홍길동';
const age = 20;
const createAt = '2024-08-27';

getWelcomeTemplate({ name, age, createAt });
