import React, { useEffect, useState } from "react";
import { Container, Form, Button, Alert } from "react-bootstrap";
import { Link, useNavigate } from "react-router-dom";
import { useDispatch, useSelector } from "react-redux";
import { userActions } from "../action/userAction";

import "../style/login.style.css";

const Login = () => {

  const dispatch = useDispatch();
  const navigate = useNavigate();
  const { user } = useSelector((state) => state.user);
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const error = useSelector((state) => state.user.error);

  useEffect(() => {
    return () => {
      dispatch(userActions.clearError());
    };
  }, [dispatch]);

  const loginWithEmail = (event) => {
    event.preventDefault();
    //이메일,패스워드를 가지고 백엔드로 보내기
    dispatch(userActions.loginWithEmail({ email, password }));
  };

  const handleGoogleLogin = async (googleData) => {
    // 구글로 로그인 하기
  };

  //이미 로그인 한 유저가 다시 login처리가 되지 않기 위해 밖으로 뺌
  useEffect(() => {
    if (user) {
      navigate("/");
    }
  }, [user, navigate]);

  return (
    <Container className="login-area">
      {error && (
        <div className="error-message">
          <Alert variant="danger">{error}</Alert>
        </div>
      )}
      <Form className="login-form" onSubmit={loginWithEmail}>
        <Form.Group className="mb-3" controlId="formBasicEmail">
          <Form.Label>이메일 아이디</Form.Label>
          <Form.Control
            type="email"
            placeholder="이메일을 입력하세요"
            required
            onChange={(event) => setEmail(event.target.value)}
          />
        </Form.Group>

        <Form.Group className="mb-3" controlId="formBasicPassword">
          <Form.Label>비밀번호</Form.Label>
          <Form.Control
            type="password"
            placeholder="비밀번호를 입력하세요"
            required
            onChange={(event) => setPassword(event.target.value)}
          />
        </Form.Group>

        {/* <div className="display-space-between login-button-area">
          <Button variant="primary" type="submit">
            로그인
          </Button>
          <div>
            계정이 없으신가요? <Link to="/register">회원가입 하기</Link>
          </div>
        </div> */}

        <div className="display-space-between login-button-area">
          <Button variant="dark" type="submit">
            로그인
          </Button>
          <Link to="/register">
            <Button variant="dark">
              회원가입
            </Button>
          </Link>
        </div>

        <div className="text-align-center mt-2">
          <p>- 외부 계정으로 로그인하기 -</p>
          <div className="display-center">
            {/* 구글 로그인 버튼 등을 여기에 추가하세요 */}
          </div>
        </div>
      </Form>
    </Container>
  );
};

export default Login;
