import {ListGroupItem, ListGroup, Button, Container} from 'react-bootstrap';

const BoardList = ({workspaceBoards, handleDelete}) => {

    return (
    <ListGroup className="list-group-flush mt-3">
        {workspaceBoards.map((board, key) => (
            <Container key={key} className="d-flex flex-row">
                <ListGroupItem action href= {"/board/" + board.id} className="link-success">{board.name}</ListGroupItem>
                <Button id={board.id} variant="danger" onClick={handleDelete}>
                Delete
                </Button>
            </Container>
        ))}
    </ListGroup>
    )
}
export default BoardList;