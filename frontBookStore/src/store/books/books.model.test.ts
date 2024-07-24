import { createStore } from "easy-peasy"
import { describe, expect, it, vi } from "vitest";
import { appStoreModel, AppStoreModel } from ".."

describe('Test book model', () => {
    it('find all books ', async () => {
        const mock = {
            httpService: {
                get: vi.fn()
            }
        }
        const store = createStore<AppStoreModel, any>(appStoreModel, {
            injections: mock,
            initialState: {}
        });

        await store.getActions().books.fetchAllBooks({});
        expect(mock.httpService.get).toBeCalledWith("/api/books", { title : ''}, {
            "headers": {
                "Authorization" : null
            }
        });
    });
});
