import React from 'react';

const CheckBox = ({ continents, checkedContinents, onFilters }) => {
   const handleToggle = (continentId) => {
      const currentIndex = checkedContinents.indexOf(continentId);

      const newChecked = [...checkedContinents];

      if (currentIndex === -1) {
         newChecked.push(continentId);
      } else {
         newChecked.splice(currentIndex, 1);
      }
      onFilters(newChecked);
   };

   return (
      <div className='flex p-2 mb-3 bg-gray-100 rounded-md flex-wrap justify-around'>
         {continents?.map((continent) => (
            <label // label 태그로 변경하여 클릭 이벤트를 확장
               key={continent._id}
               className='flex items-center mb-2 cursor-pointer' // 커서 스타일 추가로 클릭 가능하다는 시각적 표시
            >
               <input
                  type='checkbox'
                  onChange={() => handleToggle(continent._id)}
                  checked={checkedContinents.indexOf(continent._id) !== -1}
                  className='mr-1'
               />
               {continent.name}
            </label>
         ))}
      </div>
   );
};

export default CheckBox;
