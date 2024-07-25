import { Suspense } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import Navigation from "./components/Navbar/Navbar";
import { Route, Routes } from "react-router";
import GlobalStoreProvider from "./providers/GlobalStoreProvider";
import LoginPage from "./pages/LoginPage";
import SignUpPage from "./pages/SignUpPage";
import HomePage from "./pages/HomePage";
import Cart from "./pages/CartPage/Cart";
import BookPage from "./pages/BookPage/BookPage";
import OrderSummary from "./pages/OrderPage";
import Loading from "./pages/CommonPages/LoadingPage";
import { BrowserRouter } from "react-router-dom";
import 'react-toastify/dist/ReactToastify.css';
import { ToastContainer } from "react-toastify";

const App = () => {
    return (
      <BrowserRouter>
      <ToastContainer position="top-right" autoClose={5000} hideProgressBar={false} newestOnTop={false} closeOnClick theme="colored"/>
      <GlobalStoreProvider>
        <Navigation >
            <Suspense fallback={<Loading />}>
              <Routes>
                  <Route path="/home" element={<HomePage />}/>
                  <Route path="/login" element={<LoginPage/> } />
                  <Route path="/register" element={<SignUpPage/> } />
                  
                  <Route path="/books" element={<BookPage />} />
                  <Route path="/cart" element={<Cart />} />
                  <Route path="/order-summary" element={<OrderSummary />} />
              </Routes>
            </Suspense>
        </Navigation>
      </GlobalStoreProvider>
          </BrowserRouter>
        
      );

};

export default App;
