import { useEffect, useRef } from 'react';
import './App.css';
import CustomInput2 from './CustomInput2';

export default function App() {
   const inputRef = useRef();

   useEffect(() => {
      inputRef.current.focus();
   }, []);

   const login = () => {
      alert('반갑습니다.' + inputRef.current.getValue() + '님');
   };

   return (
      <>
         <CustomInput2 ref={inputRef} label='아이디' />
         <button onClick={login}>Login</button>
      </>
   );
}
