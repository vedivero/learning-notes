import { useContext } from 'react';
import { userContext } from './user';

export function BalckChild() {
   const user = useContext(userContext);
   return (
      <>
         <div style={{ margin: '5px', padding: '5px', border: '5px solid black' }}>{user.name}</div>
         <div style={{ margin: '5px', padding: '5px', border: '5px solid black' }}>{user.getToday()}</div>
      </>
   );
}
