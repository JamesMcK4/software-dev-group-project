import React from 'react';
import { useNavigate } from "react-router-dom";
import { useRef } from 'react';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import { useEffect } from 'react';
import { useParams } from 'react-router-dom';

    function ResetPasswordForm(){
    const email = useParams().emailId;
    const passwordRef = null;
    const nav = useNavigate();
    
    function resetPassword(password){
         fetch("http://localhost:9000/user/save_user", {
            method: 'POST',
            mode: 'cors',
            body: JSON.stringify(password),
            headers: {'Content-Type': 'application/json'}
        });
        
    }

    function submissionHandler(e){
        e.preventDefault();
        
        const password = passwordRef.current.value;
        console.log(password);

        //resetPassword(password);   
}

    return(
        <Container>
        <Row className="justify-content-md-center mt-5">
            <Col md='6' className="align-self-center">
                <Form onSubmit={submissionHandler}>
                <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1" >
                    <Form.Label>Please Enter A New Password</Form.Label>
                    <Form.Control type="email" placeholder="New Password?" />
                </Form.Group>
                <Button variant="warning" type="submit">
                    Submit
                </Button>
                </Form>
            </Col>
        </Row>
        </Container>
        )
}

export default ResetPasswordForm;
