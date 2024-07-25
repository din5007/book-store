import { action, Action, thunk, Thunk } from "easy-peasy";
import { UserDto } from "../../dto/dtos";
import { AppStoreModel } from "..";
import { toast } from "react-toastify";

export interface UserModel {
    user: UserDto | null;
    isUserLoggedIn: boolean;
    setUserInfo: Action<UserModel, any>;
    setIsUserLoggedIn: Action<UserModel, boolean>;
    logIn: Thunk<UserModel, any, any, AppStoreModel>;
    signUp: Thunk<UserModel, any, any, AppStoreModel>;
}

export const userModel : UserModel = {
    user: null,
    isUserLoggedIn: false,
    setUserInfo: action((state, cartData) => {
        state.user = cartData;
    }),
    setIsUserLoggedIn: action((state, loggedIn) => {
        state.isUserLoggedIn = loggedIn;
    }),
    logIn: thunk(async (actions, { email, password }, { injections }) => {
        const { httpService } = injections;
        try {
            const rsponse = await httpService.post('/api/users/login', { email, password }, { });
            localStorage.setItem('jwt', `Bearer ${rsponse?.token}`);
            actions.setUserInfo(rsponse?.userInfo);
            actions.setIsUserLoggedIn(true);
        } catch (error) {;
            toast.error('Error Occured. Please reach out to support');;
            actions.setUserInfo(null);
            actions.setIsUserLoggedIn(false);
        }
    }),
    signUp: thunk(async (_actions, { email, password, name : userName }, { injections }) => {
        const { httpService } = injections;
        try {
            const response = await httpService.post('/api/users/signup', { email, password, userName}, {});
            if(response) toast.error('Successfully Signed In');
        } catch (error) {
            toast.error('Error Occured. Please reach out to support');;
        }
    })
};