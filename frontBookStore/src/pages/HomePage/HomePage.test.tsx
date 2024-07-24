import { createStore } from 'easy-peasy';
import { appStoreModel } from '../../store';
import { customRender as render } from '../../utils/test-helper';
import HomePage from "./HomePage"
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

describe('Home Page', () => {
    it('Home Page should load properly - snapshot', async () => {
        const {container}  = render(<HomePage />, store);
        expect(container).toMatchSnapshot();
    });
})