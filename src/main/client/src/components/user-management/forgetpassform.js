import React from 'react';
import { useNavigate } from "react-router-dom";
import { useRef } from 'react';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import { Modal } from 'react-bootstrap';
import { useState } from 'react';


function ForgotPassForm(){

    const emailRef = useRef();
    const passwordRef = useRef();
    const nav = useNavigate();


    function forgetPass(){
        fetch("http://localhost:9000/user/get_email/" + emailRef.value, {
            method: 'GET',
            mode: 'cors',
            headers: {'Content-Type': 'application/json'}
        }).then(() => updatePass()); //or then(() => Popup() for getting the popup and then call updatePass function?
    }

    function updatePass(){
        fetch("http://localhost:9000/user/updatePassword/" + emailRef.value, {
            method: 'POST',
            mode: 'cors',
            body: JSON.stringify(),
            headers: {'Content-Type': 'application/json'}
        }).then(() => nav('/'));
    }

    // function Popup() {
    //     const [show, setShow] = useState(false);
      
    //     const closed = () => setShow(false);
    //     const open = () => setShow(true);
      
    //     return (
    //       <>
    //      
    //         <Modal show={show} onHide={closed}>
    //           <Modal.Header closeButton>
    //             <Modal.Title>Update Password</Modal.Title>
    //           </Modal.Header>
    //           <Modal.Body>Please enter your new password</Modal.Body>
    //           <Modal.Footer>
    //             <Button variant="secondary" onClick={closed}>
    //               Close
    //             </Button>
    //             <Button variant="primary" onClick={open}>
    //               Save Changes
    //             </Button>
    //           </Modal.Footer>
    //         </Modal>
    //       </>
    //     );
    //   }
    
    function submissionHandler(e){
        e.preventDefault();

        const email = emailRef.current.value;
        //const password = passwordRef.current.value; //for some reason, this isnt being read properly.  If I remove .current, it just shows up
        //as undefined, if I leave current in, it gives me a different error, but still undefined.  Not sure its needed?
        const user = {email};

        console.log(email);
        forgetPass(user);   
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

