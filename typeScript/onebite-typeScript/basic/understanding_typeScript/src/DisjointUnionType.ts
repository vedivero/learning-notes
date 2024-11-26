/**
 * 서로소 유니온 타입
 *
 * 교집합이 없는 타입들로만 만든 유니온 타입
 * 두 타입 간의 공통점이 하나도 없는 타입
 */

// 예시 : 회원 관리 기능

// 기본 타입 선언
// type Admin = {
//    name: string;
//    kickCount: number;
// };

// type Member = {
//    name: string;
//    point: number;
// };

// type Guest = {
//    name: string;
//    visitCount: number;
// };

// 직관적으로 파악할 수 있도록 처리
type Admin = {
   tag: 'ADMIN';
   name: string;
   kickCount: number;
};

type Member = {
   tag: 'MEMBER';
   name: string;
   point: number;
};

type Guest = {
   tag: 'GUEST';
   name: string;
   visitCount: number;
};

type User = Admin | Member | Guest;

// 로그인 시 출력할 메세지
// Admin -> {name}님 현재까지 {kickCount}명 강퇴했습니다.
// Member -> {name}님 현재까지 {point} 포인트를 모았습니다.
// Guest -> {name}님 현재까지 {visitCount}번 방문했습니다.
function login1(user: User) {
   // Admin
   //if ('kickCount' in user) { // 이 조거문을 아래와 같이 변경

   if (user.tag === 'ADMIN') {
      console.log(`${user.name}님 현재까지 ${user.kickCount}명 강퇴했습니다.`);
   }
   // Member
   else if (user.tag === 'MEMBER') {
      console.log(`${user.name}님 현재까지 ${user.point} 포인트를 모았습니다.`);
   }
   // Guest
   else {
      console.log(`${user.name}님 현재까지 ${user.visitCount}번 방문했습니다.`);
   }
}

// 위 코드를 타인이 봤을 때
// 직관적으로 파악하기 힘든 코드
// 코드 리뷰 시, 타입을 확인하는 번거로움

// 해결
// 타입에 tag 속성 추가

// switch-case문을 사용하면 더 직관적으로 처리 가능
function login2(user: User) {
   switch (user.tag) {
      case 'ADMIN': {
         console.log(`${user.name}님 현재까지 ${user.kickCount}명 강퇴했습니다.`);
         break;
      }
      case 'MEMBER': {
         console.log(`${user.name}님 현재까지 ${user.point} 포인트를 모았습니다.`);
         break;
      }
      case 'GUEST': {
         console.log(`${user.name}님 현재까지 ${user.visitCount}번 방문했습니다.`);
         break;
      }
   }
}

/**
 * 비동기 작업의 결과를 처리하는 객체
 */

// 3가지 응답 객체를 다 표현할 수 있는 타입 생성
type AsyncTask = {
   state: 'LOADING' | 'FAILED' | 'SUCCESS';
   error?: {
      message: string;
   };
   response?: {
      data: string;
   };
};

// 비동기 작업 처리 결과를 함수의 매개변수로 받아
// 상태에 따라 처리하는 함수
function processResult(task: AsyncTask) {
   switch (task.state) {
      // 로딩 중
      case 'LOADING': {
         console.log('LOADING');
         break;
      }
      // 실패
      case 'FAILED': {
         console.log(`${task.error.message}`);
         break;
      }
      // 성공
      case 'SUCCESS': {
         console.log(`${task.response?.data}`);
         break;
      }
   }
}

// 위 코드에서 각 case문의 옵셔널 체이닝을 제거하면
// 오류 발생
// case가 failed인 경우에도 타입이 좁혀지지 않음
// (parameter) task: AsyncTask
// => 타입이 AsyncTask로 되어 있음
// 타입 정의를 보면, error의 유무를 확실하게 알 수 없음
// 즉, 좁혀질 타입이 없음
// 해결 방법 1. 옵셔널 체이닝
// 해결 방법 2. non-null 단언 (!)`
// 해결 방법 3. AsyncTask를 3개의 타입으로 분리

const loading: AsyncTask = {
   state: 'LOADING',
};

const failed: AsyncTask = {
   state: 'FAILED',
   error: {
      message: '오류 발생',
   },
};

const success: AsyncTask = {
   state: 'SUCCESS',
   response: {
      data: 'data',
   },
};

// 해결 방법 3. AsyncTask를 3개의 타입으로 분리

type LoadingTask = {
   state: 'LOADING';
};
type FailedTask = {
   state: 'FAILED';
   error: {
      message: string;
   };
};
type SuccessTask = {
   state: 'SUCCESS';
   response: {
      data: string;
   };
};

type AsyncTask2 = LoadingTask | FailedTask | SuccessTask;

function processResult2(task: AsyncTask2) {
   switch (task.state) {
      // 로딩 중
      case 'LOADING': {
         console.log('LOADING');
         break;
      }
      // 실패
      case 'FAILED': {
         console.log(`${task.error.message}`);
         break;
      }
      // 성공
      case 'SUCCESS': {
         console.log(`${task.response.data}`);
         break;
      }
   }
}

// 동시에 여러가지 상태를 표현해야하는 객체 타입 정의에는
// 선택적 프로퍼티보다 상태에 따라서 타입을 나누는 것이 좋음
// 그래야 스위치 케이스문을 이용할 때 더 직관적이고 안전하게
// 타입을 좁혀서 코드를 작성할 수 있기 때문
