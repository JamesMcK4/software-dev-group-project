import {ListGroupItem, ListGroup} from 'react-bootstrap';
import {useState, useEffect} from 'react';

const BoardListHome = ({workspaceBoards}) => {

    var [boards, setBoards] = useState([]);

    useEffect(() => {
        if (workspaceBoards !== undefined){
            setBoards(boards);
        }
    }, []);

    return (
    <ListGroup className="list-group-flush mt-3">
        {workspaceBoards.map((board, key) => (
            <ListGroupItem key = {key} action href= {"/board/" + board.id} className="link-success">{board.name}</ListGroupItem>
        ))}
    </ListGroup>
    )
}
export default BoardListHome;