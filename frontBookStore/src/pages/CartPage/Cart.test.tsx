import { createStore } from 'easy-peasy';
import { customRender as render, waitFor } from '../../utils/test-helper';
import Cart from "./Cart"
import { appStoreModel } from '../../store';
import { describe, expect, it, vi } from 'vitest';

const mock = {
    get: vi.fn()
};

const store = createStore(appStoreModel, {
    injections: {
        httpService : mock
    },
    initialState: {
        cart : {
            cart: [{ book: { id : 1, title : 'Harry Potter', author: 'JK rowling', price: 400, quantity: 400}, quantity: 400, user: {}}]
        }
    }
})

describe('Cart Page', () => {
    it('Cart Page should load properly - snapshot', async () => {
        const {container}  = render(<Cart/>, store);
        waitFor(() => {
            expect(container).toMatchSnapshot();
        })
    });

    it('Cart Page should contain Search component', async () => {
        const {getByText}  = render(<Cart/>, store);
        waitFor(() => {
            expect(getByText('You Cart View')).toBeDefined();
        })
    });

    it('Cart Page should contain Button component', async () => {
        const {getByRole}  = render(<Cart/>, store);
        waitFor(() => {
            expect(getByRole('button', { name : 'Go to Summary'})).toBeDefined();
        })
    });
})