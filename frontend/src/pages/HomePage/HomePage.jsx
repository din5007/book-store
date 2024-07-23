import { useEffect } from "react";
import React from "react";
import Container from "react-bootstrap/esm/Container";
import Button from "react-bootstrap/esm/Button";
import Row from "react-bootstrap/esm/Row";
import "./HomePage.css";
import { useStoreState } from "../../store/hooks";

const HomePage = () => {
  const { isUserLoggedIn } = useStoreState(state => state.user);

  return (
    <div className="main">
      <Container>
        <Row>
          <div className="intro-text">
            <div>
              <h1 className=" title text-primary">Welcome to Awesome Book Store</h1>
            </div>
            { !isUserLoggedIn && !localStorage.getItem('jwt') ? 
            <div className="buttonContainer">
              <a href="/login">
                <Button size="lg" className="landingbutton">
                  Login
                </Button>
              </a>
              <a href="/register">
                <Button
                  size="lg"
                  className="landingbutton"
                  variant="outline-primary"
                >
                  SignUp
                </Button>
              </a>
            </div> : <></>}
          </div>
        </Row>
      </Container>
    </div>
  );
};

export default HomePage;