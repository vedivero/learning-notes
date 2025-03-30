import { useState } from 'react';
import './App.css';
import Timer from './Timer';

function App() {
   // timer 컴포넌트 표출 제어
   const [showTimer, setShowTimer] = useState(false);

   return (
      <>
         <button onClick={() => setShowTimer(!showTimer)}>타이머 ON/OFF</button>
         {showTimer && <Timer />}
      </>
   );
}

export default App;
