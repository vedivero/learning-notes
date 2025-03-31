import { useRef, useState } from 'react';
import './App.css';

function App() {
   console.log('렌더링');
   const [count, setCount] = useState(0);
   const countRef = useRef(0);
   let value = 0;

   const increaseCount = () => {
      setCount(count + 1);
   };

   const increaseRefCount = () => {
      countRef.current += 1; // 값은 유지하면서, 렌더링은 피하는 방법
      console.log('ref : ', countRef.current);
   };

   const increaseVariable = () => {
      value += 1; // 값이 변경되도 컴포넌트가 랜더링 되지 않음, 0 으로 초기화
      console.log('value : ', value);
   };

   return (
      <>
         <p>State : {count}</p>
         <p>Ref : {countRef.current}</p>
         <p>Variable : {value}</p>
         <button onClick={increaseCount}>State +1</button>
         <button onClick={increaseRefCount}>Ref +1</button>
         <button onClick={increaseVariable}>value +1</button>
      </>
   );
}

export default App;
