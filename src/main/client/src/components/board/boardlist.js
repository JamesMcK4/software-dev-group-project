import {ListGroupItem, ListGroup, Button, Container} from 'react-bootstrap';
import {useState, useEffect} from 'react';

const BoardList = ({workspaceBoards}) => {

    var [boards, setBoards] = useState([]);

    useEffect(() => {
        if (workspaceBoards !== undefined){
            setBoards(boards);
        }
    }, []);

    const handleDelete = (e) => {
        console.log(e.target.id);
    }

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


    /*
    async function getBoardsByID() {
        // You can await here
        console.log(boardIDs);
        const response = await fetch("http://localhost:9001/board/get_boards_by_ids?" + new URLSearchParams({
            ids : boardIDs
        }), {
            method: 'GET'
        }, {mode: 'cors'});
        response.json().then((value) => {
            console.log(value);
            setBoards(value);
        });
    }

    async function getAllBoards() {
        // You can await here
        const response = await fetch("http://localhost:9001/board/get_all_boards/", {
            method: 'GET'
        }, {mode: 'cors'});
        response.json().then((value) => {
            console.log(value);
            setBoards(value);
        });
    }
    */