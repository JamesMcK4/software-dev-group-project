import {Card, Nav, Button, Tab} from 'react-bootstrap';
import {BoardList, UserList, WorkspaceSetting} from "../../index.js";

const WorkspaceTabs = ({workspace}) => {

    async function handleDeleteBoard(e){
        const boardId = e.target.id;
        console.log(boardId);
        await deleteBoard(workspace.id, boardId);
        alert("Delete board sucessfully!");
        window.location.reload(false);
    }

    async function handleDeleteUser(e){
        alert("Not implemented yet. Not in deliverable 2.");
    }

    async function deleteBoard(workspaceId, boardId){
        const response = await fetch("http://localhost:9001/workspace/delete_board/" + workspaceId + "/" + boardId, {
            method: 'DELETE',
            mode: 'cors',
            headers: {'Content-Type': 'application/json'}
        })
        var data = await response.json();
        console.log(data);
        return data;
    }

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
                        <BoardList workspaceBoards={workspace.boards === undefined? [] : workspace.boards} handleDelete={handleDeleteBoard}>
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
                        <UserList workspaceUsers={workspace.users === undefined? [] : workspace.users} handleDelete={handleDeleteUser}></UserList>
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