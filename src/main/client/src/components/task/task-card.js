import { useEffect, useState } from 'react';
import {Card, Button, Row, Col} from 'react-bootstrap';


const TaskCards = () => {

    var [task, setTask] = useState([]);

    useEffect(() => {
        getAllTasks();
    }, []);

    async function getAllTasks() {
        // You can await here
        const response = await fetch("http://localhost:9001/task/get_all_tasks", {
            method: 'GET',
        }, {mode: 'cors'});
        response.json().then((value) => {
            console.log(value);
            setTask(task => value);
        });
    }

    return (
        <Row xs={1} md={2} className="g-4">
            {task.map((task, key) => (
                <Col key={key}>
                    <Card bg="dark" text="light">
                        <Card.Header as="h3" className="text-capitalize">{task.name}</Card.Header>
                        <Card.Body>
                            <Card.Text>
                                {task.description}
                            </Card.Text>
                            <Card.Text>
                                <Button variant="warning" href="/Status">Status</Button>
                            </Card.Text>
                        </Card.Body>
                    </Card>
                </Col>))}
        </Row>
    );
}
export default TaskCards;