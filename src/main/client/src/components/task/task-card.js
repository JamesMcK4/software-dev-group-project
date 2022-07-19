import { useEffect, useState } from 'react';
import {Card, Button, Row, Col} from 'react-bootstrap';
import Moment from 'moment';

const TaskCards = ({tasks}) => {

    return (
        <Row xs={1} md={2} lg={3} className="g-4 mt-5">
            {tasks.map((task, key) => (
                <Col key={key}>
                    <Card bg="dark" text="light">
                        <Card.Header as="h4" className="text-capitalize bg-success">{task.name}</Card.Header>
                        <Card.Body>
                            <Card.Title>
                                Description
                            </Card.Title>
                            <Card.Text>
                                {task.description}
                            </Card.Text>
                            <Card.Title>
                                Status
                            </Card.Title>
                            <Card.Text>
                                {task.status}
                            </Card.Text>
                            <Card.Text>
                                <Button variant="warning" href={"/change-task-status/" + task.id}>Change task status</Button>
                            </Card.Text>
                            <Card.Title>
                                Assignee
                            </Card.Title>
                            <Card.Text>
                                {task.assignee === null? 
                                    task.assignee
                                : 
                                <Button variant="warning" href={"/assign-user/" + task.id}>
                                    Assign a user
                                </Button>}
                            </Card.Text>
                        </Card.Body>
                        <Card.Footer>
                            Due: {Moment(task.dueOn).format('DD-MM-YYYY')}
                        </Card.Footer>
                    </Card>
                </Col>))}
        </Row>
    );
}
export default TaskCards;