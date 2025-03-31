import { useEffect, useLayoutEffect } from 'react';
import './App.css';

export default function App() {
   //  웹 페이지 렌더링 후, useEffect의 콜백 함수 실행
   useEffect(() => {
      console.log('useEffect 콜백함수 실행');
   });

   // useLayoutEffect의 콜백 함수가 먼저 실행 후, 웹 페이지 렌더링
   // App 컴포넌트와 useEffect 사용 컴포넌트의 시간 차 렌더링을 해결하기 위함
   useLayoutEffect(() => {
      console.log('useLayoutEffect 콜백함수 실행');
   });

   return <></>;
}
