import React from 'react';
import { useState } from 'react';
import './regform.css';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Container from 'react-bootstrap/Container';

function RegisterForm(){

    //set constants/values for each section of form to be able to use states properly
    const [firstName, setFirstName] = useState(null);
    const [lastName, setLastName] = useState(null);
    const [email, setEmail] = useState(null);
    const [password, setPassword] = useState(null);

    //making an input handler to deal with all the inputs - e representing the event.
    //Using a bunch of if statements in order to capture all the different sections
    const inputHandler = (e) =>{
        const {id, value} = e.target;
        if(id==="firstName"){
            setFirstName(value);
        }
        if(id==="lastName"){
            setLastName(value);
        }
        if(id==="email"){
            setEmail(value);
        }
        if(id==="password"){
            setPassword(value);
        }

        const submissionHandler = () => {
            console.log(firstName, lastName, email, password)
        }
    }

    return(
        <Container>
            <Row className="justify-content-md-center" style={{height: '100vh'}}>
                <Col md='6' className="align-self-center">
                    <h3>Register!</h3>
                    <Form>
                        <Form.Group className="mb-3" controlId="formBasicEmail">
                            <Form.Label>Email address</Form.Label>
                            <Form.Control type="email" placeholder="Enter email" />
                        </Form.Group>

                        <Form.Group className="mb-3" controlId="formBasicPassword">
                            <Form.Label>Password</Form.Label>
                            <Form.Control type="password" placeholder="Password" />
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