import { useEffect } from 'react';

const Timer = (props) => {
   useEffect(() => {
      console.log('Timer');
      const timer = setInterval(() => {
         console.log('타이머 ON');
      }, 1000);
      return () => {
         clearInterval(timer);
         console.log('타이머 OFF');
      };
   }, []);

   return (
      <div>
         <span>콘솔 타이머 </span>
      </div>
   );
};

export default Timer;
