import {Col, Form, Button, Container, Row, Modal} from 'react-bootstrap';
import { useParams, useNavigate } from 'react-router-dom';
import { useState, useEffect } from 'react';

const AddUser = () => {

    const navigate = useNavigate();

    const workspaceId = useParams().workspaceId;

    const [show, setShow] = useState(false);
    const [validated, setValidated] = useState('');

    const handleClose = () => {
        setShow(false);
        if (validated){
            navigate(/workspace/ + workspaceId);
        }
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
                const status = await addUser(userId, workspaceId);
                console.log(status);
                handleShow();
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

    async function addUser(userId, workspaceId) {
        return true;
    }

    return (
    <>
    <Container>
        <Row className="justify-content-md-center mt-5">
            <Col md='6' className="align-self-center text-center">
                <h2>Add a new user</h2>
                <Form onSubmit={handleInput}>
                    <Form.Group className="mb-3">
                        <Form.Label>Workspace ID</Form.Label>
                        <Form.Control placeholder={workspaceId} disabled />
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
            {validated?  ' The user has been added to the workspace' : ''}
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
export default AddUser;