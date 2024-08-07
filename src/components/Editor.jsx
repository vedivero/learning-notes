import { useState } from 'react';
import Button from './Button';
import './Editor.css';
import EmotionItem from './EmotionItem';

const emotionList = [
  {
    emotionId: 1,
    emotionName: '아주 좋음',
  },
  {
    emotionId: 2,
    emotionName: '좋음',
  },
  {
    emotionId: 3,
    emotionName: '그럭저럭',
  },
  {
    emotionId: 4,
    emotionName: '안 좋음',
  },
  {
    emotionId: 5,
    emotionName: '아주 안 좋음',
  },
];

//Date객체를 문자열로 변환하는 함수
const getStringedDate = (targetDate) => {
  //"YYYY-MM-DD"
  let year = targetDate.getFullYear();
  let month = targetDate.getMonth() + 1;
  let date = targetDate.getDate();

  //10이하의 숫자 처리 (1 -> 01)
  if (month < 10) {
    month = `0${month}`;
  }
  if (date < 10) {
    date = `0${date}`;
  }

  return `${year}-${month}-${date}`;
};

const Editor = ({ onSubmit }) => {
  //사용자가 입력한 값을 저장하는 State
  //날짜, 감정, 내용 저장
  //여러 값을 저장하기 위해 객체로 만들어서 사용
  const [input, setInput] = useState({
    createdDate: new Date(),
    emotionId: 3,
    content: '',
  });

  //사용자가 날짜 설정하는 경우
  const onChangeInput = (e) => {
    let name = e.target.name; //값이 들어온 요소
    let value = e.target.value; //입력된 값

    //문자열로 전달되는 날짜 값을 날짜 객체로 변환
    if (name === 'createdDate') {
      value = new Date(value);
    }

    //`input` State 값 변경
    setInput({
      ...input, //스프레드 연산자 사용해서 기존 State 값 유지
      [name]: value, //입력이 발생한 요소 설정 : 수정할 값
    });
  };

  //작성 완료 이벤트
  const onClickSubmitButton = () => {
    onSubmit(input);
  };

  return (
    <div className='Editor'>
      <section className='date_section'>
        <h4>오늘의 날짜</h4>
        <input
          name='createdDate'
          onChange={onChangeInput}
          value={getStringedDate(input.createdDate)}
          type='date'
        />
      </section>
      <section className='emotion_section'>
        <h4>오늘의 감정</h4>
        <div className='emotion_list_wrapper'>
          {emotionList.map((item) => (
            <EmotionItem
              onClick={() =>
                onChangeInput({
                  target: {
                    name: 'emotionId',
                    value: item.emotionId,
                  },
                })
              }
              key={item.emotionId}
              {...item}
              isSelected={item.emotionId === input.emotionId}
            />
          ))}
        </div>
      </section>
      <section className='content_section'>
        <h4>오늘의 일기</h4>
        <textarea
          onChange={onChangeInput}
          name='content'
          value={input.content}
          placeholder='오늘 하루는 어떠셨나요?'
        />
      </section>
      <section className='button_section'>
        <Button text={'취소'} type='NEGATIVE' />
        <Button onClick={onClickSubmitButton} text={'작성'} type='POSITIVE' />
      </section>
    </div>
  );
};

export default Editor;
