import {Form, Button, Container, Row, Col, InputGroup} from 'react-bootstrap';
import { useParams, useNavigate } from 'react-router-dom';

const ChangeTaskStatus = () => {

    const navigate = useNavigate();

    const taskId = useParams().taskId;

    const boardId = useParams().boardId;

    async function handleInput(e) {
        e.preventDefault();
        console.log(e.target.status.value);
        const status = e.target.status.value;
        if (taskId !== undefined){
            const data = await ChangeTaskStatus(taskId, status);
            if (data.status !== undefined && data.status == true){
                alert("Task status updated sucessfully!");
                navigate("/board/" + boardId);
            }
        }
    }

    async function ChangeTaskStatus(taskId, status) {
        // You can await here
        const response = await fetch("http://localhost:9001/task/status/" + taskId + "?status=" + status, {
            method: 'PUT',
            mode: 'cors',
        });
        const data = await response.json();
        console.log(data);
        return data;
    }

    return(
        <Container>
            <Row className="justify-content-md-center mt-5">
                <Col md='6' className="align-self-center text-center">
                    <h2>Change Task Status</h2>
                    <Form onSubmit={handleInput}>
                        <Form.Group className="mb-3">
                            <Form.Label>Task ID</Form.Label>
                            <Form.Control placeholder={taskId} disabled />
                        </Form.Group>
                        <Form.Group className="mb-3">
                            <Form.Label>Status</Form.Label>
                            <Form.Select name="status" required>
                                <option value="TO_DO">TO_DO</option>
                                <option value="DOING">DOING</option>
                                <option value="DONE">DONE</option>
                            </Form.Select>
                        </Form.Group>
                        <Button variant="warning" type="submit">
                            Change
                        </Button>
                    </Form>
                </Col>
            </Row>
        </Container>
    )
}
export default ChangeTaskStatus;
