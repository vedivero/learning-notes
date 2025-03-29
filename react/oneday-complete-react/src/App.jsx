import { useState } from 'react';
import './App.css';

function App() {
   const [value, setValue] = useState(0);
   const handleClick = () => {
      setValue(value + 1);
   };
   return (
      <div>
         <span>증가값 : {value}</span>
         <button onClick={handleClick}>증가</button>
      </div>
   );
}

export default App;
