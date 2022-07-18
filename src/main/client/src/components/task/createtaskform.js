import {Form, Button, Container, Row, Col, InputGroup} from 'react-bootstrap';
import React, {useRef} from "react";

const CreateTaskForm = ({createTask}) => {
    const taskNameRef=useRef();
    const descriptionRef=useRef();
    const deadlineRef=useRef();
    const assigneeRef=useRef();
    function createHandler(event){
        event.preventDefault();
        const name = taskNameRef.current.value;
        const description = descriptionRef.current.value;
        const deadline=deadlineRef.current.value;
        const assignee = assigneeRef.current.value;


        const task = {name,description,assignee,deadline};
        console.log(task);
        createTask(task);
    }

    return (
        <Container>
            <Row className="justify-content-md-center mt-5">
                <Col md='6' className="align-self-center text-center">
                    <h2>Create a new Task</h2>
                    <Form onSubmit={createHandler}>
                        <Form.Group className="mb-3" controlId="formTaskName">
                            <Form.Label>Task name</Form.Label>
                            <Form.Control placeholder="Task name" ref={taskNameRef}/>
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formTaskName">
                            <Form.Label>Assignee</Form.Label>
                            <Form.Control placeholder="User Name" ref={assigneeRef}/>
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formTaskName">
                            <Form.Label>Deadline</Form.Label>
                            <Form.Control placeholder="Due Day" ref={deadlineRef}/>
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formTaskDescription">
                            <InputGroup>
                                <InputGroup.Text>Description</InputGroup.Text>
                                <Form.Control as="textarea" aria-label="Description" ref={descriptionRef}/>
                            </InputGroup>
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