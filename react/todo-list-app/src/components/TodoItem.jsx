import { TodoDispatchContext } from '../App';
import './TodoItem.css';
import { memo, useContext } from 'react';

const TodoItem = ({ id, isDone, content, date }) => {
  const { onUpdate, onDelete } = useContext(TodoDispatchContext);

  const onChageCheckBox = () => {
    onUpdate(id);
  };

  const onClickDeleteButton = () => {
    onDelete(id);
  };

  return (
    <div className='TodoItem'>
      <input onChange={onChageCheckBox} readOnly checked={isDone} type='checkbox' />
      <div className='content'>{content}</div>
      <div className='date'>{new Date(date).toLocaleDateString()}</div>
      <button onClick={onClickDeleteButton}>삭제</button>
    </div>
  );
};

//export default TodoItem;

//todoItem이 가지고 있는 (id, isDone, content, date, onUpdate, onDelete)
//Props가 변경되지 않는 이상 리랜더링 되지 않는다
// /export default memo(TodoItem, (prevProps, nextProps) => {
//반환값에 따라, Props가 바뀌었는지 판단
// T -> Props가 바뀌지 않음 -> 리랜더링 X
// F -> Props가 바뀜 -> 리랜더링 O
//   if (prevProps.id !== nextProps.id) return false;
//   if (prevProps.isDone !== nextProps.isDone) return false;
//   if (prevProps.content !== nextProps.content) return false;
//   if (prevProps.date !== nextProps.date) return false;

//   return true;
// });
export default memo(TodoItem);
