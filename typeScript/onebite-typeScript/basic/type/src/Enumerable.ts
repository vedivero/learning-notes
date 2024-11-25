// enum 타입
// 여러가지 값 들에 각각 이름을 부여해 열거해두고 사용하는 타입
enum Role {
   ADMIN = 0,
   USER = 1,
   GUEST = 2,
}
enum Role2 {
   ADMIN = 10,
   USER,
   GUEST,
}
enum Language {
   korean = 'ko',
   english = 'en',
}

const user1 = {
   name: '홍길동',
   role: 0, // 0: 관리자
};

const user2 = {
   name: '임꺽정',
   role: 1, // 1: 일반 회원
};

const user3 = {
   name: '아무개',
   role: 2, // 2: 게스트
};

// role 역할의 값에 대한 실수할 가능성이 높음
const user11 = {
   name: '홍길동',
   role: Role2.ADMIN, // 0: 관리자
};

const user22 = {
   name: '임꺽정',
   role: Role2.USER, // 1: 일반 회원
};

const user33 = {
   name: '아무개',
   role: Role2.GUEST, // 2: 게스트
   Language: Language.korean,
};

console.log(user11, user22, user33);
