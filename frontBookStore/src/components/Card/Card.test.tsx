import { createStore } from 'easy-peasy';
import { customRender as render, waitFor } from '../../utils/test-helper';
import Card from "./Card"
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
        books : {
            books: [{ id : 1, title : 'Harry Potter', author: 'JK rowling', price: 400, quantity: 400}]
        }
    }
})

describe('Card', () => {
    it('Card should load properly - snapshot', () => {
        const {container}  = render(<Card/>, store);
        expect(container).toMatchSnapshot();
    });

    it('Card should contain proper fields', async () => {
        const { getByText }  = render(<Card/>, store);
        waitFor(() => {
            expect(getByText('HARRY POTTER')).toBeDefined();
            expect(getByText('JK ROWLING')).toBeDefined();
            expect(getByText('400')).toBeDefined();
            expect(getByText('Add to Cart')).toBeDefined();
        })
    });

    it('fetchAllBooks request should be triggered when component renders', async () => {
        render(<Card/>, store);
        expect(mock.get).toBeCalled();
    });
})