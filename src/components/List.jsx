import { useState } from 'react';
import './List.css';
import TodoItem from './TodoItem';

const List = ({ todos, onUpdate }) => {
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

  return (
    <div className='List'>
      <h4>Todo List🪴</h4>
      <input value={search} onChange={onChangeSearch} placeholder='검색어를 입력해 주세요.' />
      <div className='todos_wrapper'>
        {filteredTodos.map((todo) => {
          //리스트 형태로 랜더링된 컴포넌트 요소들을 구분할 때 `key`를 사용
          return <TodoItem key={todo.id} {...todo} onUpdate={onUpdate} />;
        })}
      </div>
    </div>
  );
};

export default List;
