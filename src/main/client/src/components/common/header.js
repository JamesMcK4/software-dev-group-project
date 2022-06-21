import React from 'react';
import {Navbar, Nav, NavDropdown, Container} from 'react-bootstrap'

function Header(){
    return (
        <Navbar bg="success" expand="lg" variant="dark" sticky="top" >
            <Container>
                <Navbar.Brand href="/">Trello-clone</Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="me-auto">
                        <Nav.Link href="/">Home</Nav.Link>
                        <Nav.Link href="/register">Register</Nav.Link>
                        <Nav.Link href="/login">Log in</Nav.Link>
                        <NavDropdown title="Dropdown" id="basic-nav-dropdown">
                        <NavDropdown.Item href="/create-board">Create Board</NavDropdown.Item>
                        <NavDropdown.Item href="/create-workspace">Create Workspace</NavDropdown.Item>
                        <NavDropdown.Item href="/forget-password">Forgot Password</NavDropdown.Item>
                        <NavDropdown.Divider />
                        <NavDropdown.Item href="#action/3.4">Separated link</NavDropdown.Item>
                        </NavDropdown>
                    </Nav>
                </Navbar.Collapse>
                <Navbar.Collapse  className="justify-content-end">
                <Nav>
                    <Nav.Link href="/login">Logout</Nav.Link>
                </Nav>
                </Navbar.Collapse>
            </Container>
        </Navbar>
    );
};

export default Header;