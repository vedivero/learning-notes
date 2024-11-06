import React from 'react';
import { useDispatch } from 'react-redux';
import { addToCart } from '../../../store/thunkFunctions';

const ProductInfo = ({ product }) => {
   const dispatch = useDispatch();

   const handleClick = () => {
      dispatch(addToCart({ productId: product._id }));
   };

   return (
      <div>
         <p>상품정보</p>
         <ul>
            <li>
               <span className='font-semibold text-gray-900'>상품 가격 : </span>
               {product.price} 원
            </li>
            <li>
               <span className='font-semibold text-gray-900'>판매 개수 : </span>
               {product.sold} 원
            </li>
            <li>
               <span className='font-semibold text-gray-900'>상품 설명 : </span>
               {product.description} 원
            </li>
         </ul>
         <div className='mt-3'>
            <button
               onClick={handleClick}
               className='w-full px-4 py-2 text-white bg-black hover:bg-gray-700 rounded-md '
            >
               장바구니 담기
            </button>
         </div>
      </div>
   );
};

export default ProductInfo;
