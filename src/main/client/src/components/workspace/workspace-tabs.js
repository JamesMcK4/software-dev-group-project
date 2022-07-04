import {Card, Nav, Button, Tab, Alert} from 'react-bootstrap';
import {BoardList, UserList, WorkspaceSetting} from "../../index.js";

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
                        <UserList workspaceUsers={workspace.users === undefined? [] : workspace.users}></UserList>
                    </Tab.Pane>
                    <Tab.Pane eventKey="settings">
                        <Card.Title>Settings</Card.Title>
                        <Card.Text>
                        Change the workspace and description here.
                        </Card.Text>
                        <WorkspaceSetting workspace={workspace}></WorkspaceSetting>
                    </Tab.Pane>
                    </Tab.Content>
            </Card.Body>
        </Card>
        </Tab.Container>
    )
}
export default WorkspaceTabs;