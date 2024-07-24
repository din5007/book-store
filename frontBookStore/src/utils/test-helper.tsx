import { StoreProvider } from "easy-peasy";
import { render } from '@testing-library/react';
import { BrowserRouter } from "react-router-dom";


function customRender(component : any , store?: any) {

    return render(<StoreProvider store={store}>
        <BrowserRouter>
            {component}
        </BrowserRouter>
    </StoreProvider>);
}

export * from '@testing-library/react';
export { customRender } ;