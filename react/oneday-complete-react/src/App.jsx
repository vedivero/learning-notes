import { useEffect, useMemo, useState } from 'react';
import './App.css';

export default function App() {
   const [currentTemp, setCurrentTemp] = useState(17);
   const [standardTemp, setStandardTemp] = useState(40);
   // const check = currentTemp > standardTemp ? '위험' : '정상';

   // 아래 객체 형태로 사용 시, 콜백 함수가 계속 실행
   // const check = {
   //   text:currentTemp > standardTemp ?"위험":"정상";
   // }

   // 객체는 메모리 주소(참조값)를 비교함
   // 같은 내용이라도 주소가 다르면 false

   // useMemo를 사용해서 해결
   // 현재 온도가 기준 온도보다 높을 때만 check 객체를 생성하여 값을 할당
   const check = useMemo(() => {
      return {
         text: currentTemp > standardTemp ? '위험' : '정상',
         time: new Date().toLocaleTimeString(),
      };
   }, [currentTemp > standardTemp]);

   useEffect(() => {
      console.log('온도 감지 상황이 변경되었습니다.');
   }, [check]); // check 값이 변경될 때, 콜백 함수 실행

   return (
      <>
         <div>
            <label>현재온도</label>
            <input type='number' value={currentTemp} onChange={(e) => setCurrentTemp(e.target.value)} />
         </div>
         <div>
            <label>기준온도</label>
            <input type='number' value={standardTemp} onChange={(e) => setStandardTemp(e.target.value)} />
         </div>
         <h2>{check.text}</h2>
         <h2>온도 변경 감지 시간 : {check.time}</h2>
      </>
   );
}
