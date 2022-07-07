import React from 'react';
import { useNavigate } from "react-router-dom";
import { useRef } from 'react';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import { useParams } from 'react-router-dom';

    function ResetPasswordForm(){
    const emailId = useParams().emailId;
    const passwordRef = useRef();
    const nav = useNavigate();
    
    async function resetPassword(userLogin){
         const response = await fetch("http://localhost:9001/user/updatePassword", {
            method: 'PUT',
            mode: 'cors',
            body: JSON.stringify(userLogin),
            headers: {'Content-Type': 'application/json'}
        });
        var data = await response.json();
        console.log(data);
        if(data.object === undefined || data.object === "error"){
            alert("Nothing worked, try again!");
        }
        else{
            alert("Update password sucessfully!");
            nav("/login");
        }
    }

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

    function submissionHandler(e){
        e.preventDefault();
        
        const password = passwordRef.current.value;
        console.log(password);
        if (passwordCheck(password)){
            const userLogin = {emailId, password};
            resetPassword(userLogin);   
        }
}

    return(
        <Container>
        <Row className="justify-content-md-center mt-5">
            <Col md='6' className="align-self-center">
                <Form onSubmit={submissionHandler}>
                <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1" >
                    <Form.Label>Please Enter A New Password</Form.Label>
                    <Form.Control type="password" placeholder="New Password?" ref={passwordRef}/>
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
