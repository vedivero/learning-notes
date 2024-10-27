import React, { useState } from 'react';
import { useSelector } from 'react-redux';
import axiosInstance from '../../utils/axios';
import { useNavigate } from 'react-router-dom';

const continents = [
   { key: 1, value: '아프리카' },
   { key: 2, value: '유럽' },
   { key: 3, value: '아시아' },
   { key: 4, value: '북아메리카' },
   { key: 5, value: '남아케리카' },
   { key: 6, value: '호주' },
];

const UploadProductPage = () => {
   const [product, setProduct] = useState({
      title: '',
      description: '',
      price: 0,
      continents: 1,
      images: [],
   });

   const handleChange = (event) => {
      const { name, value } = event.target;
      setProduct((prevState) => ({
         ...prevState,
         [name]: value,
      }));
   };

   const userData = useSelector((state) => state.user?.userData);
   const navigate = useNavigate();

   const handleSubmit = async (event) => {
      event.prevetDefault();

      const body = {
         writer: user.userData._id,
         ...product,
      };
      try {
         await axiosInstance.post('/products', body);
         navigate('/');
      } catch (error) {
         console.log(error);
      }
   };
   return (
      <section>
         <div className='text-center m-7'>
            <h1>상품 업로드</h1>
         </div>

         <form className='mt-6' onSubmit={handleSubmit}>
            <div className='mt-4'>
               <label htmlFor='title'>이름</label>
               <input
                  className='w-full px-4 py-2 bg-white border rounded-md'
                  name='title'
                  id='title'
                  onChange={handleChange}
                  value={product.title}
               />
            </div>
            <div className='mt-4'>
               <label htmlFor='description'>설명</label>
               <input
                  className='w-full px-4 py-2 bg-white border rounded-md'
                  name='description'
                  id='description'
                  onChange={handleChange}
                  value={product.description}
               />
            </div>
            <div className='mt-4'>
               <label htmlFor='price'>가격</label>
               <input
                  className='w-full px-4 py-2 bg-white border rounded-md'
                  name='price'
                  id='price'
                  type='number'
                  onChange={handleChange}
                  value={product.price}
               />
            </div>
            <div className='mt-4'>
               <label htmlFor='continents'>지역</label>
               <select
                  className='w-full px-4 py-2 bg-white border rounded-md'
                  name='continents'
                  id='continents'
                  onChange={handleChange}
                  value={product.continents}
               >
                  {continents.map((item) => (
                     <option key={item.key} value={item.key}>
                        {item.value}
                     </option>
                  ))}
               </select>
            </div>
            <div className='mt-8'>
               <button className='w-full px-4 py-2 text-white bg-black rounded-md hover:bg-gray-700'>
                  생성하기
               </button>
            </div>
         </form>
      </section>
   );
};

export default UploadProductPage;
