import React, { useEffect, useState } from 'react';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import InputGroup from 'react-bootstrap/InputGroup';
import FormControl from 'react-bootstrap/FormControl';
import Image from 'react-bootstrap/Image';
import { AiOutlineSearch } from 'react-icons/ai';
import { useSelector } from 'react-redux';
import { FaLock, FaLockOpen } from 'react-icons/fa';
import { MdFavorite, MdFavoriteBorder } from 'react-icons/md';
import { child, onValue, ref, remove, update } from 'firebase/database';
import { db } from '../../../firebase';

const MessageHeader = ({ handleSearchChange }) => {
   const { currentChatRoom } = useSelector((state) => state.chatRoom);
   const { isPrivateChatRoom } = useSelector((state) => state.chatRoom);
   const [isFavorite, setIsFavorite] = useState(false);
   const usersRef = ref(db, 'users');
   const { currentUser } = useSelector((state) => state.user);

   useEffect(() => {
      if (currentChatRoom?.id && currentUser?.uid) {
         addFavoriteListener(currentChatRoom.id, currentUser.uid);
      }
   }, [currentChatRoom?.id, currentUser?.uid]);

   const addFavoriteListener = (chatRoomId, userId) => {
      onValue(child(usersRef, `${userId}/favorite`), (data) => {
         if (data.val() !== null) {
            const chatRoomIds = Object.keys(data.val());
            const isAlreadyFavorite = chatRoomIds.includes(chatRoomId);
            setIsFavorite(isAlreadyFavorite);
         }
      });
   };

   const handleFavorite = () => {
      if (isFavorite) {
         setIsFavorite(false);
         remove(child(usersRef, `${currentUser.uid}/favorite/${currentChatRoom.id}`));
      } else {
         setIsFavorite(true);
         update(child(usersRef, `${currentUser.uid}/favorite`), {
            [currentChatRoom.id]: {
               name: currentChatRoom.name,
               description: currentChatRoom.description,
               createdBy: {
                  name: currentChatRoom.createdBy.name,
                  image: currentChatRoom.createdBy.image,
               },
            },
         });
      }
   };

   return (
      <div
         style={{
            width: '100%',
            height: '190px',
            border: '.2rem solid #ececec',
            borderRadius: '4px',
            padding: '1rem',
            marginBottom: '1rem',
         }}
      >
         <Row>
            <Col>
               <h2>
                  {isPrivateChatRoom ? (
                     <FaLock style={{ marginBottom: '10px' }} />
                  ) : (
                     <FaLockOpen style={{ marginBottom: '10px' }} />
                  )}{' '}
                  {currentChatRoom && <span>{currentChatRoom.name}</span>}{' '}
                  {!isPrivateChatRoom && (
                     <span style={{ cursor: 'pointer' }} onClick={handleFavorite}>
                        {isFavorite ? (
                           <MdFavorite style={{ marginBottom: '10px' }} />
                        ) : (
                           <MdFavoriteBorder style={{ marginBottom: '10px' }} />
                        )}
                     </span>
                  )}
               </h2>
            </Col>

            <Col>
               <InputGroup className='mb-3'>
                  <InputGroup.Text id='basic-addon1'>
                     <AiOutlineSearch />
                  </InputGroup.Text>
                  <FormControl
                     onChange={handleSearchChange}
                     placeholder='Search Messages'
                     aria-label='Search'
                     aria-describedby='basic-addon1'
                  />
               </InputGroup>
            </Col>
         </Row>

         {!isPrivateChatRoom && (
            <div style={{ display: 'flex', justifyContent: 'flex-end' }}>
               {currentChatRoom?.createdBy && (
                  <>
                     <Image
                        src={currentChatRoom.createdBy.image}
                        style={{ width: '30px', height: '30px', marginRight: 7 }}
                        roundedCircle
                     />{' '}
                     <p>{currentChatRoom.createdBy.name}</p>
                  </>
               )}
            </div>
         )}
      </div>
   );
};

export default MessageHeader;
