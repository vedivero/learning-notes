import { useEffect, useRef } from 'react';
import './App.css';

function App() {
   // useRef의 또 다른 사용처 -> DOM객체를 참조

   const inputRef = useRef(); // inputRef의 current가 input의 DOM을 참조하게 됨

   const login = () => {
      alert(`환영합니다 , ${inputRef.current.value}`);
   };

   useEffect(() => {
      inputRef.current.focus(); // input 태그 DOM을 참조 중
   }, []);

   return (
      <div>
         <input ref={inputRef} type='text' placeholder='사용자 이름' />
         <button onClick={login}>로그인</button>
      </div>
   );
}

export default App;
