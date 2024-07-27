import { action, Action, thunk, Thunk } from "easy-peasy";
import { BookDto } from "../../dto/dtos";
import { AppStoreModel } from "..";
import { toast } from "react-toastify";

export interface BookModel {
    books: BookDto[];
    currentPage: number;
    searchKey : string;
    setBooks: Action<BookModel, any>;
    setSearchKey: Action<BookModel, any>;
    setCurrentPage: Action<BookModel, any>;
    fetchAllBooks: Thunk<BookModel, any, any, AppStoreModel>;
}

export const booksModel : BookModel = {
    books: [],
    currentPage: 0,
    searchKey: '',
    setSearchKey: action((state, key) => {
        state.searchKey = key;
    }),
    setCurrentPage: action((state, page) => {
        state.currentPage = page;
    }),
    setBooks: action((state, books) => {
        state.books = books;
    }),
    fetchAllBooks: thunk(async (actions, { title = '', page = 0 }, { injections, getState, getStoreActions }) => {
        const { httpService } = injections;
        if(!title) title = getState().searchKey;
        if(!page) page = getState().currentPage;
        try {
            const rsponse = await httpService.get(`/api/books?page=${page}&&title=${title} `, { } , { headers: {
                'Authorization' : localStorage.getItem('jwt')
            }});
            actions.setBooks(rsponse);
            getStoreActions().cart.countUserCart({});
        } catch (error) {
            toast.error('Error Occured. Please reach out to support');
            actions.setBooks([]);
        }
    }),
};