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
   const [searchTerm, setSearchTerm] = useState('');
   const [searchResults, setSearchResults] = useState([]);
   const [searchLoading, setSearchLoading] = useState(false);
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

   //MessageHeader에서 발생되는 이벤트
   const handleSearchChange = (event) => {
      //타이핑 이벤트 발생때마다 'setSetsearchTerm' state update
      setSearchTerm(event.target.value);
      setSearchLoading(true);

      handleSearchMessages(event.target.value);
   };

   const handleSearchMessages = (searchTerm) => {
      console.log(searchTerm);
      const chatRoomMessages = [...messages];
      const regex = new RegExp(searchTerm, 'gi');
      const searchResults = chatRoomMessages.reduce((acc, message) => {
         // if ((message.content && message.content.match(regex)) || message.user.name.match(regex)) {
         if (message.content && message.content.match(regex)) {
            acc.push(message);
         }
         return acc;
      }, []);
      setSearchResults(searchResults);
      setSearchLoading(false);
   };

   const addMessagesListeners = (chatRoomId) => {
      console.log('addMessagesListeners');
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
      messages.map((message) => <Message key={message.timestamp} message={message} user={currentUser} />);

   return (
      <div>
         <MessageHeader handleSearchChange={handleSearchChange} />
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
            {searchLoading && <div>Searching...</div>}
            {/* {searchLoading} */}

            {searchTerm ? renderMessages(searchResults) : renderMessages(messages)}
         </div>
         <MessageForm />
      </div>
   );
};

export default MainPanel;
