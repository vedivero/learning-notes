import './List.css';
import TodoItem from './TodoItem';
const List = ({ todos }) => {
  return (
    <div className='List'>
      <h4>Todo List🪴</h4>
      <input placeholder='검색어를 입력해 주세요.' />
      <div className='todos_wrapper'>
        {todos.map((todo) => {
          //리스트 형태로 랜더링된 컴포넌트 요소들을 구분할 때 `key`를 사용
          return <TodoItem key={todo.id} {...todo} />;
        })}
      </div>
    </div>
  );
};

export default List;
