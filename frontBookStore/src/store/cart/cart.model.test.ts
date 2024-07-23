import { createStore } from "easy-peasy"
import { describe, expect, it, vi, vitest } from "vitest"
import { appStoreModel, AppStoreModel } from ".."

describe('Test cart model', () => {
    it('fetch user cart service ', async () => {
        const mock = {
            httpService: {
                get: vi.fn()
            }
        }
        const store = createStore<AppStoreModel, any>(appStoreModel, {
            injections: mock,
            initialState: {}
        });

        await store.getActions().cart.fetchUserCart({});
        expect(mock.httpService.get).toBeCalledWith("/api/cart", {
            "headers": {
                "Authorization" : null
            }
        });
    });

    it('add to user cart service ', async () => {
        const mock = {
            httpService: {
                put: vi.fn()
            }
        }
        const store = createStore<AppStoreModel, any>(appStoreModel, {
            injections: mock,
            initialState: {}
        });

        await store.getActions().cart.addToCart({ id : 1});
        expect(mock.httpService.put).toBeCalledWith("/api/cart/1/add", null, {
            "headers": {
                "Authorization" : null
            }
        });
    });

    it('remove/decrement the add quantity from user cart service ', async () => {
        const mock = {
            httpService: {
                put: vi.fn()
            }
        }
        const store = createStore<AppStoreModel, any>(appStoreModel, {
            injections: mock,
            initialState: {}
        });

        await store.getActions().cart.decrementQuantity({ id : 1});
        expect(mock.httpService.put).toBeCalledWith("/api/cart/1/decrement", null, {
            "headers": {
                "Authorization" : null
            }
        });
    });
});
