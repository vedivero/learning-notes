import { Outlet, Route, Routes } from 'react-router-dom';
import './App.css';
import LandingPage from './pages/LandingPage';
import LoginPage from './pages/LoginPage';
import RegisterPage from './pages/RegisterPage';
import Navbar from './layout/NavBar';
import Footer from './layout/Footer';
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

function Layout() {
   return (
      <div className='flex flex-col justify-between h-screen'>
         <ToastContainer position='bottom-right' theme='light' pauseOnHover autoClose={2000} />
         <Navbar />
         <main className='w-10/12 max-w-4xl mx-auto mb-auto'>
            <Outlet />
         </main>
         <Footer />
      </div>
   );
}

function App() {
   return (
      <Routes>
         <Route path='/' element={<Layout />}>
            <Route index element={<LandingPage />} />
            <Route path='login' element={<LoginPage />} />
            <Route path='register' element={<RegisterPage />} />
         </Route>
      </Routes>
   );
}

export default App;
