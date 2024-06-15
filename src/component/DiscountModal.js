import React, { useState } from 'react';
import { Modal, Button, Form } from 'react-bootstrap';

const DiscountModal = ({ show, handleClose, applyDiscount, restorePrice }) => {
	const [discount, setDiscount] = useState(0);

	const handleSave = () => {
		applyDiscount(discount);
		handleClose();
	};

	const handleRestore = () => {
		restorePrice();
		handleClose();
	};

	return (
		<Modal show={show} onHide={handleClose}>
			<Modal.Header closeButton>
				<Modal.Title>세일 설정</Modal.Title>
			</Modal.Header>
			<Modal.Body>
				<Form>
					<Form.Group controlId="formDiscount">
						<Form.Label>할인율 (%)</Form.Label>
						<Form.Control
							type="number"
							value={discount}
							onChange={(e) => setDiscount(e.target.value)}
							min="0"
							max="100"
						/>
					</Form.Group>
				</Form>
			</Modal.Body>
			<Modal.Footer style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
				<Button variant="success" onClick={handleRestore}>
					할인 전 가격으로 복구
				</Button>
				<div style={{ display: 'flex', gap: '10px' }}>
					<Button variant="secondary" onClick={handleClose}>
						취소
					</Button>
					<Button variant="primary" onClick={handleSave}>
						저장
					</Button>
				</div>
			</Modal.Footer>
		</Modal>
	);
};

export default DiscountModal;
