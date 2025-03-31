import { useMemo, useState } from 'react';
import './App.css';

const calculate = (number) => {
   console.time('계산');
   let result = 0;
   //result += Math.sin(number);
   for (let i = 0; i < 1400000; i++) {
      result += Math.sin(i + number);
   }

   console.timeEnd('계산');
   return result;
};

export default function App() {
   const [inputValue, setInputValue] = useState(1);

   // 연산이 오래 걸리는 동작을 useMemo에 저장함으로써 UI 렌더링 반응 속도 향상
   const calValue = useMemo(() => {
      calculate(inputValue);
   }, [inputValue]); // calculate 함수에 영향을 주는 두 번째 인자의 의존성 배열

   const [count, setCount] = useState(0);
   const increaseCount = () => {
      setCount(count + 1);
   };

   return (
      <div>
         <h3>계산기</h3>
         <input type='number' value={inputValue} onChange={(e) => setInputValue(parseInt(e.target.value))} />
         <div>결과 = {calValue}</div>
         <button onClick={increaseCount}>증가 : {count}</button>
      </div>
   );
}
