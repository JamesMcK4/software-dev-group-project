import {Form, Button, Container, Row, Col, InputGroup} from 'react-bootstrap';
import { useRef } from 'react';
import { useParams } from 'react-router-dom';

const CreateBoard = () => {
    const nameRef=useRef();
    const descriptionRef=useRef();
    const workspaceId = useParams().workspaceId;
    
    function createBoard(board) {
        fetch("http://localhost:9001/workspace/add_board/" + workspaceId, {
                method: 'POST',
                mode: 'cors',
                body: JSON.stringify(board),
                headers: {'Content-Type': 'application/json'}
            }).then((response) => response.json()).then((data) => console.log(data)) ;
        }
    function createHandler(event){
        event.preventDefault();
        const name=nameRef.current.value;
        const description=descriptionRef.current.value;
        const board={name,description};
        console.log(board);
        createBoard(board);
    }
    return (
        // Create board for workspace id = 1. 
        <Container>
            <Row className="justify-content-md-center mt-5">
                <Col md='6' className="align-self-center text-center">
                    <h2 className>Create a new board</h2>
                    <Form onSubmit={createHandler}>
                        <Form.Group className="mb-3">
                            <Form.Label>Workspace ID</Form.Label>
                            <Form.Control placeholder= {workspaceId} disabled />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBoardName">
                            <Form.Label>Board name</Form.Label>
                            <Form.Control placeholder="Board name" ref={nameRef} />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBoardDescription">
                            <InputGroup>
                                <InputGroup.Text>Description</InputGroup.Text>
                                <Form.Control as="textarea" aria-label="Description" ref={descriptionRef} />
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
export default CreateBoard;