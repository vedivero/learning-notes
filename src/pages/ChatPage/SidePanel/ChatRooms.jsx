//채팅방의 이름이 나열되는 컴포넌트
import React, { useEffect, useState } from 'react';
import { Button, Form, Modal } from 'react-bootstrap';
import { FaPlus, FaRegSmileWink } from 'react-icons/fa';
import {
   child,
   ref as dbRef,
   off,
   onChildAdded,
   push,
   update,
} from 'firebase/database';
import { db } from '../../../firebase';
import { useDispatch, useSelector } from 'react-redux';
import { setCurrentChatRoom } from '../../../store/chatRoomSlice';

const ChatRooms = () => {
   const [show, setShow] = useState(false); //false일 때는 modal이 안 보이게끔
   const [name, setName] = useState(''); //채팅 방 이름
   const [description, setDescription] = useState(''); //채팅 방 설명
   const chatRoomsRef = dbRef(db, 'chatRooms');

   const [chatRooms, setChatRooms] = useState([]); //여러 채팅 방을 저장하기 위해 배열로 선언
   const [firstLoad, setFirstLoad] = useState(true); //첫 실행 시에만 true, 그 이후는 false
   const [activeChatRoomId, setActiveChatRoomId] = useState('');

   const { currentUser } = useSelector((state) => state.user); //현재 로그인 한 user의 데이터

   const dispatch = useDispatch();

   useEffect(() => {
      addChatRoomsListeners();
      return () => {
         off(chatRoomsRef);
      };
   }, []);

   const handleSubmit = async (e) => {
      //채팅 방 이름과 설명을 작성했는지 유효성 체크
      if (isFormValid(name, description)) {
         const key = push(chatRoomsRef).key;
         const newChatRoom = {
            id: key, //firebase에서 제공하는 함수, ID값을 추출
            name: name,
            description: description,
            createdBy: {
               name: currentUser.displayName,
               image: currentUser.photoURL,
            },
         };
         try {
            await update(child(chatRoomsRef, key), newChatRoom); //데이터 DB에 저장
            //사용자가 입력한 텍스트 초기화
            setName('');
            setDescription('');
            setShow(false);
         } catch (error) {
            alert('채팅 방 생성 중 오류가 발생했습니다.');
            console.log(error);
         }
      }
   };

   //component가 mount될 때 실행
   const addChatRoomsListeners = () => {
      let chatRoomsArray = [];

      onChildAdded(chatRoomsRef, (DataSnapshot) => {
         chatRoomsArray.push(DataSnapshot.val());
         const newChatRooms = [...chatRoomsArray];
         setChatRooms(newChatRooms);
         setFirstChatRoom(newChatRooms);
      });
   };

   const setFirstChatRoom = (chatRooms) => {
      const firstChatRoom = chatRooms[0];
      if (firstLoad && chatRooms.length > 0) {
         dispatch(setCurrentChatRoom(firstChatRoom));
         setActiveChatRoomId(firstChatRoom.id);
      }
      setFirstLoad(false);
   };

   const isFormValid = (name, description) => name && description;

   const changeChatRoom = (room) => {
      dispatch(setCurrentChatRoom(room));
      setActiveChatRoomId(room.id);
   };

   const renderChatRooms = (chatRooms) =>
      chatRooms.length > 0 &&
      chatRooms.map((room) => {
         return (
            <li
               key={room.id}
               onClick={() => changeChatRoom(room)}
               style={{
                  backgroundColor:
                     room.id === activeChatRoomId ? '#ffffff45' : '',
               }}
            >
               # {room.name}
            </li>
         );
      });

   return (
      <div>
         <div
            style={{
               position: 'relative',
               width: '100%',
               display: 'flex',
               alignItems: 'center',
            }}
         >
            <FaRegSmileWink style={{ marginRight: 3 }} /> CHAT ROOMS{' '}
            <FaPlus onClick={() => setShow(!show)} />
         </div>

         <ul style={{ listStyleType: 'none', padding: 0 }}>
            {renderChatRooms(chatRooms)}
         </ul>

         <Modal show={show} onHide={() => setShow(false)}>
            <Modal.Header closeButton>
               <Modal.Title>채팅 방 생성하기</Modal.Title>
            </Modal.Header>
            <Modal.Body>
               <Form>
                  <Form.Group>
                     <Form.Label>채팅 방 이름</Form.Label>
                     <Form.Control
                        onChange={(e) => setName(e.target.value)}
                        type='text'
                        placeholder='채팅 방 이름을 입력하세요.'
                     />
                  </Form.Group>
                  <Form.Group>
                     <Form.Label>채팅 방 설명</Form.Label>
                     <Form.Control
                        onChange={(e) => setDescription(e.target.value)}
                        type='text'
                        placeholder='채팅 방 설명을 입력하세요.'
                     />
                  </Form.Group>
               </Form>
            </Modal.Body>
            <Modal.Footer>
               <Button variant='primary' onClick={handleSubmit}>
                  생성
               </Button>
               <Button variant='secondary' onClick={() => setShow(false)}>
                  취소
               </Button>
            </Modal.Footer>
         </Modal>
      </div>
   );
};

export default ChatRooms;
