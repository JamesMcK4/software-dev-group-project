import React from 'react';
import {Navbar, Nav, Container} from 'react-bootstrap';
import {useLocation, useNavigate} from 'react-router-dom';

function Header(){

    const location = useLocation();
    const navigate = useNavigate();

    function logout(e){
        e.preventDefault();
        localStorage.clear();
        window.location.reload(false);
    }

    return (
        <Navbar bg="success" expand="lg" variant="dark" sticky="top" >
            <Container>
                <Navbar.Brand href="/">Trello-clone</Navbar.Brand>
                {localStorage.getItem("userId") !== null? 
                    <Navbar.Toggle aria-controls="basic-navbar-nav"/>
                :<></>
                }
                {localStorage.getItem("userId") !== null? 
                    <Navbar.Collapse  className="justify-content-end">
                        <Nav>
                            <Nav.Link onClick={logout}>Logout</Nav.Link>
                        </Nav>
                    </Navbar.Collapse>
                :<></>
                }
            </Container>
        </Navbar>
    );
};

export default Header;

/*

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
                        <NavDropdown.Item href="/create-board/1">Create Board</NavDropdown.Item>
                        <NavDropdown.Item href="/create-workspace">Create Workspace</NavDropdown.Item>
                        <NavDropdown.Item href="/forget-password">Forgot Password</NavDropdown.Item>
                        <NavDropdown.Divider />
                        <NavDropdown.Item href="/workspace/1">Workspace</NavDropdown.Item>
                        <NavDropdown.Item href="/board/1">Board</NavDropdown.Item>
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


        <Navbar.Toggle aria-controls="basic-navbar-nav">
                        <Navbar.Collapse  className="justify-content-end">
                            <Nav>
                                <Nav.Link onClick={logout}>Logout</Nav.Link>
                            </Nav>
                        </Navbar.Collapse>
                    </Navbar.Toggle>

*/