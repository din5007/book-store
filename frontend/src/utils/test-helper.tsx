import { StoreProvider } from "easy-peasy";
import { render } from '@testing-library/react';
import { AppStoreModel, store } from "../store";
import { Router } from 'react-router-dom';
import { ReactNode } from "react";



// const provider : React.FC<{children : ReactNode, store: any}> = ({ children, store }) => {
//     return (
        
//     )
// }

function customRender(component : any , store: any) {

    return render(<StoreProvider store={store}>
        {component}
    </StoreProvider>);
}

export * from '@testing-library/react';
export { customRender } ;