//메세지 작성 폼 컴포넌트
import { child, push, set, ref as dbRef, serverTimestamp, remove } from 'firebase/database';
import React, { useRef, useState } from 'react';
import { db, storage } from '../../../firebase';
import { getDownloadURL, getStorage, ref as strRef, uploadBytesResumable } from 'firebase/storage';
import { useSelector } from 'react-redux';
import { ProgressBar } from 'react-bootstrap';

const MessageForm = () => {
   const [content, setContent] = useState(''); //메세지 내용
   const [loading, setLoading] = useState(false); //전송
   const [errors, setErrors] = useState([]); //에러
   const [percentage, setPercentage] = useState(0); //progress bar

   const messagesRef = dbRef(db, 'messages'); //참조하는 경로
   const inputOpenImageRef = useRef(null);
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
         await set(push(child(messagesRef, currentChatRoom.id)), createMessage());
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

   const handleOpenImageRef = () => {
      inputOpenImageRef.current.click();
   };

   const getPath = () => {
      if (isPriavateChatRoom) {
         return `message/private/${currentChatRoom.id}`;
      } else {
         return `message/public`;
      }
   };

   const handleUploadImage = (event) => {
      const file = event.target.files[0];
      const storage = getStorage();

      const filePath = `${getPath()}/${file.name}`;
      console.log('filePath : ', filePath);
      const metadata = { contentType: file.type };
      setLoading(true);
      try {
         // https://firebase.google.com/docs/storage/web/upload-files#full_example
         // Upload file and metadata to the object 'images/mountains.jpg'
         const storageRef = strRef(storage, filePath);
         const uploadTask = uploadBytesResumable(storageRef, file, metadata);

         // Listen for state changes, errors, and completion of the upload.
         uploadTask.on(
            'state_changed',
            (snapshot) => {
               // Get task progress, including the number of bytes uploaded and the total number of bytes to be uploaded
               const progress = (snapshot.bytesTransferred / snapshot.totalBytes) * 100;
               console.log('Upload is ' + progress + '% done');
               setPercentage(Math.round(progress));
               switch (snapshot.state) {
                  case 'paused':
                     console.log('Upload is paused');
                     break;
                  case 'running':
                     console.log('Upload is running');
                     break;
               }
            },
            (error) => {
               // A full list of error codes is available at
               // https://firebase.google.com/docs/storage/web/handle-errors
               switch (error.code) {
                  case 'storage/unauthorized':
                     // User doesn't have permission to access the object
                     break;
                  case 'storage/canceled':
                     // User canceled the upload
                     break;
                  // ...
                  case 'storage/unknown':
                     // Unknown error occurred, inspect error.serverResponse
                     break;
               }
            },
            () => {
               // Upload completed successfully, now we can get the download URL
               getDownloadURL(uploadTask.snapshot.ref).then((downloadURL) => {
                  // console.log('File available at', downloadURL);
                  set(push(child(messagesRef, currentChatRoom.id)), createMessage(downloadURL));
                  setLoading(false);
               });
            },
         );
      } catch (error) {
         console.log(error);
      }
   };

   const handleChange = (event) => {
      setContent(event.target.value);

      if (event.target.value) {
         set(dbRef(db, `typing/${currentChatRoom.id}/${currentUser.uid}`), {
            userUid: currentUser.displayName,
         });
      } else {
         remove(dbRef(db, `typing/${currentChatRoom.id}/${currentUser.uid}`));
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
               onChange={handleChange}
               placeholder='메세지 내용을 입력하세요'
            />
            {!(percentage === 0 || percentage === 100) && (
               <ProgressBar variant='warning' label={`${percentage}`} now={percentage} />
            )}
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
                     type='button'
                     onClick={handleOpenImageRef}
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
            ref={inputOpenImageRef}
            onChange={handleUploadImage}
         />
      </div>
   );
};

export default MessageForm;
