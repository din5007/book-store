import { action, Action, thunk, Thunk } from "easy-peasy";
import { BookDto } from "../../dto/dtos";
import { AppStoreModel } from "..";

export interface BookModel {
    books: BookDto[];
    setBooks: Action<BookModel, any>;
    fetchAllBooks: Thunk<BookModel, any, any, AppStoreModel>;
}

export const booksModel : BookModel = {
    books: [],
    setBooks: action((state, books) => {
        state.books = books;
    }),
    fetchAllBooks: thunk(async (actions, _, { injections }) => {
        const { httpService } = injections;
        try {
            const rsponse = await httpService.get('/api/books', { headers: {
                'Authorization' : localStorage.getItem('jwt')
            }});
            actions.setBooks(rsponse);
        } catch (error) {
            console.info('error occured');
            actions.setBooks([]);
        }
    }),
};