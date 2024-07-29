import { useState, useMemo, useContext } from 'react';
import './List.css';
import TodoItem from './TodoItem';
import { TodoStateContext } from '../App';

const List = () => {
  const todos = useContext(TodoStateContext);

  const [search, setSearch] = useState('');

  const onChangeSearch = (e) => {
    setSearch(e.target.value);
  };

  const getFilteredData = () => {
    if (search === '') {
      return todos;
    }
    return todos.filter((todo) => todo.content.toLowerCase().includes(search.toLowerCase()));
  };

  const filteredTodos = getFilteredData();

  //첫 번째 인수: 콜백함수, 두 번째 인수:배열(의존성 배열 : deps)
  //deps에 포함된 값이 변경되었을떄에만
  //첫 번째 인수로 전달한 콜백함수를 다시 실행
  const { totalCount, doneCount, notDoneCount } = useMemo(() => {
    console.log('getAnalyzedData 호출');
    //memoization하고 싶은 연산
    const totalCount = todos.length; //초기화
    const doneCount = todos.filter((todo) => todo.isDone).length; //전체 todo 중, 완료된 todo의 개수
    const notDoneCount = totalCount - doneCount; //완료되지 않은 todo 개수
    //구한 todo의 값을 순서대로 return
    return {
      totalCount,
      doneCount,
      notDoneCount,
    };
  }, [todos]);
  //list 컴포넌트가 호출될 때 마다, count를 연산
  //const { totalCount, doneCount, notDoneCount } = getAnalyzedData();

  return (
    <div className='List'>
      <h4>Todo List🪴</h4>
      <div>전체 할 일 : {totalCount}</div>
      <div>완료된 할 일 : {doneCount}</div>
      <div>아직 해야할 할 일 : {notDoneCount}</div>
      <input value={search} onChange={onChangeSearch} placeholder='검색어를 입력해 주세요.' />
      <div className='todos_wrapper'>
        {filteredTodos.map((todo) => {
          //리스트 형태로 랜더링된 컴포넌트 요소들을 구분할 때 `key`를 사용
          return <TodoItem key={todo.id} {...todo} />;
        })}
      </div>
    </div>
  );
};

export default List;
