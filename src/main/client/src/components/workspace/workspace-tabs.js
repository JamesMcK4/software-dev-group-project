import {Card, Nav, Button, Tab, Form, ListGroup} from 'react-bootstrap';
import {BoardList} from "../../index.js";

const WorkspaceTabs = ({workspace}) => {
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
                        <Button variant="warning" href={"/create-board/" + workspace.id}>
                            Create a board
                        </Button>
                        <BoardList workspaceBoards={workspace.boards === undefined? [] : workspace.boards}>
                        </BoardList>
                    </Tab.Pane>
                    <Tab.Pane eventKey="members">
                        <Card.Title>Members</Card.Title>
                        <Card.Subtitle className="mb-2 text-warning">Total members: {workspace.users === undefined? 0 : workspace.users.length}</Card.Subtitle>
                        <Button variant="warning" href={"/add-user/" + workspace.id}>
                            Add a new user
                        </Button>
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
                        Change the workspace and description here.
                        </Card.Text>
                        <Form>
                        <Form.Group className="mb-3" controlId="formWorkspaceName">
                            <Form.Label>Name</Form.Label>
                            <Form.Control type="text" placeholder={workspace.name === undefined? "workspace name": workspace.name}/>
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formWorkspaceDescription">
                            <Form.Label>Description</Form.Label>
                            <Form.Control type="text" placeholder={workspace.description === undefined? "workspace description": workspace.description}/>
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