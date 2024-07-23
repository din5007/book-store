
import React, { FC, useState } from "react";
import Button from "react-bootstrap/Button";
import Col from "react-bootstrap/esm/Col";
import Row from "react-bootstrap/esm/Row";
import Form from "react-bootstrap/Form";
import MainPage from "../MainPage/MainPage";
import { Link } from "react-router-dom";
import ErrorMessage from "../CommonPages/ErrorPage";
import Loading from "../CommonPages/LoadingPage";
import { useStoreActions, useStoreState } from "../../store/hooks";
import "./LoginPage.css";
import { useNavigate } from "react-router-dom";

const LoginPage : FC<{}> = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState(false);
  const [loading, setLoading] = useState(false);
  const { logIn } = useStoreActions((actions) => actions.user);
  const navigate = useNavigate();
  

  const submitHandler = async (e: any) => {
    e.preventDefault();
    setLoading(true);
    try {
      logIn({ email, password });
      navigate('/books');
      setLoading(false);
    } catch (error : any) {
      setError(error.reponse.date.message);
      setLoading(false);
    }
  };

  return (
    <MainPage title="LOGIN">
      <div className="loginContainer">
        {error && <ErrorMessage variant="danger">{error}</ErrorMessage>}
        {loading && <Loading />}
        <Form onSubmit={submitHandler}>
          <Form.Group className="mb-3" controlId="formBasicEmail">
            <Form.Label>Email Address</Form.Label>
            <Form.Control
              type="email"
              value={email}
              placeholder="Enter Your Email Address"
              onChange={(e) => setEmail(e.target.value)}
            />
          </Form.Group>

          <Form.Group className="mb-3" controlId="formBasicPassword">
            <Form.Label>Password</Form.Label>
            <Form.Control
              type="password"
              value={password}
              placeholder="Enter Your Password"
              onChange={(e) => setPassword(e.target.value)}
            />
          </Form.Group>

          <Button variant="primary" type="submit">
            Submit
          </Button>
        </Form>
        <Row className="py-3">
          <Col>
            New User ? <Link to="/register">Register Here</Link>
          </Col>
        </Row>
      </div>
    </MainPage>
  );
};

export default LoginPage;
