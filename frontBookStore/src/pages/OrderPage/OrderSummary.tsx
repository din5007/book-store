import { Button, ListGroup } from "react-bootstrap";
import { useStoreActions, useStoreState } from "../../store/hooks";

const OrderSummary = () => {
  const { cart, totalPrice } = useStoreState((store) => store.cart);
  const { createOrder } = useStoreActions((actions) => actions.order);



  return (
    <div style={{ margin : '5%'}}>
      <div className="page d-flex justify-content-between">
        <h1> Your Order Summary </h1>
        <Button
          variant="primary"
          size="lg"
          disabled={!cart.length}
          onClick={() => createOrder({})}
        >
          Order Now !
        </Button>
      </div>
      <div style={{ margin : '50px'}}>
        <ListGroup>
            {cart?.map(({ book, quantity }) => (
            <ListGroup.Item as="li">
                <strong>{book?.title.toUpperCase()}</strong> <span style={{ float : 'right'}}>{quantity} * {book.price} = {quantity * book.price}</span>
            </ListGroup.Item>
            ))}
        </ListGroup>
        <h3 style={{ float: "right"}}> Final Order Value : {totalPrice}</h3>
      </div>
    </div>
  );
};

export default OrderSummary;
