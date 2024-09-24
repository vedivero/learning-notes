//채팅방의 이름이 나열되는 컴포넌트
import React, { useState } from 'react';
import { Button, Form, Modal } from 'react-bootstrap';
import { FaPlus, FaRegSmileWink } from 'react-icons/fa';
import { ref as dbRef, ref } from 'firebase/database';
import { db } from '../../../firebase';
import { useDispatch, useSelector } from 'react-redux';

const ChatRooms = () => {
   const [show, setShow] = useState(false); //false일 때는 modal이 안 보이게끔
   const [name, setName] = useState(''); //채팅 방 이름
   const [description, setDescription] = useState(''); //채팅 방 설명
   const ChatRoomsRef = dbRef(db, 'chatRooms');

   const [chatRooms, setChatRooms] = useState([]); //여러 채팅 방을 저장하기 위해 배열로 선언
   const [firstLoad, setFirstLoad] = useState(true); //첫 실행 시에만 true, 그 이후는 false
   const [activeChatRoomId, setActiveChatRoomId] = useState('');

   const { currentUser } = useSelector((state) => state.user); //현재 로그인 한 user의 데이터

   const dispatch = useDispatch();

   const handleSubmit = () => {};

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

         <Modal show={show} onHide={() => setShow(false)}>
            <Modal.Header closeButton>
               <Modal.Title>채팅 방 생성하기</Modal.Title>
            </Modal.Header>
            <Modal.Body>
               <Form onSubmit={handleSubmit}>
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
                        onChange={(e) => setName(e.target.value)}
                        type='text'
                        placeholder='채팅 방 설명을 입력하세요.'
                     />
                  </Form.Group>
               </Form>
            </Modal.Body>
            <Modal.Footer>
               <Button variant='primary'>생성</Button>
               <Button variant='secondary' onClick={() => setShow(false)}>
                  취소
               </Button>
            </Modal.Footer>
         </Modal>
      </div>
   );
};

export default ChatRooms;
