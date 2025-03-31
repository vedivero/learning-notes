import { memo } from 'react';

function Card(props) {
   console.log(`Card 컴포넌트 함수 실행(업데이트): ${props.name}`);

   return (
      <div
         style={{
            border: '3px solid blue',
            margin: '5px',
            padding: '10px',
         }}
      >
         {props.value}
      </div>
   );
}

// age, name 각각의 상태만 update처리되도록 memo 사용
export default memo(Card);
