import React from 'react';
import { useNavigate } from "react-router-dom";
import { useRef } from 'react';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';


function ForgotPassForm(){

    const emailRef = useRef();
    const passwordRef = useRef();
    const nav = useNavigate();


    function forgetPass(){
        fetch("http://localhost:9001/user/get_email/{id}", {
            method: 'GET',
            mode: 'cors',
            headers: {'Content-Type': 'application/json'}
        });
    }

    function updatePass(){
        fetch("http://localhost:9001/user/get_email/{id}", {
            method: 'POST',
            mode: 'cors',
            body: JSON.stringify(),
            headers: {'Content-Type': 'application/json'}
        }).then(() => nav('/'));
    }

    function submissionHandler(e){
        e.preventDefault();

        const email = emailRef.current.value;
        const password = passwordRef.current.value;
        const user = {email, password};

        console.log(email);
        console.log(password);
        forgetPass(user);
}

return(
<Container>
<Row className="justify-content-md-center mt-5">
    <Col md='6' className="align-self-center">
        
        <Form>
        <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
            <Form.Label>Security Question Sample: What is your email address?</Form.Label>
            <Form.Control/>
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

export default ForgotPassForm;