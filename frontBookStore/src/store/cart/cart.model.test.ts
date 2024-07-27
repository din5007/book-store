import { createStore } from "easy-peasy"
import { describe, expect, it, vi } from "vitest"
import { appStoreModel, AppStoreModel } from ".."

describe('Test cart model', () => {
    it('fetch user cart service ', async () => {
        const mock = {
            httpService: {
                get: vi.fn()
            }
        }
        localStorage.setItem('jwt', 'randomkey');
        const store = createStore<AppStoreModel, any>(appStoreModel, {
            injections: mock,
            initialState: {}
        });

        await store.getActions().cart.fetchUserCart({});
        expect(mock.httpService.get).toBeCalledWith("/api/cart", {},  {
            "headers": {
                "Authorization" : "randomkey"
            }
        });
    });

    it('add to user cart service ', async () => {
        const mock = {
            httpService: {
                put: vi.fn()
            }
        }
        localStorage.setItem('jwt', 'randomkey');
        const store = createStore<AppStoreModel, any>(appStoreModel, {
            injections: mock,
            initialState: {}
        });

        await store.getActions().cart.addToCart({ id : 1});
        expect(mock.httpService.put).toBeCalledWith("/api/cart/1/add", null, {
            "headers": {
                "Authorization" : "randomkey"
            }
        });
    });

    it('decrement the add quantity from user cart service ', async () => {
        const mock = {
            httpService: {
                put: vi.fn()
            }
        }
        localStorage.setItem('jwt', 'randomkey');
        const store = createStore<AppStoreModel, any>(appStoreModel, {
            injections: mock,
            initialState: {}
        });

        await store.getActions().cart.decrementQuantity({ id : 1});
        expect(mock.httpService.put).toBeCalledWith("/api/cart/1/decrement", null, {
            "headers": {
                "Authorization" : "randomkey"
            }
        });
    });

    it('remove the book from user cart service ', async () => {
        const mock = {
            httpService: {
                delete: vi.fn()
            }
        }
        localStorage.setItem('jwt', 'randomkey');
        const store = createStore<AppStoreModel, any>(appStoreModel, {
            injections: mock,
            initialState: {}
        });

        await store.getActions().cart.removeFromCart({ id : 1});
        expect(mock.httpService.delete).toBeCalledWith("/api/cart/1/remove",  {
            "headers": {
                "Authorization" : "randomkey"
            }
        });
    });

    it('count the user cart service ', async () => {
        const mock = {
            httpService: {
                get: vi.fn(() => 2)
            }
        }
        localStorage.setItem('jwt', 'randomkey');
        const store = createStore<AppStoreModel, any>(appStoreModel, {
            injections: mock,
            initialState: {}
        });

        await store.getActions().cart.countUserCart({});
        expect(mock.httpService.get).toBeCalledWith("/api/cart/count", {},  {
            "headers": {
                "Authorization" : "randomkey"
            }
        });
        expect(store.getState().cart.cartCount).toEqual(2);
    });
});
