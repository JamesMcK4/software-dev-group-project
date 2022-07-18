import {Form, Button} from 'react-bootstrap';

const SearchBar = ({tasks, setTasks}) => {

    return (
    <Form className="d-flex">
        <Form.Control
        type="search"
        placeholder="Search for a task using full task name"
        className="me-2"
        aria-label="Search"
        />
    <Button variant="outline-success">Search</Button>
    </Form>
    );
}
export default SearchBar;