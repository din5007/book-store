import { useEffect } from "react";
import { Row, Col } from "react-bootstrap";
import Button from "react-bootstrap/Button";
import Card from "react-bootstrap/Card";
import { useStoreActions, useStoreState } from "../../store/hooks";

function BookCard() {
  const { books } = useStoreState((state) => state.books);
  const { fetchAllBooks } = useStoreActions((actions) => actions.books);
  const { addToCart, fetchUserCart } = useStoreActions((actions) => actions.cart);
  
  useEffect(() => {fetchAllBooks({}); fetchUserCart({});}, []);

  return (
    <>
      <Row className="m-auto">
        {books?.map(({ id, title, author, price}) => (
          <Col key={id}>
            <Card className="w-100">
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
