import {Form, Button, Container, Row, Col, InputGroup} from 'react-bootstrap';

const CreateBoard = () => {
    return (
        // Create board for workspace id = 1. 
        <Container>
            <Row className="justify-content-md-center mt-5">
                <Col md='6' className="align-self-center text-center">
                    <h2 className>Create a new board</h2>
                    <Form>
                        <Form.Group className="mb-3">
                            <Form.Label>Workspace Name</Form.Label>
                            <Form.Control placeholder="Fixed workspace name" disabled />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBoardName">
                            <Form.Label>Board name</Form.Label>
                            <Form.Control placeholder="Board name" />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBoardDescription">
                            <InputGroup>
                                <InputGroup.Text>Description</InputGroup.Text>
                                <Form.Control as="textarea" aria-label="Description" />
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