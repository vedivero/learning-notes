import { useState, useEffect } from 'react';
import Button from './Button';
import './Editor.css';
import EmotionItem from './EmotionItem';
import { useNavigate } from 'react-router-dom';
import { emotionList } from '../util/constants';
import { getStringedDate } from '../util/get-stringed_date';

const Editor = ({ initData, onSubmit }) => {
   //사용자가 입력한 값을 저장하는 State
   //날짜, 감정, 내용 저장
   //여러 값을 저장하기 위해 객체로 만들어서 사용
   const [input, setInput] = useState({
      createdDate: new Date(),
      emotionId: 3,
      content: '',
   });

   const nav = useNavigate();

   useEffect(() => {
      if (initData) {
         setInput({
            ...initData,
            createdDate: new Date(
               Number(initData.createdDate),
            ),
         });
      }
   }, [initData]);

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
                     isSelected={
                        item.emotionId === input.emotionId
                     }
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
            <Button
               onClick={() => {
                  nav(-1);
               }}
               text={'취소'}
               type='NEGATIVE'
            />
            <Button
               onClick={onClickSubmitButton}
               text={'작성 완료'}
               type='POSITIVE'
            />
         </section>
      </div>
   );
};

export default Editor;
