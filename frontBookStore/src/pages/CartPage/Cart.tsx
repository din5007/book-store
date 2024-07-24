import { Button, Container, Row } from "react-bootstrap"
import CartViewList from "../../components/Cart"
import { FC } from "react"
import { useStoreState } from "../../store/hooks"
import { useNavigate } from "react-router"

const Cart : FC<{}> = () => {
    const navigate = useNavigate();
    const { cart } = useStoreState((state) => state.cart);

    return (<div style={{ margin: '5%'}}>
      <Container>
        <Row>
          <div className="page d-flex justify-content-between">
            <h1>You Cart View</h1>
            <Button variant="primary" size="lg" disabled={!cart.length} onClick={() => navigate('/order-summary')}> Go to Summary !</Button> 
          </div>
          <CartViewList />
        </Row>
      </Container>
    </div>)
}

export default Cart;