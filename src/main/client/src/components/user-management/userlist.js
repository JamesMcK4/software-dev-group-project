import {ListGroupItem, ListGroup} from 'react-bootstrap';
import {useState, useEffect} from 'react';

const UserList = ({workspaceUsers}) => {

    var [users, setUsers] = useState([]);

    useEffect(() => {
        if (workspaceUsers !== undefined){
            setUsers(workspaceUsers);
        }
    }, []);

    return (
    <ListGroup className="list-group-flush">
        {workspaceUsers.map((user, key) => (
        <ListGroupItem key={key}>
            {user.emailId}
        </ListGroupItem>))}
    </ListGroup>
    )
}
export default UserList;