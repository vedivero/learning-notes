import { useContext, useState, useEffect } from 'react';
import { DiaryStateContext } from '../App';
import { useNavigate } from 'react-router-dom';

//커스텀 훅
const useDiary = (id) => {
   const data = useContext(DiaryStateContext); //useContext를 통해 DiaryStateContext로 부터 현재 일기 데이터 불러오기
   const [curDiaryItem, setCurDiaryItem] = useState();
   const nav = useNavigate();

   useEffect(() => {
      // ID에 해당하는 일기 데이터 필터
      const currentDiaryItem = data.find(
         (item) => String(item.id) === String(id),
      );
      //데이터가 존재하지 안는 경우
      if (!currentDiaryItem) {
         window.alert('존재하지 않는 일기입니다.');
         nav('/', { replace: true });
      }

      setCurDiaryItem(currentDiaryItem);
   }, [id, data]); //params.id, data값이 변경될 때 실행되도록 설정

   return curDiaryItem;
};

export default useDiary;
