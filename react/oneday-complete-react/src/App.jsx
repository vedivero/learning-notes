import { useContext } from 'react';
import './App.css';
import { userContext } from './user';
import { BalckChild } from './Child';

export default function App() {
   const user = useContext(userContext);

   return (
      <>
         {user.name}
         <BalckChild />
      </>
   );
}
