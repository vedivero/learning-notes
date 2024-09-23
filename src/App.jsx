import { Route, Routes, useNavigate } from 'react-router-dom';
import './App.css';
import ChatPage from './pages/ChatPage/ChatPage';
import LoginPage from './pages/LoginPage/LoginPage';
import RegisterPage from './pages/RegisterPage/RegisterPage';
import { useEffect } from 'react';
import app from './firebase';
import { getAuth, onAuthStateChanged } from 'firebase/auth';

function App() {
   const auth = getAuth(app);
   const navigeate = useNavigate();

   useEffect(() => {
      //user상태가 change될 때 마다 호출
      const unsubscribe = onAuthStateChanged(auth, (user) => {
         if (user) {
            //미 로그인 -> 로그인
            navigeate('/');
         } else {
            navigeate('/login');
         }
      });

      return () => {
         unsubscribe();
      };
   }, []);

   return (
      <Routes>
         <Route path='/' element={<ChatPage />} />
         <Route path='/login' element={<LoginPage />} />
         <Route path='/register' element={<RegisterPage />} />
      </Routes>
   );
}

export default App;
