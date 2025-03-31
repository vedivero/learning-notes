import { createContext } from 'react';

// userContext는 Context 객체
// 해당 Context의 Provider로 감싸진 하위 컴포넌트에서
// useContext(userContext)로 접근 가능
export const userContext = createContext({
   name: '홍길동',
   getToday: () => {
      return new Date().toLocaleDateString();
   },
});
