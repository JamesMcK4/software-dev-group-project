import {WorkspaceTabs, WorkspaceInfo} from '../index.js';
import {Container, Row, Col} from 'react-bootstrap';
import {useState, useEffect} from 'react';
import {useParams, useNavigate} from 'react-router-dom';

const Workspace = () => {

    const navigate = useNavigate();

    var [workspace, setWorkspace] = useState({});
    const workspaceId = useParams().workspaceId;

    useEffect(() => {
        getWorkspace(workspaceId);
    }, [workspaceId]);

    useEffect(() => {
        console.log(workspace);
    }, [workspace]);

    async function getWorkspace(workspaceId) {
        // You can await here
        const response = await fetch("http://localhost:9001/workspace/get_workspace/" + workspaceId, {
        method: 'GET',
        }, {mode: 'cors'});
        response.json().then((value) => {
            console.log(value);
            setWorkspace(value);
        }).catch((e) => {
            alert("Fail to fetch the workspace. It might not exist.");
            navigate("/");
        });
    }

    return (
        <Container>
            <Row>
                <Col>
                    <WorkspaceInfo workspace={workspace}>
                    </WorkspaceInfo>
                </Col>
            </Row>
            <Row>
                <Col>
                    <WorkspaceTabs workspace={workspace}>
                    </WorkspaceTabs>
                </Col>
            </Row>
        </Container>
    );
}
export default Workspace;