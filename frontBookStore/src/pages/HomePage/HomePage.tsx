import Container from "react-bootstrap/esm/Container";
import Button from "react-bootstrap/esm/Button";
import Row from "react-bootstrap/esm/Row";
import { useStoreState } from "../../store/hooks";

const HomePage = () => {
  const { isUserLoggedIn } = useStoreState(state => state.user);

  return (
    <div style={{
      minHeight: "93vh",
    display: "flex",
    alignItems: "center"
    }}>
      <Container>
        <Row>
          <div style={{
            width: "100%",
            textAlign: "center",
            paddingBottom: "80px"
          }}>
            <div>
              <h1 className="text-primary" style={{fontSize: "95px"}}>Welcome to Awesome Book Store</h1>
            </div>
            { !isUserLoggedIn && !localStorage.getItem('jwt') ? 
            <div style={{
              marginTop: "60px",
    display: "flex",
    justifyContent: "space-evenly"
            }}>
              <a href="/login">
                <Button size="lg" className="landingbutton" style={{width: "200px",
    height: "55px"}}>
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