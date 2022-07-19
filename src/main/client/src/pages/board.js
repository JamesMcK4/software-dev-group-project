import {Button, Col, Container, Row} from "react-bootstrap";
import TaskCards from "../components/task/task-card";
import {useState, useEffect} from 'react';
import {useParams, useNavigate} from 'react-router-dom';
import {BoardInfo, SearchBar, FilterTask} from "../index.js";

const Board = () => {

    const navigate = useNavigate();

    var [board, setBoard] = useState({});

    const boardId = useParams().boardId;

    var [allTasks, setAllTasks] = useState([]);
    var [displayedTasks, setDisplayedTasks] = useState([]);

    useEffect(() => {
        getAllTasks();
    }, []);

    useEffect(() => {
        getBoard(boardId);
    }, [boardId]);

    useEffect(() => {
        console.log(board);
    }, [board]);

    async function getBoard(boardId) {
        // You can await here
        const response = await fetch("http://localhost:9001/board/get_board/" + boardId, {
        method: 'GET',
        }, {mode: 'cors'});
        response.json().then((value) => {
            console.log(value);
            setBoard(value);
        }).catch((e) => {
            alert("Fail to fetch the board. It might not exist.");
            navigate("/");
        });
    }

    /*
        Not get all the tasks, but only the ones belong to a board. 
        We can use this to test search and filter while we wait for Haoming to finish adding tasks to board.
    */
    async function getAllTasks() {
        // You can await here
        const response = await fetch("http://localhost:9001/task/get_all_tasks", {
            method: 'GET',
        }, {mode: 'cors'});
        response.json().then((value) => {
            console.log(value);
            setAllTasks(value);
            setDisplayedTasks(value);
        });
    }

    return(
        <Container style={{width: "90%"}}>
            <BoardInfo board={board}></BoardInfo>
            <Row className="mt-5 justify-content-md-center">
                <Col md="auto">
                    <h2>
                        Tasks
                    </h2>
                </Col>
            </Row>
            <Row className="justify-content-md-center">
                <Col md="auto">
                    <Button variant="warning" href={"/create-task/" + board.id}>
                        Create a new task
                    </Button>
                </Col>
            </Row>
            <Row className="mt-5">
                <SearchBar setTasks={setDisplayedTasks} tasks={allTasks} ></SearchBar>
            </Row>
            <FilterTask setTasks={setDisplayedTasks} tasks={allTasks}></FilterTask>
            <TaskCards tasks={displayedTasks}></TaskCards>
        </Container>
    )
}
export default Board ;