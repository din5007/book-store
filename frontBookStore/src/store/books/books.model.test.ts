import { createStore } from "easy-peasy"
import { describe, expect, it, vi } from "vitest";
import { appStoreModel, AppStoreModel } from ".."

describe('Test book model', () => {
    it('find all books ', async () => {
        const mock = {
            httpService: {
                get: vi.fn(() => [{
                    id: 1,
                    title: 'harry',
                    author: 'rowling',
                    price: 500,
                    quantity: 400
                }])
            }
        }
        localStorage.setItem('jwt', 'randomkey');
        const store = createStore<AppStoreModel, any>(appStoreModel, {
            injections: mock,
            initialState: {}
        });

        await store.getActions().books.fetchAllBooks({});
        expect(mock.httpService.get).toBeCalledWith("/api/books?page=0&&title= ",{}, {
            "headers": {
                "Authorization" : "randomkey"
            }
        });
        expect(store.getState().books.books.length).toEqual(1)
    });
});
