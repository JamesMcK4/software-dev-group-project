import {Form, Button, Container, Row, Col, InputGroup} from 'react-bootstrap';

const CreateWorkspace = () => {
    return (
        <Container>
            <Row className="justify-content-md-center mt-5">
                <Col md='6' className="align-self-center text-center">
                    <h2>Create a new workspace</h2>
                    <Form>
                        <Form.Group className="mb-3" controlId="formBoardName">
                            <Form.Label>Workspace name</Form.Label>
                            <Form.Control placeholder="Workspace name" />
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
export default CreateWorkspace ;