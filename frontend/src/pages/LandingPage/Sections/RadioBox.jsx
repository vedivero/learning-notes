import React from 'react';

const RadioBox = ({ prices, checkedPrice, onFilters }) => {
   return (
      <div className='flex flex-wrap p-2 mb-3 bg-gray-100 rounded-md justify-around'>
         {prices?.map((price) => (
            <div key={price._id} className='flex items-center mr-4'>
               <input
                  checked={checkedPrice === price.array}
                  onChange={(e) => onFilters(e.target.value)}
                  type='radio'
                  id={price._id}
                  value={price._id}
                  className='mr-1'
               />
               <label htmlFor={price._id}>{price.name}</label>
            </div>
         ))}
      </div>
   );
};

export default RadioBox;
