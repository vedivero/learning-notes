import React, { useEffect, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { getCartItems, removeCartItem } from '../../store/thunkFunctions';
import CartTable from './Section/CartTable';

const CartPage = () => {
   const userData = useSelector((state) => state.user?.userData);
   const cartDetail = useSelector((state) => state.user?.cartDetail);
   const [total, setTotal] = useState(0);
   const dispatch = useDispatch();

   useEffect(() => {
      let cartItemIds = [];
      if (userData?.cart && userData.cart.length > 0) {
         userData.cart.forEach((item) => {
            cartItemIds.push(item.id);
         });
         const body = {
            cartItemIds,
            userCart: userData.cart,
         };
         dispatch(getCartItems(body));
      }
   }, [dispatch, userData]);

   useEffect(() => {
      calculateTotal(cartDetail);
   }, [cartDetail]);

   const calculateTotal = (cartItems) => {
      let total = 0;
      cartItems.map((item) => {
         total += item.price * item.quantity;
      });
      setTotal(total);
   };

   const handleRemoveCartItem = (productId) => {
      dispatch(removeCartItem(productId));
   };

   return (
      <div>
         <div className='text-center m-7'>
            <h2 className='text-2xl'>나의 장바구니</h2>
         </div>
         {cartDetail?.length > 0 ? (
            <>
               <CartTable products={cartDetail} onRemoveItem={handleRemoveCartItem} />
               <div>
                  <p>
                     <span className='font-bold'>합계 : </span>
                     {total} 원
                  </p>
               </div>
               <button
                  className='text-white bg-black hover:bg-gray-500 rouded-lg px-4 py-2 mt-5'
                  // onClick={handlePaymentClick}
               >
                  결제하기
               </button>
            </>
         ) : (
            <p>장바구니가 비었습니다.</p>
         )}
      </div>
   );
};

export default CartPage;
