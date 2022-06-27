import {Card, Nav, Button, Tab, Form, ListGroup} from 'react-bootstrap';

const WorkspaceTabs = () => {
    return (
        <Tab.Container defaultActiveKey="boards">
                    <Card>
            <Card.Header>
                <Nav variant="tabs">
                <Nav.Item>
                    <Nav.Link eventKey="boards">Boards</Nav.Link>
                </Nav.Item>
                <Nav.Item>
                    <Nav.Link eventKey="members">Members</Nav.Link>
                </Nav.Item>
                <Nav.Item>
                    <Nav.Link eventKey="settings">
                    Settings
                    </Nav.Link>
                </Nav.Item>
                </Nav>
            </Card.Header>
            <Card.Body>
                <Tab.Content>
                    <Tab.Pane eventKey="boards">
                        <Card.Title>Boards</Card.Title>
                        <Card.Text>
                        List of boards and their respective links.
                        </Card.Text>
                        <ListGroup className="list-group-flush">
                            <ListGroup.Item><Card.Link href="/board/1" className="link-success">Board Link</Card.Link></ListGroup.Item>
                            <ListGroup.Item><Card.Link href="/board/1" className="link-success">Board Link</Card.Link></ListGroup.Item>
                            <ListGroup.Item><Card.Link href="/board/1" className="link-success">Board Link</Card.Link></ListGroup.Item>
                        </ListGroup>
                    </Tab.Pane>
                    <Tab.Pane eventKey="members">
                        <Card.Title>Members</Card.Title>
                        <Card.Text>
                        List of members.
                        </Card.Text>
                        <ListGroup className="list-group-flush">
                            <ListGroup.Item>Cras justo odio</ListGroup.Item>
                            <ListGroup.Item>Dapibus ac facilisis in</ListGroup.Item>
                            <ListGroup.Item>Vestibulum at eros</ListGroup.Item>
                        </ListGroup>
                    </Tab.Pane>
                    <Tab.Pane eventKey="settings">
                        <Card.Title>Settings</Card.Title>
                        <Card.Text>
                        With supporting text below as a natural lead-in to additional content.
                        </Card.Text>
                        <Form>
                        <Form.Group className="mb-3" controlId="formWorkspaceName">
                            <Form.Label>Name</Form.Label>
                            <Form.Control type="text" value="workspace name"/>
                        </Form.Group>

                        <Form.Group className="mb-3" controlId="formWorkspaceDescription">
                            <Form.Label>Description</Form.Label>
                            <Form.Control type="text" value="workpspace description" />
                        </Form.Group>
                        <Button variant="warning" type="submit">
                            Change
                        </Button>
                        </Form>
                    </Tab.Pane>
                    </Tab.Content>
            </Card.Body>
        </Card>
        </Tab.Container>
    )
}
export default WorkspaceTabs;