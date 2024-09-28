import React, { useEffect, useState } from 'react';
import MessageHeader from './MessageHeader';
import MessageForm from './MessageForm';
import { child, off, onChildAdded, ref as dbRef } from 'firebase/database';
import { db } from '../../../firebase';
import { useDispatch, useSelector } from 'react-redux';
import Message from './Message';

const MainPanel = () => {
   const messagesRef = dbRef(db, 'messages');

   const [messages, setMessages] = useState([]);
   const [messagesLoading, setMessagesLoading] = useState(true);
   const { currentUser } = useSelector((state) => state.user);
   const { currentChatRoom } = useSelector((state) => state.chatRoom);
   const dispatch = useDispatch();

   useEffect(() => {
      if (currentChatRoom.id) {
         addMessagesListeners(currentChatRoom.id);
      }

      return () => {
         off(messagesRef);
      };
   }, [currentChatRoom.id]);

   const addMessagesListeners = (chatRoomId) => {
      console.log('채팅 입력됨');
      let messagesArray = [];
      setMessages([]);

      onChildAdded(child(messagesRef, chatRoomId), (DataSnapshot) => {
         messagesArray.push(DataSnapshot.val());
         const newMessageArray = [...messagesArray];
         setMessages(newMessageArray); // 상태 업데이트
         setMessagesLoading(false);
      });
      console.log('addMessagesListeners messagesArray: ', messagesArray);
   };

   const renderMessages = (messages) =>
      messages.length > 0 &&
      messages.map((message) => (
         <Message
            key={message.timestamp}
            message={message}
            user={currentUser}
         />
      ));

   return (
      <div>
         <MessageHeader />
         <div
            style={{
               width: '100%',
               height: '450px',
               border: '0.2rem solid #ececec',
               borderRadius: '4px',
               padding: '1rem',
               marginBottom: '1rem',
               overflow: 'auto',
            }}
         >
            {renderMessages(messages)}
         </div>
         <MessageForm />
      </div>
   );
};

export default MainPanel;
