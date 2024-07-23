import { createStore } from 'easy-peasy';
import { customRender as render } from '../../utils/test-helper';
import Counter from "./Counter"
import { appStoreModel } from '../../store';

const store = createStore(appStoreModel, {
    injections: {
        httpservice : () => jest.fn()
    },
    initialState: {

    }
})

describe('Counter', () => {
    it('Counter should load properly with given params - snapshot', () => {
        const {container}  = render(<Counter id={10} quantity={100}/>, store);
        expect(container).toMatchSnapshot()
    });
})