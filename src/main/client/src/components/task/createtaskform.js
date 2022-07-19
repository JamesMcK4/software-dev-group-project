import {Form, Button, Container, Row, Col, InputGroup} from 'react-bootstrap';
import React, {useRef} from "react";
import { useNavigate, useParams } from 'react-router-dom';

const CreateTaskForm = ({createTask}) => {

    const navigate = useNavigate();

    const boardId = useParams().boardId;

    const taskNameRef=useRef();
    const descriptionRef=useRef();
    const deadlineRef=useRef();
    const statusRef=useRef();
    function createHandler(event){
        event.preventDefault();
        const name = taskNameRef.current.value;
        const description = descriptionRef.current.value;
        const dueOn = deadlineRef.current.value;
        const status = statusRef.current.value;
        const task = {name,description,status,dueOn};
        console.log(task);
        //createTask(task);
    }

    return (
        <Container>
            <Row className="justify-content-md-center mt-5">
                <Col md='6' className="align-self-center text-center">
                    <h2>Create a new Task</h2>
                    <Form onSubmit={createHandler}>
                        <Form.Group className="mb-3">
                            <Form.Label>Board ID</Form.Label>
                            <Form.Control placeholder={boardId} disabled />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formTaskName">
                            <Form.Label>Task name</Form.Label>
                            <Form.Control placeholder="Task name" ref={taskNameRef}/>
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formTaskName">
                            <Form.Label>Deadline</Form.Label>
                            <Form.Control type="date" placeholder="Due Day" ref={deadlineRef}/>
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formTaskDescription">
                            <InputGroup>
                                <InputGroup.Text>Description</InputGroup.Text>
                                <Form.Control as="textarea" aria-label="Description" ref={descriptionRef}/>
                            </InputGroup>
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formTaskStatus">
                            <Form.Label>Status</Form.Label>
                            <Form.Select ref={statusRef}>
                                <option>TO_DO</option>
                                <option>DOING</option>
                                <option>DONE</option>
                            </Form.Select>
                        </Form.Group>
                        <Button variant="warning" type="submit">
                            Create
                        </Button>
                    </Form>
                </Col>
            </Row>
        </Container>
    );
}
export default CreateTaskForm ;