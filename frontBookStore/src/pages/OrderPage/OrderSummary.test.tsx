import { createStore } from 'easy-peasy';
import { appStoreModel } from '../../store';
import { customRender as render } from '../../utils/test-helper';
import OrderSummary from "./OrderSummary"
import { describe, expect, it, vi } from 'vitest';

const mock = {
    get: vi.fn()
};

const store = createStore(appStoreModel, {
    injections: {
        httpService : mock
    },
    initialState: {
        order : {
            
        }
    }
})

describe('Order Summary Page', () => {
    it('Order Summary Page should load properly - snapshot', async () => {
        const {container}  = render(<OrderSummary />, store);
        expect(container).toMatchSnapshot();
    });
})