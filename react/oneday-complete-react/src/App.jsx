import { useState, useEffect, useCallback } from 'react';
import './App.css';

export default function App() {
   const [color, setColor] = useState('white');
   const [count, setCount] = useState(0);

   // App컴포넌트가 랜더링 될 때 마다, someFunction 함수가 생성 됨
   // useCallBack으로 해결 가능
   // 의존성 배열을 빈 배열[]로 설정 시, 새롭게 정의되는 것은 막았으나, count 값 변경에도 함수를 재 생성하지 않음
   // 의존성 배열을 [count]로 설정 시,
   const someFunction = useCallback(() => {
      console.log(`count 값은 ${count} 입니다.`);
   }, [count]);

   useEffect(() => {
      console.log('someFunction이 새롭게 정의되었습니다.');
   }, [someFunction]);

   return (
      <>
         <div
            style={{
               display: 'flex',
               gap: '2px',
               flexFlow: 'column',
               height: '100px',
               padding: '20px',
               border: '1px solid black',
               backgroundColor: color,
            }}
         >
            <input type='text' value={color} onChange={(e) => setColor(e.target.value)} />
            <button onClick={() => setCount(count + 1)}>{`count: ${count}`}</button>
            <button onClick={someFunction}>함수 실행</button>
         </div>
      </>
   );
}
