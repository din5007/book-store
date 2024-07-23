import { PropsWithChildren } from "react";
import { StoreProvider } from "easy-peasy";
import { store } from '../store';

export default function GlobalStoreProvider({ children } : PropsWithChildren<{}>) {
    return <StoreProvider store={store}>{children}</StoreProvider>
} 