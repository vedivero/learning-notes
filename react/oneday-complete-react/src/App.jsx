import { useState } from 'react';
import './App.css';
import { BlackChild } from './Child';
import { CountContext } from './count';

export default function App() {
   const [count, setCount] = useState(0);
   return (
      <>
         <button
            onClick={() => {
               setCount(count + 1);
            }}
         >{`count: ${count}`}</button>

         <CountContext.Provider value={{ count, setCount }}>
            <BlackChild />
         </CountContext.Provider>
      </>
   );
}
