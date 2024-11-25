import { useState, useRef, useContext } from 'react';
import './Editor.css';
import { TodoDispatchContext } from '../App';

const Editor = () => {
  //data를 불러오고자 하는 context를 인수로 넣는다
  const { onCreate } = useContext(TodoDispatchContext); //App.jsx에 선언한 `TodoContext`
  const [content, setContent] = useState('');
  const contentRef = useRef();

  const onChangeContent = (e) => {
    setContent(e.target.value);
  };

  //엔터키로 todo 추가
  const onKeydown = (e) => {
    if (e.keyCode === 13) {
      onSubmit();
    }
  };
  const onSubmit = () => {
    //내용이 비었을 경우
    if (content === '') {
      contentRef.current.focus();
      return;
    }
    onCreate(content);
    //할 일 추가후 입력폼 초기화
    setContent('');
  };
  return (
    <div className='Editor'>
      <input
        ref={contentRef}
        value={content}
        placeholder='할 일을 입력해 주세요.'
        onChange={onChangeContent}
        onKeyDown={onKeydown}
      />
      <button onClick={onSubmit}>Add</button>
    </div>
  );
};

export default Editor;
