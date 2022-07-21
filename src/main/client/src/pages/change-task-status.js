import {Form, Button, Container, Row, Col, InputGroup} from 'react-bootstrap';
import { useParams, useNavigate } from 'react-router-dom';

const ChangeTaskStatus = () => {
  const navigate = useNavigate();
    const taskId = useParams().taskId;

    async function handleInput(e) {
      e.preventDefault();
      const status = e.target.status.value;
      console.log(status);
      ChangeTaskStatus(status);


  }

  async function ChangeTaskStatus(status) {
    // You can await here
    const response = await fetch("http://localhost:9001/task/status/" + taskId + "?status=" + status, {
        method: 'PUT',
    }, {mode: 'cors'});
    response.json().then((value) => {
        console.log(value);
    });
}



    return(
    <Container>
            <Row className="justify-content-md-center mt-5">
                <Col md='6' className="align-self-center text-center">
                    <h2>Changing tasks status</h2>
                    <Form onSubmit={handleInput}>
                        <Form.Group className="mb-3">
                            <Form.Label>Task ID</Form.Label>
                            <Form.Control placeholder={taskId} disabled/>
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formTaskStatus">
                            <Form.Label>Status</Form.Label>
                            <Form.Select name="status">
                                <option value="TO_DO">TO_DO</option>
                                <option value="DOING">DOING</option>
                                <option value="DONE">DONE</option>
                            </Form.Select>
                        </Form.Group>
                        <Button variant="warning" type="submit">
                            Change Status
                        </Button>
                    </Form>
                </Col>
            </Row>
        </Container>
    )
}
export default ChangeTaskStatus;
