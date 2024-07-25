import { Pagination } from "react-bootstrap"
import { useStoreActions } from "../../store/hooks";


const CustomPagination = () => {
    const { fetchAllBooks, setCurrentPage } = useStoreActions(actions => actions.books);

    return (<Pagination>
        {Array(5)
          .fill(1)
          .map((_, i) => (
            <Pagination.Item key={i} onClick={() => {
                setCurrentPage(i);
                fetchAllBooks({});
            }}>{i + 1}</Pagination.Item>
          ))}
      </Pagination>)
}

export default CustomPagination;