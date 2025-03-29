import { useState } from 'react';
import './App.css';

//서버로 부터 응답 받는 데이터로 초기값 지정
function queryItemsFromServer() {
   return ['홍길동', '임꺽정'];
}

function App() {
   const [items, setItems] = useState(queryItemsFromServer);
   const [value, setValue] = useState('');

   const handleInputChange = (e) => {
      setValue(e.target.value);
   };

   const handleAddClick = () => {
      // setItems([...items, value]);

      setItems((previusState) => {
         return [...previusState, value];
      });
   };

   return (
      <div>
         <input value={value} onChange={handleInputChange} type='text' />
         <button onClick={handleAddClick}>추가</button>
         {items.map((name, index) => (
            <p key={index}>{name}</p>
         ))}
      </div>
   );
}

export default App;
