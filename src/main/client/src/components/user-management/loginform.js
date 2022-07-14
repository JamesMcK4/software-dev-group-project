import React from 'react';
import {Form, Container, Row, Col, Button, Nav} from 'react-bootstrap';
import { useRef } from 'react';

function LoginForm(){
    const emailRef = useRef();
    const passwordRef = useRef();

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
                        <Nav className="flex-column">
                            <Nav.Link variant="success" href="/forget-password" className="px-0 link-success">Forgot your password?</Nav.Link>
                            <Nav.Link variant="success" href="/register" className="px-0 link-success">Don't have an account?</Nav.Link>
                        </Nav>
                    </Form>
                </Col>
            </Row>
        </Container>
    )
}

export default LoginForm;