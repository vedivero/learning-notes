import './App.css';
import { useState } from 'react';
import Card from './Card';

export default function App() {
   // age, name 각각의 상태만 update처리
   const [age, setAge] = useState(10);
   const [name, setName] = useState('홍길동');

   return (
      <>
         <div>
            나이 <input value={age} onChange={(e) => setAge(e.target.value)} />
         </div>
         <div>
            이름 <input value={name} onChange={(e) => setName(e.target.value)} />
         </div>
         {/* App 컴포넌트가 리 랜더링 되면, 자식 컴포넌트에도 적용 */}
         <Card name='이름' value={name} />
         <Card name='나이' value={age} />
      </>
   );
}
