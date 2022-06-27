import {Form, Container, Row, Col, Button} from 'react-bootstrap';
const ForgotPass = () => {
    return (
        <Container>
        <Row className="justify-content-md-center mt-5">
            <Col md='6' className="align-self-center">
                <h3>Reset your password</h3>
                <Form>
                <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
                    <Form.Label>Security Question Sample: What is your date of birth?</Form.Label>
                    <Form.Control/>
                </Form.Group>
                <Button variant="warning" type="submit">
                    Submit
                </Button>
                </Form>
            </Col>
        </Row>
    </Container>
      );
}
export default ForgotPass ;