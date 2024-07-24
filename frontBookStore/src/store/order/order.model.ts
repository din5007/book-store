import { thunk, Thunk } from "easy-peasy";
import { AppStoreModel } from "..";

export interface OrderModel {
    createOrder: Thunk<OrderModel, any, any, AppStoreModel>;
}

export const orderModel : OrderModel = {
    createOrder: thunk(async (_actions, _, { injections }) => {
        const { httpService } = injections;
        try {
            await httpService.post('/api/order/create', {}, { headers: {
                'Authorization' : localStorage.getItem('jwt')
            }});
            //toastr would be better
        } catch (error) {
            console.info('error occured', error);
        }
    }),
};