//메세지 작성 폼 컴포넌트
import {
   child,
   push,
   set,
   ref as dbRef,
   serverTimestamp,
} from 'firebase/database';
import React, { useState } from 'react';
import { db } from '../../../firebase';
import { useSelector } from 'react-redux';

const MessageForm = () => {
   const [content, setContent] = useState(''); //메세지 내용
   const [loading, setLoading] = useState(false); //전송
   const [errors, setErrors] = useState([]); //에러

   const messagesRef = dbRef(db, 'messages'); //참조하는 경로

   const { currentChatRoom } = useSelector((state) => state.chatRoom);
   const { currentUser } = useSelector((state) => state.user); //로그인 된 유저의 데이터
   const { isPriavateChatRoom } = useSelector((state) => state.chatRoom); //Direct Message

   const createMessage = (fileUrl = null) => {
      const message = {
         timestamp: serverTimestamp(),
         user: {
            id: currentUser.uid,
            name: currentUser.displayName,
            image: currentUser.photoURL,
         },
      };

      if (fileUrl !== null) {
         message['image'] = fileUrl;
      } else {
         message['content'] = content;
      }

      return message;
   };

   const handleSubmit = async (e) => {
      e.preventDefault();

      //메세지 입력 없이 전송한 경우
      if (!content) {
         setErrors((prev) => prev.concat('메세지 내용을 입력해 주세요.'));
         return; //에러 발생 시, 이 위치에서 진행 종료
      }
      setLoading(true);

      //farebase에 message를 저장하는 부분
      try {
         await set(
            push(child(messagesRef, currentChatRoom.id)),
            createMessage(),
         );
         setLoading(false);
         setContent('');
         setErrors([]);
      } catch (error) {
         console.log(error);
         setErrors((prev) => prev.concat(error.message));

         setLoading(false);
         setTimeout(() => {
            setErrors([]);
         }, 5000);
      }
   };
   return (
      <div>
         <form onSubmit={handleSubmit}>
            <textarea
               style={{
                  width: '100%',
                  height: 90,
                  border: '0.2rem solid rgb(235,236,236',
                  borderRadius: 4,
               }}
               value={content}
               onChange={(e) => setContent(e.target.value)}
            />
            <div>
               {errors.map((errorMsg, i) => (
                  <p key={i} style={{ color: 'red' }}>
                     {errorMsg}
                  </p>
               ))}
            </div>
            <div style={{ display: 'flex', gap: 16 }}>
               <div style={{ flexGrow: 1 }}>
                  <button
                     type='submit'
                     className='message-form-button'
                     style={{ width: '100%', fontSize: 20, fontWeight: 'bold' }}
                     disabled={loading}
                  >
                     보내기
                  </button>
               </div>
               <div style={{ flexGrow: 1 }}>
                  <button
                     type='submit'
                     className='message-form-button'
                     style={{ width: '100%', fontSize: 20, fontWeight: 'bold' }}
                     disabled={loading}
                  >
                     이미지
                  </button>
               </div>
            </div>
         </form>

         <input
            type='file'
            accept='image/jpeg, image/png'
            style={{ display: 'none' }}
         />
      </div>
   );
};

export default MessageForm;
