import './DiaryList.css';
import Button from './Button';
import DiaryItem from './DiaryItem';
import { useNavigate } from 'react-router-dom';
import { useState } from 'react';

const DiaryList = ({ data }) => {
   //가장 최근 게시물을 디폴트로 설정
   const nav = useNavigate();
   const [sortType, setSortType] = useState('latest');
   //select변경 이벤트
   const onChangeSortType = (e) => {
      setSortType(e.target.value);
   };
   //toSorted 원본 배열은 유지한 채, 정렬된 배열을 새롭게 반환
   const getSortedData = () => {
      return data.toSorted((a, b) => {
         if (sortType === 'oldest') {
            return (
               Number(a.createdDate) - Number(b.createdDate)
            );
         } else {
            return (
               Number(b.createdDate) - Number(a.createdDate)
            );
         }
      });
   };

   const sortedData = getSortedData();
   return (
      <div className='DiaryList'>
         <div className='menu_bar'>
            <select
               value={sortType}
               onChange={onChangeSortType}
            >
               <option value={'latest'}>최신순</option>
               <option value={'oldest'}>오래된 순</option>
            </select>
            <Button
               onClick={() => nav('/new')}
               text={'새 일기 쓰기'}
               type={'POSITIVE'}
            />
         </div>
         <div className='list_wrapper'>
            {sortedData.map((item) => (
               <DiaryItem key={item.id} {...item} />
            ))}
         </div>
      </div>
   );
};

export default DiaryList;
