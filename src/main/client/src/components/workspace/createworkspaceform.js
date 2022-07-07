import {Form, Button, Container, Row, Col, InputGroup} from 'react-bootstrap';
import React, {useRef} from "react";

const CreateWorkspaceForm = ({createWorkspace}) => {
    const workspaceNameRef=useRef();
    const descriptionRef=useRef();

    function createHandler(event){
        event.preventDefault();
        const name = workspaceNameRef.current.value;
        const description = descriptionRef.current.value;
        const workspace = {name,description};
        console.log(workspace);
        createWorkspace(workspace);
    }

    return (
        <Container>
            <Row className="justify-content-md-center mt-5">
                <Col md='6' className="align-self-center text-center">
                    <h2>Create a new workspace</h2>
                    <Form onSubmit={createHandler}>
                        <Form.Group className="mb-3" controlId="formBoardName">
                            <Form.Label>Workspace name</Form.Label>
                            <Form.Control placeholder="Workspace name" ref={workspaceNameRef}/>
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBoardDescription">
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
export default CreateWorkspaceForm ;