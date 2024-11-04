import React, { useEffect, useState } from 'react';
import CheckBox from './Sections/CheckBox';
import RadioBox from './Sections/RadioBox';
import SearchInput from './Sections/SearchInput';
import axiosInstance from '../../utils/axios';
import CardItem from './Sections/CardItem';

const LandingPage = () => {
   const limit = 8;
   const [products, setProducts] = useState([]);
   const [skip, setSkip] = useState(0);
   const [hasMore, setHasMore] = useState(false);
   const [filters, setFilters] = useState({
      continents: [],
      price: [],
   });

   useEffect(() => {
      fetchProducts({ skip, limit });
   }, []);

   const fetchProducts = async ({ skip, limit, loadMore = false, filters = {}, searchTerm = '' }) => {
      const params = {
         skip,
         limit,
         filters,
         searchTerm,
      };

      try {
         const response = await axiosInstance.get('/products', { params });
         setProducts(response.data.products);
      } catch (error) {
         console.error(error);
      }
   };

   return (
      <section>
         <div className='text-center m-7'>
            <h2 className='text-2xl'>여행 상품 사이트</h2>
         </div>
         {/* Filter */}
         <div className='fl'>
            <div>
               <CheckBox />
            </div>
            <div>
               <RadioBox />
            </div>
         </div>
         {/* Search */}
         <div>
            <SearchInput />
         </div>
         {/* Card */}
         <div className='grid grid-col-2 gap-4 sm:grid-cols-4 '>
            {products.map((product) => (
               <CardItem product={product} key={product._id} />
            ))}
         </div>
         {/* LoadMore */}
         {hasMore && (
            <div className='flex justify-center mt-5'>
               <button className='px-4 py-2 mt-5 text-white bg-black rounded-md hover:bg-gray-500'>
                  더 보기
               </button>
            </div>
         )}
      </section>
   );
};

export default LandingPage;
