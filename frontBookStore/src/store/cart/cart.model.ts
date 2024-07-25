import { action, Action, computed, Computed, thunk, Thunk } from "easy-peasy";
import { UserBookDto } from "../../dto/dtos";
import { AppStoreModel } from "..";
import { toast } from "react-toastify";

export interface CartModel {
    cart: UserBookDto[];
    setCartInfo: Action<CartModel, any>;
    fetchUserCart: Thunk<CartModel, any, any, AppStoreModel>;
    addToCart: Thunk<CartModel, any, any, AppStoreModel>;
    decrementQuantity: Thunk<CartModel, any, any, AppStoreModel>;
    removeFromCart: Thunk<CartModel, any, any, AppStoreModel>;
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
            const rsponse = await httpService.get('/api/cart', {}, {
                headers: {
                    'Authorization': localStorage.getItem('jwt')
                }
            });
            actions.setCartInfo(rsponse.cartDtoList);
        } catch (error) {
            toast('Error Occured. Please reach out to support');
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
            toast.success('Added to your cart successfully..');
        } catch (error) {
            toast.error('Error Occured. Please reach out to support');
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
            toast.error('Error Occured. Please reach out to support');
        }
    }),
    // Helps to calculate the totalprice on Summary
    totalPrice: computed([(state) => state.cart], (cart) => cart.reduce((prev, curr) => {
        return prev + curr.book.price * curr.quantity;
    }, 0)),
    removeFromCart: thunk(async (_actions, { id }, { injections }) => {
        const { httpService } = injections;
        try {
            await httpService.delete(`/api/cart/${id}/remove`, {
                headers: {
                    'Authorization': localStorage.getItem('jwt')
                }
            });
            toast.success('Removed from cart successfully..');
        } catch (error) {
            toast.error('Error Occured. Please reach out to support');
        }
    })
};