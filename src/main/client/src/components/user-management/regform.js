import React from 'react';
import { useState } from 'react';
import { useRef } from 'react';
import './regform.css';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Container from 'react-bootstrap/Container';



function RegisterForm({registerUser}){


    //Setting up new constants for each section of form using useRef (from tutorial vid) in order to link to backend
    const firstNameRef = useRef();
    const lastNameRef = useRef();
    const emailRef = useRef();
    const passwordRef = useRef();
    
    
    function passwordCheck(inputPassword){
        var passwordToCheck = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/;
        if(inputPassword.match(passwordToCheck)){ 
            return true; 
        }
        else{
            //should probably add an alert here to notify wrong password
            alert('Invalid Password!')
            return false;
        }
    }
    
        const submissionHandler = (e) => {
            e.preventDefault();
            
            const firstName = firstNameRef.current.value;
            const lastName = lastNameRef.current.value;
            const email = emailRef.current.value;
            const password = passwordRef.current.value;
            const passwordChecker = passwordCheck(password);
            if(passwordChecker === true){
            const user = {firstName, lastName, email, password};
            console.log(user);
           
            console.log(firstName);
            console.log(lastName);
            console.log(email);
            console.log(password);

            registerUser.registerUser(user);
        }
        else{
            alert('Invalid Password!');
        }
        
    }
    
        
    
    return(
        <Container>
            <Row className="justify-content-md-center" style={{height: '100vh'}}>
                <Col md='6' className="align-self-center">
                    <h3>Register!</h3>
                    <Form onSubmit={submissionHandler}>
                    <Form.Group className="mb-3" controlId="formBasicFirstName">
                            <Form.Label>First Name</Form.Label>
                            <Form.Control type="firstName" placeholder="First name" ref={firstNameRef} />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicLastName">
                            <Form.Label>Last Name</Form.Label>
                            <Form.Control type="lastName" placeholder="Last name" ref={lastNameRef}/>
                        </Form.Group>
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
                    </Form>
                </Col>
            </Row>
        </Container>
    );
}

export default RegisterForm;