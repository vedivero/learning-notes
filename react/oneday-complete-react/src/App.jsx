import { useEffect, useRef } from 'react';
import './App.css';
import CustomInput from './CustomInput';

export default function App() {
   const refInput = useRef(); // CustomInput 컴포넌트의 input tag를 참조

   useEffect(() => {
      refInput.current.focus();
   }, []);

   return (
      <>
         <CustomInput ref={refInput} label='아이디' />
         <button
            onClick={() => {
               alert(`환영합니다. ${refInput.current.value}`);
            }}
         >
            로그인
         </button>
      </>
   );
}
