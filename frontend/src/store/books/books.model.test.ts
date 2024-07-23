import { createStore } from "easy-peasy"
import { appStoreModel, AppStoreModel } from ".."

jest.mock('axios');

describe('Test book model', () => {
    it('find all books ', async () => {
        const mock = {
            httpService: {
                get: () => jest.fn(() => Promise.resolve({}))
            }
        }
        const store = createStore<AppStoreModel, any>(appStoreModel, {
            injections: mock,
            initialState: {}
        });

        await store.getActions().books.fetchAllBooks({});
        expect(mock.httpService.get).toHaveBeenCalledWith("api/books");
    })
})