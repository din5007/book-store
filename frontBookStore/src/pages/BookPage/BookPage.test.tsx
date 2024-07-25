import { createStore } from 'easy-peasy';
import { customRender as render, waitFor } from '../../utils/test-helper';
import BookPage from "./BookPage"
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

describe('Book Page', () => {
    it('Book Page should load properly - snapshot', async () => {
        const {container}  = render(<BookPage/>, store);
        waitFor(() => {
            expect(container).toMatchSnapshot();
        });
    });

    it('Book Page should contain Search component', async () => {
        const {getByPlaceholderText}  = render(<BookPage/>, store);
        waitFor(() => {
            expect(getByPlaceholderText('Search by Book Name')).toBeDefined();
        })
    });
})