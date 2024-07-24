import { action, Action, thunk, Thunk, ThunkOn } from "easy-peasy";
import { UserBookDto } from "../../dto/dtos";
import { AppStoreModel } from "..";

export interface OrderModel {
    createOrder: Thunk<OrderModel, any, any, AppStoreModel>;
}

export const orderModel : OrderModel = {
    createOrder: thunk(async (actions, _, { injections }) => {
        const { httpService } = injections;
        try {
            const rsponse = await httpService.post('/api/order/create', {}, { headers: {
                'Authorization' : localStorage.getItem('jwt')
            }});
            //toastr would be better
        } catch (error) {
            console.info('error occured', error);
        }
    }),
};