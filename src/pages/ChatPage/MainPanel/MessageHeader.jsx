import React from 'react';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import InputGroup from 'react-bootstrap/InputGroup';
import FormControl from 'react-bootstrap/FormControl';
import Image from 'react-bootstrap/Image';
import { AiOutlineSearch } from 'react-icons/ai';
import { useSelector } from 'react-redux';
import { FaLock, FaLockOpen } from 'react-icons/fa';

const MessageHeader = ({ handleSearchChange }) => {
   const { currentChatRoom } = useSelector((state) => state.chatRoom);
   const { isPrivateChatRoom } = useSelector((state) => state.chatRoom);

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
               <h2>{isPrivateChatRoom ? <FaLock style={{ marginBottom: 10 }} /> : <FaLockOpen />}</h2>{' '}
               <span>{currentChatRoom?.name}</span>
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
