import { thunk, Thunk } from "easy-peasy";
import { AppStoreModel } from "..";
import { toast } from "react-toastify";

export interface OrderModel {
    createOrder: Thunk<OrderModel, any, any, AppStoreModel>;
}

export const orderModel : OrderModel = {
    createOrder: thunk(async (_actions, _, { injections }) => {
        const { httpService } = injections;
        try {
            const response = await httpService.post('/api/order/create', {}, { headers: {
                'Authorization' : localStorage.getItem('jwt')
            }});
            if(response) toast.success('Order Completed Successfully');
        } catch (error) {
            toast.error('Error Occured. Please reach out to support');;
        }
    }),
};