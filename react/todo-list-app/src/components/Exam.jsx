import { useReducer } from 'react';

//reducer : 변환기
//상태를 변화시키는 역할
function reducer(state, action) {
  switch (action.type) {
    case 'INCREASE':
      return state + action.data;
    case 'DECREASE':
      return state - action.data;
    default:
      return state;
  }
}

const Exam = () => {
  //dispatch :발송하다, 급송하다
  const [state, dispatch] = useReducer(reducer, 0);

  const onClickPlus = () => {
    //상태를 어떻게 변화되길 원하는지
    dispatch({
      //액션 객체
      type: 'INCREASE',
      data: 1,
    });
  };

  const onClickMinus = () => {
    dispatch({
      type: 'DECREASE',
      data: 1,
    });
  };

  return (
    <div>
      <h1>{state}</h1>
      <button onClick={onClickPlus}>+</button>
      <button onClick={onClickMinus}>-</button>
    </div>
  );
};

export default Exam;
