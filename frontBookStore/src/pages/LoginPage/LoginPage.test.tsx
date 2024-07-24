import { createStore } from 'easy-peasy';
import { appStoreModel } from '../../store';
import { customRender as render } from '../../utils/test-helper';
import LoginPage from "./LoginPage"
import { describe, expect, it, vi } from 'vitest';

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

describe('Login Page', () => {
    it('Login Page should load properly - snapshot', async () => {
        const {container}  = render(<LoginPage />, store);
        expect(container).toMatchSnapshot();
    });
})