import { FC, useState } from "react";
import { Button, Card } from "react-bootstrap";
import { useStoreActions } from "../../store/hooks";

const Counter : FC<{id: number, quantity: number}> = ({ id, quantity }) => {
    const { addToCart, decrementQuantity } = useStoreActions((actions) => actions.cart);
    const [count, setCount] = useState(quantity);

    return (
        <>
        <Button type="button" size="sm" disabled={count == 1} onClick={() => { 
            decrementQuantity({  id });
            setCount(prev => prev - 1);
          }}>-</Button>
          <Card.Text>&nbsp;{count}&nbsp;</Card.Text>
          <Button type="button" size="sm" disabled={count == 10} onClick={() => {
            addToCart({  id });
            setCount(prev => prev + 1);
          }}>+</Button>
        </>
    );
}
export default Counter;