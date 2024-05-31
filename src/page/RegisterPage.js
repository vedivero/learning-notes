import React, { useState } from "react";
import { Container, Form, Button, Alert } from "react-bootstrap";
import { useDispatch, useSelector } from "react-redux";
import { useNavigate } from "react-router";
import { userActions } from "../action/userAction";
import "../style/register.style.css";
const RegisterPage = () => {
  const dispatch = useDispatch();

  //회원가입 입력 폼 객체화, 사용자가 입력한 값 읽어오기
  const [formData, setFormData] = useState({
    email: "",
    name: "",
    password: "",
    confirmPassword: "",
    policy: false,
  });

  const navigate = useNavigate();
  const [passwordError, setPasswordError] = useState("");
  const [policyError, setPolicyError] = useState(false);
  const error = useSelector((state) => state.user.error);

  const register = (event) => {
    event.preventDefault();

    //form의 데이터 전체 읽어오기
    const { name, email, password, confirmPassword, policy } = formData;
    // 비번 중복확인 일치하는지 확인
    if (password !== confirmPassword) {
      return setPasswordError("입력하신 비밀번호가 서로 일치하지 않습니다.");
    }
    // 이용약관에 체크하지 않은 경우
    if (!policy) {
      return setPolicyError(true)
    }

    //에러메세지 초기화
    setPasswordError("");
    setPolicyError(false);

    // FormData에 있는 값을 가지고 백엔드로 넘겨주기
    dispatch(userActions.registerUser({ name, email, password }, navigate));

    //성공후 로그인 페이지로 넘어가기

  };

  const handleChange = (event) => {

    // 값을 읽어서 FormData에 넣어주기
    //데이터를 입력할 때 마다 받아오는 값
    const { id, value, checked } = event.target;
    console.log(id, checked)

    if (id === "policy") {
      setFormData({ ...formData, [id]: checked })
    } else {
      //전체 formData에서 id값의 value를 넣는다
      setFormData({ ...formData, [id]: value });
    }

  };

  return (
    <Container className="register-area">
      {error && (
        <div>
          <Alert variant="danger" className="error-message">
            {error}
          </Alert>
        </div>
      )}
      <Form onSubmit={register}>
        <Form.Group className="mb-3">
          <Form.Label>Email</Form.Label>
          <Form.Control
            type="email"
            id="email"
            placeholder="Enter email"
            onChange={handleChange} //form에 입력할 때 마다 호출
            required
          />
        </Form.Group>
        <Form.Group className="mb-3">
          <Form.Label>Name</Form.Label>
          <Form.Control
            type="text"
            id="name"
            placeholder="Enter name"
            onChange={handleChange}
            required
          />
        </Form.Group>
        <Form.Group className="mb-3">
          <Form.Label>Password</Form.Label>
          <Form.Control
            type="password"
            id="password"
            placeholder="Password"
            onChange={handleChange}
            required
          />
        </Form.Group>
        <Form.Group className="mb-3">
          <Form.Label>Confirm Password</Form.Label>
          <Form.Control
            type="password"
            id="confirmPassword"
            placeholder="Confirm Password"
            onChange={handleChange}
            required
            isInvalid={passwordError}
          />
          <Form.Control.Feedback type="invalid">
            {passwordError}
          </Form.Control.Feedback>
        </Form.Group>
        <Form.Group className="mb-3">
          <Form.Check
            type="checkbox"
            label="이용약관에 동의합니다"
            id="policy"
            onChange={handleChange}
            isInvalid={policyError}
            checked={formData.policy}
          />
        </Form.Group>
        <Button variant="danger" type="submit">
          회원가입
        </Button>
      </Form>
    </Container>
  );
};

export default RegisterPage;
