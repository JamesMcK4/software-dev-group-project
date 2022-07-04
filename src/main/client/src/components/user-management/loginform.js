import React from 'react';
import {Form, Container, Row, Col, Button} from 'react-bootstrap';
import { useRef } from 'react';
import { useNavigate } from 'react-router-dom';

function LoginForm(){
    const emailRef = useRef();
    const passwordRef = useRef();
    const navigate = useNavigate();

    async function validateUser(userLogin){
        console.log(userLogin['emailId']);
        console.log(userLogin['password']);
        const response = await fetch("http://localhost:9001/user/validate_user", {
            method: 'POST',
            mode: 'cors',
            body: JSON.stringify(userLogin),
            headers: {'Content-Type': 'application/json'}
        })

        response.json().then((data) => {
            console.log(data.validated);
            // If data.validated is true then go to home page
            if (data.validated){
                localStorage.setItem("userId", data.id);
                console.log(localStorage.getItem("userId"));
                window.location.reload(false);
            }
            else{
                alert("Your login credential is invalid. Please try again.")
            }
        });
    }

    function submissionHandler(e){
        e.preventDefault();
        const emailId = emailRef.current.value;
        const password = passwordRef.current.value;
        const userLogin = {emailId, password};
        validateUser(userLogin);
}

    return (
        <Container>
            <Row className="justify-content-md-center" style={{height: '100vh'}}>
                <Col md='6' className="align-self-center">
                    <h3>Login!</h3>
                    <Form onSubmit={submissionHandler}>
                    <Form.Group className="mb-3" controlId="formBasicEmail">
                            <Form.Label>Email address</Form.Label>
                            <Form.Control type="email" placeholder="Enter email" ref={emailRef} />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicPassword">
                            <Form.Label>Password</Form.Label>
                            <Form.Control type="password" placeholder="Password" ref={passwordRef}/>
                        </Form.Group>
                        <Button variant="warning" type="submit">
                            Submit
                        </Button>
                        <br></br>
                        <a href="http://localhost:3000/forget-password" className="link-primary">Forgot your password?</a>
                    </Form>
                </Col>
            </Row>
        </Container>
    )
}

export default LoginForm;