import React, { useEffect, useState } from 'react';
import MessageHeader from './MessageHeader';
import MessageForm from './MessageForm';
import { child, off, onChildAdded, ref as dbRef, DataSnapshot, onChildRemoved } from 'firebase/database';
import { db } from '../../../firebase';
import { useDispatch, useSelector } from 'react-redux';
import Message from './Message';
import { setUserPosts } from '../../../store/chatRoomSlice';

const MainPanel = () => {
   const messagesRef = dbRef(db, 'messages');
   const typingRef = dbRef(db, 'typing');

   const [messages, setMessages] = useState([]);
   const [messagesLoading, setMessagesLoading] = useState(true);
   const [searchTerm, setSearchTerm] = useState('');
   const [searchResults, setSearchResults] = useState([]);
   const [searchLoading, setSearchLoading] = useState(false);
   const [typingUsers, setTypingUsers] = useState([]);

   const { currentUser } = useSelector((state) => state.user);
   const { currentChatRoom } = useSelector((state) => state.chatRoom);
   const dispatch = useDispatch();

   useEffect(() => {
      if (currentChatRoom.id) {
         addMessagesListeners(currentChatRoom.id);
         addTypingListeners(currentChatRoom.id);
      }

      return () => {
         off(messagesRef);
      };
   }, [currentChatRoom.id]);

   const addTypingListeners = (chatRoomId) => {
      let typingUsers = [];

      //typing이 새로 들어올 때
      onChildAdded(child(typingRef, chatRoomId), (DataSnapshot) => {
         console.log('DataSnapshot.key : ', DataSnapshot.key);
         console.log('currentUser.uid : ', currentUser.uid);
         console.log(DataSnapshot.key !== currentUser.uid);
         console.log('typingUsers : ', typingUsers);
         if (DataSnapshot.key !== currentUser.uid) {
            typingUsers = typingUsers.concat({
               id: DataSnapshot.key,
               name: DataSnapshot.val(),
            });
            setTypingUsers(typingUsers);
         }
      });
      //typing을 지워줄 때
      onChildRemoved(child(typingRef, chatRoomId), (DataSnapshot) => {
         const index = typingUsers.findIndex((user) => user.id === DataSnapshot.key);
         if (index !== -1) {
            typingUsers = typingUsers.filter((user) => user.id !== DataSnapshot.key);
            setTypingUsers(typingUsers);
         }
      });
   };

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
      let messagesArray = [];
      setMessages([]);

      onChildAdded(child(messagesRef, chatRoomId), (DataSnapshot) => {
         messagesArray.push(DataSnapshot.val());
         const newMessageArray = [...messagesArray];
         setMessages(newMessageArray); // 상태 업데이트
         setMessagesLoading(false);
         userPostsCount(newMessageArray);
      });
   };

   const userPostsCount = (messages) => {
      const userPosts = messages.reduce((acc, message) => {
         if (message.user.name in acc) {
            acc[message.user.name].count += 1;
         } else {
            acc[message.user.name] = {
               image: message.user.image,
               count: 1,
            };
         }
         return acc;
      }, {});
      dispatch(setUserPosts(userPosts));
   };

   const renderMessages = (messages) =>
      messages.length > 0 &&
      messages.map((message) => <Message key={message.timestamp} message={message} user={currentUser} />);

   const renderTypingUsers = (typingUsers) =>
      typingUsers.length > 0 &&
      typingUsers.map((user) => (
         <span key={user.name.userUid}>{user.name.userUid}님이 채팅을 입력하고 있습니다...</span>
      ));

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
            {renderTypingUsers(typingUsers)}
         </div>
         <MessageForm />
      </div>
   );
};

export default MainPanel;
