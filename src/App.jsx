import './App.css';
import { useState } from 'react';
import Home from './pages/Home';
import New from './pages/New';
import Diary from './pages/Diary';
import Notfound from './pages/Notfound';
import { Routes, Route } from 'react-router-dom';

//  1. "/" : 모든 일기를 조회하는 Home page
//  2. "/new" : 새로운 일기를 작성하는 새로운 페이지
//  3. "/diary" : 일기를 상세히 조회하는 Diary 페이지
function App() {
  //const [count, setCount] = useState(0);

  return (
    <>
      <Routes>
        <Route path='/' element={<Home />} />
        <Route path='/new' element={<New />} />
        <Route path='diary' element={<Diary />} />
        <Route path='*' element={<Notfound />} />
      </Routes>
    </>
  );
}

export default App;
