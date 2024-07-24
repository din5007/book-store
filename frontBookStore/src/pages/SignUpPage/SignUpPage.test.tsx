import { createStore } from 'easy-peasy';
import { customRender as render } from '../../utils/test-helper';
import SignUpPage from "./SignUpPage"
import { describe, expect, it, vi } from 'vitest';
import { appStoreModel } from '../../store';

const mock = {
    get: vi.fn()
};

const store = createStore(appStoreModel, {
    injections: {
        httpService : mock
    },
    initialState: {
        
    }
})

describe('SignUp Page', () => {
    it('SignUp Page should load properly - snapshot', async () => {
        const {container}  = render(<SignUpPage />, store);
        expect(container).toMatchSnapshot();
    });
})