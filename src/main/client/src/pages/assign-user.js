import {Col, Form, Button, Container, Row, Modal} from 'react-bootstrap';
import { useParams, useNavigate } from 'react-router-dom';
import { useState, useEffect } from 'react';


const AssignUser = () => {
    const navigate = useNavigate();
    const taskId = useParams().taskId;

    const [show, setShow] = useState(false);
    const [validated, setValidated] = useState('');

    const handleClose = () => {
        setShow(false);
    };
    const handleShow = () => setShow(true);

    useEffect(() => {
        console.log(validated);
    }, [validated]);

    async function handleInput(e) {
        e.preventDefault();
        var emailId = e.target.emailId.value;
        console.log(emailId);
        var data = await checkUserEmail(emailId);
        setValidated(data.validated);
        if (!data.validated){
            handleShow();
        }
        
        else{
            if (data.id !== undefined){
                const userId = data.id;
                var data = await assignUser(userId, taskId);
                console.log(data);
                if (data.status !== undefined && data.status){
                    handleShow();
                }
            }
        }
    }


    async function checkUserEmail(emailId) {
        const response = await fetch("http://localhost:9001/user/get_email/" + emailId, {
            method: 'GET',
            mode: 'cors'
        });
        var data = await response.json();
        return data;
    }
    
    

    async function assignUser(userId, taskId) {
        // You can await here
        const response = await fetch("http://localhost:9001/task/assign_task/" + taskId+ "?userId=" + userId, {
            method: 'PUT',
            mode: 'cors',
            headers: {'Content-Type': 'application/json'}
            });
        var data = await response.json();
        return data;
    }

    return (
    <>
    <Container>
        <Row className="justify-content-md-center mt-5">
            <Col md='6' className="align-self-center text-center">
                <h2>Assign a user</h2>
                <Form onSubmit={handleInput}>
                    <Form.Group className="mb-3">
                        <Form.Label>Tasks ID</Form.Label>
                        <Form.Control placeholder={taskId} disabled />
                    </Form.Group>
                    <Form.Group className="mb-3" controlId="formBoardName">
                        <Form.Label>User's email address</Form.Label>
                        <Form.Control type="email" placeholder="User's email address" name="emailId" required/>
                    </Form.Group>
                    <Button variant="warning" type="submit">
                        Add
                    </Button>
                </Form>
            </Col>
        </Row>
    </Container>

    <Modal show={show} onHide={handleClose}>
        <Modal.Header closeButton>
            <Modal.Title>Validation status: 
                {validated?  ' Successful' : ' Unsucessful'}
            </Modal.Title>
        </Modal.Header>
        <Modal.Body>The user email 
            {validated?  ' exists ' : ' does not exist '}
            in the database.
            {validated?  ' The user has been assigned to a task' : ''}
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleClose}>
            Close
          </Button>
        </Modal.Footer>
      </Modal>
    </>
    );
}
export default AssignUser;