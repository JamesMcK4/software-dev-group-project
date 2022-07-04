import {Form, Button, Container, Row, Col, InputGroup} from 'react-bootstrap';
import { useParams, useNavigate } from 'react-router-dom';

const CreateBoard = () => {

    const navigate = useNavigate();

    const workspaceId = useParams().workspaceId;

    async function handleInput(e) {
        e.preventDefault();
        var name = e.target.name.value;
        var description = e.target.description.value;
        console.log(name);
        console.log(description);
        if (workspaceId !== undefined){
            if (name !== "" && description !== ""){
                const board = {name, description};
                var data = await createBoard(workspaceId, board);
                alert("Board created sucessfully");
                navigate(/workspace/ + workspaceId);
            }
        }
    }

    async function createBoard(workspaceId, board) {
        // You can await here
        const response = await fetch("http://localhost:9001/workspace/add_board/" + workspaceId, {
        method: 'POST',
        mode: 'cors',
        body: JSON.stringify(board),
        headers: {'Content-Type': 'application/json'}
        });
        response.json().then((value) => {
            console.log(value);
        }).catch((e) => {
            alert("Fail to create a board for the workspace.");
        });
    }

    return (
        <Container>
            <Row className="justify-content-md-center mt-5">
                <Col md='6' className="align-self-center text-center">
                    <h2>Create a new board</h2>
                    <Form onSubmit={handleInput}>
                        <Form.Group className="mb-3">
                            <Form.Label>Workspace ID</Form.Label>
                            <Form.Control placeholder={workspaceId} disabled />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBoardName">
                            <Form.Label>Board name</Form.Label>
                            <Form.Control placeholder="Board name" name="name" required/>
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBoardDescription">
                            <InputGroup>
                                <InputGroup.Text>Description</InputGroup.Text>
                                <Form.Control as="textarea" aria-label="Description" name="description" required/>
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
export default CreateBoard ;