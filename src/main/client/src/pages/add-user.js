import {Col, Form, Button, Container, Row} from 'react-bootstrap';

const AddUser = () => {
    return (
    <Container>
        <Row className="justify-content-md-center mt-5">
            <Col md='6' className="align-self-center text-center">
                <h2>Add a new user</h2>
                <Form>
                    <Form.Group className="mb-3">
                        <Form.Label>Workspace ID</Form.Label>
                        <Form.Control placeholder="Workspace ID" disabled />
                    </Form.Group>
                    <Form.Group className="mb-3" controlId="formBoardName">
                        <Form.Label>User's email address</Form.Label>
                        <Form.Control placeholder="User's email address"/>
                    </Form.Group>
                    <Button variant="warning" type="submit">
                        Add
                    </Button>
                </Form>
            </Col>
        </Row>
    </Container>
    );
}
export default AddUser;