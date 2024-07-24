import { Row, Col } from 'react-bootstrap';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import { useStoreActions, useStoreState } from '../../store/hooks';
import { useEffect } from 'react';
import Counter from '../Counter/Counter';

function CartViewList() {
  const { fetchUserCart } = useStoreActions((actions) => actions.cart);
  const { cart } = useStoreState((state) => state.cart);

  useEffect(() => {
    fetchUserCart({});
  }, []);

  return (
    <Row xs={1} md={2} lg={4} className="g-4 m-auto">
        {cart?.map(({book, quantity}, idx) => 
            <Col  key={idx}>
                <Card style={{ width: '18rem' }}>
                <Card.Body>
                    <Card.Title>{book?.title }</Card.Title>
                    <Card.Text>{book?.author}</Card.Text>
                </Card.Body>
                <Card.Footer className='d-flex align-items-baseline justify-content-center text-center'>
                  <Counter id={book?.id} quantity={quantity}/>
                </Card.Footer>
                <Button type="button" size="sm" variant='outline-warning' onClick={() => {}}>Remove from the cart</Button> 
                </Card>
            </Col>
        )}
    </Row>
  );
}

export { CartViewList };