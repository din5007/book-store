import { createStore } from 'easy-peasy';
import { customRender as render } from '../../utils/test-helper';
import Navigation from "./Navbar";
import { appStoreModel } from '../../store';

const store = createStore(appStoreModel, {
    injections: {
        httpservice : () => jest.fn()
    },
    initialState: {
        user: {
            isUserLoggedIn: false
        }
    },
    mockActions: true
})

describe('Navigation', () => {
    it('Navigation should load properly with given params - snapshot', () => {
        const {container}  = render(<Navigation><p>children</p></Navigation>, store);
        expect(container).toMatchSnapshot()
    });
})