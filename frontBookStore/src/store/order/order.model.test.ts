import { createStore } from "easy-peasy"
import { describe, expect, it, vi, vitest } from "vitest"
import { appStoreModel, AppStoreModel } from ".."

describe('Test Order model', () => {
    it('Order creation scenario ', async () => {
        const mock = {
            httpService: {
                post: vi.fn()
            }
        }
        const store = createStore<AppStoreModel, any>(appStoreModel, {
            injections: mock,
        });

        await store.getActions().order.createOrder({});
        expect(mock.httpService.post).toBeCalledWith("/api/order/create", {}, {
            "headers": {
                "Authorization" : null
            }
        });
    });
});
