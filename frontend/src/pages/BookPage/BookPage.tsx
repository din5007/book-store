import { Card } from "react-bootstrap";
import BookCard from "../../components/Card/Card";
import { FC, useState } from "react";
import SearchBook from "../../components/SearchBook/Search";

const BookPage : FC<{}> = ()=> {
    const [ searchText , setSearchText ] = useState('');

    return (
        <div className="d-flex align-items-center flex-column" style={{ margin : "5%"}}>
            <SearchBook onChange={(e : any) => setSearchText(e?.target?.value)}/>
            <BookCard />
        </div>
    )
}
export default BookPage;