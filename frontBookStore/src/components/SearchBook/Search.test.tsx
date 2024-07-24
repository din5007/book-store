
import userEvent from '@testing-library/user-event';
import { describe, expect, it, vi } from "vitest";
import SearchBook from "./Search";
import { appStoreModel } from "../../store";
import { createStore } from "easy-peasy";
import { customRender as render } from '../../utils/test-helper';

const mock = vi.fn();
const store = createStore(appStoreModel, {
    injections: {
        httpService : {
            get: mock
        } 
    },
    initialState: {
        books: {

        }
    }
});

describe('Search Component', () => {
    it('Search Component should load properly - snapshot', async () => {
        const {container}  = render(<SearchBook />, store);
        expect(container).toMatchSnapshot();
    });

    it('Search Component should load properly', async () => {
        const {getByPlaceholderText}  = render(<SearchBook/>, store);
        const input = getByPlaceholderText('Search by Book Name');
        await userEvent.type(input, 'book');
        expect(mock).toBeCalledTimes(1);
    });
})