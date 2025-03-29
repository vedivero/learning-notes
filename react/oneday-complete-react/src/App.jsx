import { useEffect, useState } from 'react';
import './App.css';

function App() {
   const [count, setCount] = useState(1);
   const [text, setText] = useState('');
   // 1. 두 번째 인자를, 설정하지 않은 경우
   //첫 번째 인자로 함수 설정
   // useEffect(() => {
   //    console.log('업데이트');
   // });
   // =
   // 두 번째 인자를 설정하지 않았으므로
   // 컴포넌트가 업데이트 될 때 마다
   // 첫 번째 인자의 콜백 함수가 호출

   // 2. 두 번째 인자를, [] 빈 배열로 설정한 경우
   useEffect(() => {
      console.log('업데이트');
   }, []);
   // =
   // 두 번째 인자를 빈 배열로 설정했으므로
   // 컴포넌트가 마운트 될 때만
   // 첫 번째 인자의 콜백 함수가 호출

   // 3. 두 번째 인자에, 특정 값을 설정한 경우
   useEffect(() => {
      console.log('업데이트');
   }, [text, count]);
   // =
   // 두 번째 인자를 빈 배열로 설정했으므로
   // 컴포넌트가 마운트 될 때만
   // 첫 번째 인자의 콜백 함수가 호출

   // 결론
   // 설정해놓은 두 번째 인자에 따라
   // 첫 번째 인자의 콜백 함수가 실행

   const handleCountUpdate = () => {
      setCount(count + 1);
   };

   const handelInputChange = (e) => {
      setText(e.target.value);
   };

   return (
      <div>
         <div>Count : {count}</div>
         <button onClick={handleCountUpdate}>추가</button>
         <input type='text' onChange={handelInputChange} />
         <div> Input Text : {text}</div>
      </div>
   );
}

export default App;
