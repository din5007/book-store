import BookCard from "../../components/Card/Card";
import { FC } from "react";
import SearchBook from "../../components/SearchBook/Search";

const BookPage : FC<{}> = ()=> {   
    
    return (
        <div className="d-flex align-items-center flex-column" style={{ margin : "5%"}}>
            <SearchBook/>
            <BookCard />
        </div>
    )
}
export default BookPage;