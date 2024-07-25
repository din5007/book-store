import { createStore } from "easy-peasy"
import { describe, expect, it, vi } from "vitest";
import { appStoreModel, AppStoreModel } from ".."

describe('Test Order model', () => {
    it('Signup scenario ', async () => {
        const mock = {
            httpService: {
                post: vi.fn()
            }
        }
        const store = createStore<AppStoreModel, any>(appStoreModel, {
            injections: mock,
        });

        await store.getActions().user.signUp({ email: 'dine@gmail.com', name: 'dine', password: 'password' });
        expect(mock.httpService.post).toBeCalledWith("/api/users/signup", {
            userName: 'dine',
            password: 'password',
            email: 'dine@gmail.com'
        }, {});
    });

    it('Login scenario ', async () => {
        const mock = {
            httpService: {
                post: vi.fn(() => {
                    token: 'sdfsfsdfsfsfsdf'
                })
            }
        }
        const store = createStore<AppStoreModel, any>(appStoreModel, {
            injections: mock,
        });

        await store.getActions().user.logIn({ email: 'dine@gmail.com', password: 'password' });
        expect(mock.httpService.post).toBeCalledWith("/api/users/login", {
            password: 'password',
            email: 'dine@gmail.com'
        }, {});
    });
});
