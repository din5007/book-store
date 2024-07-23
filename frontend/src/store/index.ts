import { HttpService } from "../service/http/http.service";
import { createStore } from 'easy-peasy';
import { BookModel, booksModel } from "./books/books.model";
import { cartModel, CartModel } from "./cart/cart.model";
import { userModel, UserModel } from "./users/user.model";
import { OrderModel, orderModel } from "./order/order.model";

export interface AppStoreModel {
    books: BookModel;
    cart: CartModel;
    user: UserModel;
    order: OrderModel;
}

export const appStoreModel : AppStoreModel = {
    books: booksModel,
    cart: cartModel,
    user: userModel,
    order: orderModel,
}

export function storeModel() {
    return createStore(appStoreModel, {
        injections: {
            httpService: new HttpService()
        },
        initialState: {
            
        },
    })
}
export const store =  storeModel();