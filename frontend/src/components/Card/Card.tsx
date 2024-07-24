import { useEffect } from "react";
import { Row, Col } from "react-bootstrap";
import Button from "react-bootstrap/Button";
import Card from "react-bootstrap/Card";
import { useStoreActions, useStoreState } from "../../store/hooks";

function BookCard() {
  const { books } = useStoreState((state) => state.books);
  const { fetchAllBooks } = useStoreActions((actions) => actions.books);
  const { addToCart } = useStoreActions((actions) => actions.cart);
  
  useEffect(() => {fetchAllBooks();}, []);
  return (
    <>
      <Row xs={1} md={3} lg={4} className="g-4 m-auto">
        {books?.map(({ id, title, author, price, quantity}) => (
          <Col key={id}>
            <Card style={{ width: "18rem" }}>
              <Card.Body>
                <Card.Title>{title.toUpperCase()}</Card.Title>
                <Card.Text>{author.toUpperCase()}</Card.Text>
                <Card.Text>Price : {price} INR</Card.Text>
                <Button variant="primary" onClick={() => addToCart({ id })}>Add to Cart</Button>
              </Card.Body>
            </Card>
          </Col>
        ))}
      </Row>
    </>
  );
}

export default BookCard;
