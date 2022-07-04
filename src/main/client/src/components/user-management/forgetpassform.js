import React from 'react';
import { useNavigate } from "react-router-dom";
import { useRef } from 'react';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import { Modal } from 'react-bootstrap';
import { useEffect } from 'react';


function ForgotPassForm(){

    const emailRef = useRef();
    
    const nav = useNavigate();


    async function forgetPass(email){
        const response = await fetch("http://localhost:9000/user/get_email/" + email, {
            method: 'GET',
            mode: 'cors',
            headers: {'Content-Type': 'application/json'}
        })
        
        var data = await response.json();
        if(data.user===null){
            alert("Your email is incorrect!");
        }
        else{
            nav("/resetpassword/" + email);
        }
    }

    // function updatePass(){
    //     fetch("http://localhost:9000/user/updatePassword/" + emailRef.value, {
    //         method: 'PUT',
    //         mode: 'cors',
    //         body: JSON.stringify(),
    //         headers: {'Content-Type': 'application/json'}
    //     }).then(() => nav('/'));
    // }

    
    function submissionHandler(e){
        e.preventDefault();

        const email = emailRef.current.value;
        //const password = passwordRef.current.value; //for some reason, this isnt being read properly.  If I remove .current, it just shows up
        //as undefined, if I leave current in, it gives me a different error, but still undefined.  Not sure its needed?
        //const user = {email};

        console.log(email);
        forgetPass(email);   
}


return(
<Container>
<Row className="justify-content-md-center mt-5">
    <Col md='6' className="align-self-center">
        
        <Form onSubmit={submissionHandler}>
        <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1" >
            <Form.Label>Security Question Sample: What is your email address?</Form.Label>
            <Form.Control type="email" placeholder="Email Address?" ref={emailRef} />
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

