import { useContext } from 'react';
import { CountContext } from './count';

export function BlackChild() {
   return (
      <>
         <div style={{ margin: '5px', padding: '5px', border: '5px solid black' }}>
            <GreenChild />
         </div>
      </>
   );
}
export function GreenChild() {
   const { count, setCount } = useContext(CountContext);

   return (
      <>
         <div style={{ margin: '5px', padding: '5px', border: '5px solid green' }}>
            <button
               onClick={() => {
                  setCount(count - 1);
               }}
            >
               count 감소
            </button>
            <BlueChild />
         </div>
      </>
   );
}
export function BlueChild() {
   const { count } = useContext(CountContext);
   return (
      <>
         <div style={{ margin: '5px', padding: '5px', border: '5px solid blue' }}>{count}</div>
      </>
   );
}
