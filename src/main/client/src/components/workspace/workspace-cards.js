import { useEffect, useState } from 'react';
import {Card, Button, Row, Col} from 'react-bootstrap';
import {BoardListHome} from '../../index.js';

const WorkspaceCards = () => {

    var [workspaces, setWorkspaces] = useState([]);

    useEffect(() => {
        getAllWorkspaces();
      }, []);

    async function getAllWorkspaces() {
        // You can await here
        const response = await fetch("http://localhost:9001/workspace/get_all_workspaces", {
        method: 'GET',
        }, {mode: 'cors'});
        response.json().then((value) => {
            console.log(value);
            setWorkspaces(workspaces => value);
        });
    }

    return (
        <Row xs={1} md={2} className="g-4">
        {workspaces.map((workspace, key) => (
            <Col key={key}>
            <Card bg="dark" text="light">
                <Card.Header as="h3" className="text-capitalize">{workspace.name}</Card.Header>
                <Card.Body>
                    <Card.Subtitle className="mb-2 text-warning">Total members: {workspace.users.length}</Card.Subtitle>
                    <Card.Text>
                    {workspace.description}
                    </Card.Text>
                    <Button variant="warning" href={"/workspace/" + workspace.id}>Visit</Button>
                </Card.Body>
                <Card.Body>
                    <Card.Title>Boards</Card.Title>
                </Card.Body>
                <BoardListHome workspaceBoards={workspace.boards}>
                </BoardListHome>
            </Card>
        </Col>))}
        </Row>
    );
}
export default WorkspaceCards;