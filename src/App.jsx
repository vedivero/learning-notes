import { useState, useRef } from 'react';
import './App.css';
import Editor from './components/Editor';
import Header from './components/Header';
import List from './components/List';

//테스트를 위한 임시 테이터. 각각의 todoItem을 객체형태로 저장
//다시 생성하지 않도록 컴포넌트 외부에 선언
const mockData = [
  {
    id: 0,
    isDone: false,
    content: 'React 공부하기',
    date: new Date().getTime(),
  },
  {
    id: 1,
    isDone: false,
    content: '운동하기',
    date: new Date().getTime(),
  },
  {
    id: 2,
    isDone: false,
    content: '청소하기',
    date: new Date().getTime(),
  },
];

function App() {
  const [todos, setTodos] = useState(mockData);
  const idRef = useRef(3);
  const onCreate = (content) => {
    //할 일 객체
    const newTodo = {
      id: idRef.current++,
      isDone: false,
      content: content,
      date: new Date().getTime(), //현재 시간
    };

    //할 일 객체를 > `todos`배열에 추가
    setTodos([newTodo, ...todos]);
  };

  const onUpdate = (targetId) => {
    // todos State 값들 중 targetID와 일치하는 id값을 갖는 todo의 isDone 변경
    setTodos(
      todos.map((todo) => (todo.id === targetId ? { ...todo, isDone: !todo.isDone } : todo)),
    );
  };

  const onDelete = (targetId) => {
    //기존 todos 배열에서 targetId와 일치하는 id를 갖는 요소만 삭제시킨 새로운 배열
    setTodos(todos.filter((todo) => todo.id !== targetId));
  };

  return (
    <div className='App'>
      <Header />
      <Editor onCreate={onCreate} />
      <List todos={todos} onUpdate={onUpdate} onDelete={onDelete} />
    </div>
  );
}

export default App;
