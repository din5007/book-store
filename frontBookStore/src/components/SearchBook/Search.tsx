import { FC } from "react";
import { Form } from "react-bootstrap";
import { useStoreActions } from "../../store/hooks";

const SearchBook: FC<{}> = () => {
  const { fetchAllBooks } = useStoreActions(actions => actions.books);

  const onChangeHandler = (e: any) => {
    e.preventDefault();
    if(e?.target?.value?.length > 3) {
        fetchAllBooks({ title : e.target.value});
    }
    if(e?.target?.value.length === 0) {
      fetchAllBooks({ title : ''});
    }
  }

  return (
    <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
      <Form.Control type="search" placeholder="Search by Book Name" onChange={onChangeHandler}/>
    </Form.Group>
  );
};

export default SearchBook;
