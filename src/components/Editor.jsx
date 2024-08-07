import Button from './Button';
import './Editor.css';
import EmotionItem from './EmotionItem';

const emotionList = [
  {
    emotionId: 1,
    emotionName: '완전 좋음',
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
    emotionName: '완전 안 좋음',
  },
];

const Editor = () => {
  //선택한 감정을 저장하는 변수
  const emotionId = 1;

  return (
    <div className='Editor'>
      <section className='date_section'>
        <h4>오늘의 날짜</h4>
        <input type='date' />
      </section>
      <section className='emotion_section'>
        <h4>오늘의 감정</h4>
        <div className='emotion_list_wrapper'>
          {emotionList.map((item) => (
            <EmotionItem key={item.emotionId} {...item} isSelected={item.emotionId === emotionId} />
          ))}
        </div>
      </section>
      <section className='content_section'>
        <h4>오늘의 일기</h4>
        <textarea placeholder='오늘 하루는 어떠셨나요?' />
      </section>
      <section className='button_section'>
        <Button text={'취소하기'} type='NEGATIVE' />
        <Button text={'작성완료'} type='POSITIVE' />
      </section>
    </div>
  );
};

export default Editor;
