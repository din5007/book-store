import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import { useStoreState } from "../../store/hooks";
import { Badge } from "react-bootstrap";
import { Link } from "react-router-dom";

const Navigation = ({ children }) => {
  const { isUserLoggedIn } = useStoreState((state) => state.user);
  const { cart } = useStoreState((state) => state.cart);

  return (
    <>
      <Navbar expand="lg" className="bg-body-tertiary">
        <Container>
          <Navbar.Brand to="/home" as={Link}>Book Store</Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="me-auto">
              {!isUserLoggedIn && !localStorage.getItem("jwt") ? (
                <>
                  <Nav.Link as={Link} to="/login">Login</Nav.Link>
                  <Nav.Link as={Link} to="/register">Sign Up</Nav.Link>
                </>
              ) : (
                <>
                  <Nav.Link as={Link} to="/books">Books</Nav.Link>
                  <Nav.Link as={Link} to="/cart">
                    Cart{'    '}
                    <Badge pill bg="secondary">
                      {cart?.length}
                    </Badge>
                  </Nav.Link>
                </>
              )}
            </Nav>
          </Navbar.Collapse>
        </Container>
      </Navbar>
      {children}
    </>
  );
};

export default Navigation;
