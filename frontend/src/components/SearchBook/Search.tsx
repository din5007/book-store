import { EventHandler, FC, KeyboardEventHandler, SyntheticEvent } from "react";
import { Form } from "react-bootstrap";

const SearchBook: FC<{ onChange: any }> = ({ onChange }) => {

  const onChangeHandler = (e: any) => {
    e.preventDefault();
    if(e?.target?.value > 3) {
        onChange(e.target.value);
    }
  }

  return (
    <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
      <Form.Control type="search" placeholder="Search by Book Name" onChange={onChangeHandler}/>
    </Form.Group>
  );
};

export default SearchBook;
