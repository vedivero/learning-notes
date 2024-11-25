import { useState, useRef, useReducer, useCallback, createContext, useMemo } from 'react';
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

function reducer(state, action) {
  switch (action.type) {
    case 'CREATE':
      return [action.data, ...state];
    case 'UPDATE':
      return state.map((item) =>
        item.id === action.targetId ? { ...item, isDone: !item.isDone } : item,
      );
    case 'DELETE':
      return state.filter((item) => item.id !== action.targetId);
    default:
      return state;
  }
}

//createContext 주로 컴포넌트 외부에 선언
//데이터를 하위 컴포넌트에 공급

//변화할 값을 담을 컨텍스트
export const TodoStateContext = createContext();
//변하지 않을 값을 담을 컨텍스트
export const TodoDispatchContext = createContext();

function App() {
  const [todos, dispatch] = useReducer(reducer, mockData);
  const idRef = useRef(3);

  const onCreate = useCallback((content) => {
    dispatch({
      type: 'CREATE',
      data: {
        id: idRef.current++,
        isDone: false,
        content: content,
        date: new Date().getTime(),
      },
    });
  }, []);

  const onUpdate = useCallback((targetId) => {
    dispatch({
      type: 'UPDATE',
      targetId: targetId,
    });
  }, []);

  //첫 번째로 전달한 콜백함수를 그대로 생성해서 반환
  const onDelete = useCallback((targetId) => {
    //마운트되었을 때 딱 한번만 생성
    //리랜더링 되지 않음
    dispatch({
      type: 'DELETE',
      targetId: targetId,
    });
  }, []);

  //TodoDispatchContext 객체를
  //( onCreate, onUpdate, onDelete의 3개의 함수를 묶어주는)
  //다시 생성하지 않도록
  const memoizedDispatch = useMemo(() => {
    return { onCreate, onUpdate, onDelete };
  }, []); //두번째 인수로는 빈 배열을 전달하여 이 객체 값이 앱 컴퍼넌트 이후에는 다시 재생성되지 않도록 설정

  return (
    <div className='App'>
      <Header />
      <TodoStateContext.Provider value={todos}>
        <TodoDispatchContext.Provider value={memoizedDispatch}>
          <Editor />
          <List />
        </TodoDispatchContext.Provider>
      </TodoStateContext.Provider>
    </div>
  );
}

export default App;
