import { useParams, useNavigate } from 'react-router-dom';
import Header from '../components/Header';
import Button from '../components/Button';
import Editor from '../components/Editor';
import { useContext, useEffect, useState } from 'react';
import {
   DiaryDispatchContext,
   DiaryStateContext,
} from '../App';

const Edit = () => {
   const params = useParams(); //URL파라미터를 추출하는 Hook
   const nav = useNavigate();
   const { onDelete, onUpdate } = useContext(
      DiaryDispatchContext,
   ); //onDelet함수를 useContext를 통해 DiaryDispatchContext로부터 호출

   const data = useContext(DiaryStateContext); //useContext를 통해 DiaryStateContext로 부터 현재 일기 데이터 불러오기
   const [curDiaryItem, setCurDiaryItem] = useState();

   useEffect(() => {
      // ID에 해당하는 일기 데이터 필터
      const currentDiaryItem = data.find(
         (item) => String(item.id) === String(params.id),
      );
      //데이터가 존재하지 안는 경우
      if (!currentDiaryItem) {
         window.alert('존재하지 않는 일기입니다.');
         nav('/', { replace: true });
      }

      setCurDiaryItem(currentDiaryItem);
   }, [params.id, data]); //params.id, data값이 변경될 때 실행되도록 설정

   //일기 삭제
   const onClickDelete = () => {
      if (window.confirm('일기를 삭제할까요?')) {
         // 일기 삭제 로직
         onDelete(params.id);
         nav('/', { replace: true }); //삭제 후 뒤로가기 방지처리
      }
   };

   const onSubmit = (input) => {
      if (window.confirm('일기를 수정할까요?')) {
         onUpdate(
            params.id,
            input.createdDate.getTime(),
            input.emotionId,
            input.content,
         );
         nav('/', { replace: true });
      }
   };

   return (
      <div>
         <Header
            title={'일기 수정하기'}
            leftChild={
               <Button
                  onClick={() => nav(-1)}
                  text={'< 뒤로 가기'}
               />
            }
            rightChild={
               <Button
                  onClick={onClickDelete}
                  text={'삭제하기'}
                  type={'NEGATIVE'}
               />
            }
         />
         <Editor
            initData={curDiaryItem}
            onSubmit={onSubmit}
         />
      </div>
   );
};

export default Edit;
