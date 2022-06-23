import {ListGroupItem, ListGroup} from 'react-bootstrap';
import {useState, useEffect} from 'react';

const BoardList = ({boardIDs}) => {

    var [boards, setBoards] = useState([]);

    useEffect(() => {
        if (boardIDs !== undefined){
            getBoardsByID();
        }
        else{
            getAllBoards();
        }
    }, []);

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
            setBoards(Boards => value);
        });
    }

    async function getAllBoards() {
        // You can await here
        const response = await fetch("http://localhost:9001/board/get_all_boards/", {
            method: 'GET'
        }, {mode: 'cors'});
        response.json().then((value) => {
            console.log(value);
            setBoards(Boards => value);
        });
    }

    return (
    <ListGroup className="list-group-flush">
        {boards.map((data, key) => (
        <ListGroupItem key={key}><a href= {"/board/" + data.id} className="link-success">{data.name}</a></ListGroupItem>))}
    </ListGroup>
    )
}
export default BoardList;