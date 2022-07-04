import {ListGroupItem, ListGroup, Container, Button} from 'react-bootstrap';

const UserList = ({workspaceUsers, handleDelete}) => {

    return (
        <ListGroup className="list-group-flush mt-3">
        {workspaceUsers.map((user, key) => (
            <Container key={key} className="d-flex flex-row">
                <ListGroupItem action>{user.emailId}</ListGroupItem>
                <Button id={user.id} variant="danger" onClick={handleDelete}>
                Delete
                </Button>
            </Container>
        ))}
        </ListGroup>
    )
}
export default UserList;