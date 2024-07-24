import { action, Action, computed, Computed, thunk, Thunk } from "easy-peasy";
import { UserBookDto } from "../../dto/dtos";
import { AppStoreModel } from "..";

export interface CartModel {
    cart: UserBookDto[];
    setCartInfo: Action<CartModel, any>;
    fetchUserCart: Thunk<CartModel, any, any, AppStoreModel>;
    addToCart: Thunk<CartModel, any, any, AppStoreModel>;
    decrementQuantity: Thunk<CartModel, any, any, AppStoreModel>;
    totalPrice : Computed<CartModel, any, AppStoreModel>;
}

export const cartModel : CartModel = {
    cart: [],
    setCartInfo: action((state, cartData) => {
        state.cart = cartData;
    }),
    fetchUserCart: thunk(async (actions, _, { injections }) => {
        const { httpService } = injections;
        try {
            const rsponse = await httpService.get('/api/cart', {
                headers: {
                    'Authorization': localStorage.getItem('jwt')
                }
            });
            console.info(rsponse);
            actions.setCartInfo(rsponse.cartDtoList);
        } catch (error) {
            console.info('error occured');
            actions.setCartInfo([]);
        }
    }),
    addToCart: thunk(async (_actions, { id }, { injections }) => {
        const { httpService } = injections;
        try {
            await httpService.put(`/api/cart/${id}/add`, null, {
                headers: {
                    'Authorization': localStorage.getItem('jwt')
                }
            });
        } catch (error) {
            console.info('error occured');
        }
    }),
    decrementQuantity: thunk(async (_actions, { id }, { injections }) => {
        const { httpService } = injections;
        try {
            await httpService.put(`/api/cart/${id}/decrement`, null, {
                headers: {
                    'Authorization': localStorage.getItem('jwt')
                }
            });
        } catch (error) {
            console.info('error occured');
        }
    }),
    // Helps to calculate the totalprice on Summary
    totalPrice: computed([(state) => state.cart], (cart) => cart.reduce((prev, curr) => {
        return prev + curr.book.price * curr.quantity;
    }, 0))
};