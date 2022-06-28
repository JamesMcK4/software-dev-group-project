import React from 'react';
import {Form, Container, Row, Col, Button} from 'react-bootstrap';
import { useRef } from 'react';
import { propTypes } from 'react-bootstrap/esm/Image';

function LoginForm({loginUser}){
    const emailRef = useRef();
    const passwordRef = useRef();



    function submissionHandler(e){
        e.preventDefault();

        const email = emailRef.current.value;
        const password = passwordRef.current.value;
        const user = {email, password};

        loginUser(user);
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
                        <a href="/@{/forgot_password}" className="link-primary">Forgot your password?</a>
                    </Form>
                </Col>
            </Row>
        </Container>
    )
}

export default LoginForm;