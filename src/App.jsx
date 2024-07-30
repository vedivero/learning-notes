import './App.css';
import { useState } from 'react';
import Home from './pages/Home';
import New from './pages/New';
import Diary from './pages/Diary';
import Notfound from './pages/Notfound';
import { Routes, Route, Link, useNavigate } from 'react-router-dom';

//  1. "/" : 모든 일기를 조회하는 Home page
//  2. "/new" : 새로운 일기를 작성하는 새로운 페이지
//  3. "/diary" : 일기를 상세히 조회하는 Diary 페이지
function App() {
  const nav = useNavigate();

  //특정 조건에서 페이지를 이동시킬 때 useNavigate사용
  const onClickButton = () => {
    nav('/new');
  };

  return (
    <>
      <div>
        <Link to={'/'}>Home</Link>
        <Link to={'/new'}>New</Link>
        <Link to={'/diary'}>Diary</Link>
      </div>
      <button onClick={onClickButton}>New 페이지로 이동</button>
      <Routes>
        <Route path='/' element={<Home />} />
        <Route path='/new' element={<New />} />
        <Route path='/diary/:id' element={<Diary />} />
        <Route path='*' element={<Notfound />} />
      </Routes>
    </>
  );
}

export default App;
