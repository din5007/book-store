
import { useState } from "react";
import Button from "react-bootstrap/Button";
import Col from "react-bootstrap/esm/Col";
import Row from "react-bootstrap/esm/Row";
import Form from "react-bootstrap/Form";
import { Link } from "react-router-dom";
import "./SignUpPage.css";
import ErrorMessage from "../CommonPages/ErrorPage";
import Loading from "../CommonPages/LoadingPage";
import MainPage from "../MainPage/MainPage";
import { useStoreActions } from "../../store/hooks";

const SignUpPage = () => {
  const [email, setEmail] = useState("");
  const [name, setName] = useState("");
  const [password, setPassword] = useState("");
  const [confirmpassword, setConfirmPassword] = useState("");
  const [message, setMessage] = useState("");
  const [error, setError] = useState(false);
  const [loading, setLoading] = useState(false);

  const { signUp } = useStoreActions((actions) => actions.user);

  const submitHandler = async (e : any) => {
    e.preventDefault();

    if (password !== confirmpassword) {
      setMessage("Password Do Not Match");
    } else {
      setMessage("null");
      try {
        setLoading(true);
        signUp({ name, email, password});
        setLoading(false);
      } catch (error : any) {
        setError(error.response.data.message);
      }
    }
  };

  return (
    <MainPage title="Register">
      <div className="loginContainer">
        {error && <ErrorMessage variant="danger">{error}</ErrorMessage>}
        {message && <ErrorMessage variant="danger">{message}</ErrorMessage>}
        {loading && <Loading />}
        <Form onSubmit={submitHandler}>
          <Form.Group className="mb-3" controlId="name">
            <Form.Label>Name</Form.Label>
            <Form.Control
              type="name"
              value={name}
              placeholder="Enter User name"
              onChange={(e) => setName(e.target.value)}
            />
          </Form.Group>

          <Form.Group className="mb-3" controlId="formBasicEmail">
            <Form.Label>Email address</Form.Label>
            <Form.Control
              type="email"
              value={email}
              placeholder="Enter Your Email"
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

          <Form.Group className="mb-3" controlId="confirmPassword">
            <Form.Label>Confirm Password</Form.Label>
            <Form.Control
              type="password"
              value={confirmpassword}
              placeholder="Enter Your Confirm Password"
              onChange={(e) => setConfirmPassword(e.target.value)}
            />
          </Form.Group>
          <Button variant="primary" type="submit">
            Register
          </Button>
        </Form>
        <Row className="py-3">
          <Col>
            Have an Account Already ? <Link to="/login">Login</Link>
          </Col>
        </Row>
      </div>
    </MainPage>
  );
};

export default SignUpPage;
