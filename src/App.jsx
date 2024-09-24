import { Route, Routes, useNavigate } from 'react-router-dom';
import './App.css';
import ChatPage from './pages/ChatPage/ChatPage';
import LoginPage from './pages/LoginPage/LoginPage';
import RegisterPage from './pages/RegisterPage/RegisterPage';
import { useEffect } from 'react';
import app from './firebase';
import { getAuth, onAuthStateChanged } from 'firebase/auth';
import { useDispatch } from 'react-redux';
import { clearUser, setUser } from './store/userSlice';

function App() {
   const auth = getAuth(app);
   const navigate = useNavigate();
   const dispatch = useDispatch();

   useEffect(() => {
      //user상태가 change될 때 마다 호출
      const unsubscribe = onAuthStateChanged(auth, (user) => {
         if (user) {
            //미 로그인 -> 로그인
            navigate('/');
            dispatch(
               setUser({
                  uid: user.uid,
                  displayName: user.displayName,
                  photoURL: user.photoURL,
               }),
            );
         } else {
            navigate('/login');
            dispatch(clearUser());
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
