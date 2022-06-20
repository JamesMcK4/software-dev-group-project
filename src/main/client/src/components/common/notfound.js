import React from 'react';
import { Link } from 'react-router-dom';
import {Container, Row, Col} from 'react-bootstrap';

const NotFound = () => {
  return (
    <Container>
        <Row className="justify-content-md-center" style={{height: '100vh'}}>
            <Col md='6' className="align-self-center">
                <h3>404 NOT FOUND</h3>
                <p>Sorry, the page you are searching for does not exist.</p>
                <Link to="/">Go back to homepage</Link>
            </Col>
        </Row>
    </Container>
  );
};

export default NotFound;