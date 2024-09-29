//DM메세지를 보내는 컴포넌트
import { DataSnapshot, onChildAdded, ref } from 'firebase/database';
import React, { useEffect, useState } from 'react';
import { FaRegSmile } from 'react-icons/fa';
import { db } from '../../../firebase';
import { useSelector } from 'react-redux';

const DirectMessages = () => {
   const usersRef = ref(db, 'users');

   const [users, setUsers] = useState([]);
   const [activeChatRoom, setActiveChatRoom] = useState('');

   const { currentUser } = useSelector((state) => state.user);

   useEffect(() => {
      if (currentUser?.uid) {
         addUsersListener(currentUser.uid);
      }
      return () => {};
   }, [currentUser?.uid]);

   const addUsersListener = (currentUserId) => {
      let usersArray = [];
      onChildAdded(usersRef, (DataSnapshot) => {
         if (currentUserId !== DataSnapshot.key) {
            let user = DataSnapshot.val();
            user['uid'] = DataSnapshot.key;
            usersArray.push(user);
            const newUserArray = [...usersArray];
            setUsers(newUserArray);
         }
      });
   };

   const renderDirectMessages = (users) =>
      users.length > 0 &&
      users.map((user) => (
         <li key={user.uid} style={{ background: user.uid === activeChatRoom ? '#FFFFFF45' : '' }}>
            #{user.name}
         </li>
      ));

   return (
      <div>
         <span style={{ display: 'flex', alignItems: 'center' }}>
            <FaRegSmile style={{ marginRight: 3 }} />
            DIRECT MESSAGES
         </span>
         <ul style={{ lifeStyleType: 'none', padding: 0 }}>{renderDirectMessages(users)}</ul>
      </div>
   );
};

export default DirectMessages;
