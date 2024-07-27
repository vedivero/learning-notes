import './Header.css';
import { memo } from 'react';

const Header = () => {
  return (
    <div className='Header'>
      <h3>Today is 📆</h3>
      <h1>
        {new Date().toLocaleDateString('ko-KR', {
          year: 'numeric',
          month: 'long',
          day: 'numeric',
          weekday: 'long',
        })}
      </h1>
    </div>
  );
};
//인수로 받은 Header 컴포넌트를 Props가 변경되지 않았을 때에는 리랜더링 하지 않도록 최적화
//const memoizedHeader = memo(Header);
//export default memoizedHeader; //최적화가 된 memoizedHeader를 내보내기
export default memo(Header);
