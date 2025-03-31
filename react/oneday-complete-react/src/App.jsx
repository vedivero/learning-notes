import { useReducer, useState } from 'react';
import './App.css';

export default function App() {
   // useState
   const [count1, setCount1] = useState(0);

   // useReducer
   const reducer = (currentState, action) => {
      if (action.type === 'inc') return currentState + action.step;
      else if (action.type === 'dec') return currentState - action.step;
      else return currentState;
   };

   const [count2, dispatch] = useReducer(reducer, 0);

   const [step, setStep] = useState(1);

   return (
      <>
         <div>
            <button
               onClick={() => {
                  setCount1(count1 + 1);
               }}
            >
               useState + 1
            </button>{' '}
            <button
               onClick={() => {
                  setCount1(count1 - 1);
               }}
            >
               useState - 1
            </button>{' '}
            <span>{count1}</span>
         </div>

         <input
            value={step}
            onChange={(e) => {
               setStep(e.target.value);
            }}
         />

         <div>
            <button
               onClick={() => {
                  dispatch({ type: 'inc', step: Number(step) });
               }}
            >
               useReducer +
            </button>{' '}
            <button
               onClick={() => {
                  dispatch({ type: 'dec', step: Number(step) });
               }}
            >
               useReducer -
            </button>{' '}
            <span>{count2}</span>
         </div>
      </>
   );
}
