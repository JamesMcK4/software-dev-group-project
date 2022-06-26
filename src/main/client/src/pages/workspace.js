import {WorkspaceTabs, WorkspaceInfo} from '../index.js';
import {Container, Row, Col} from 'react-bootstrap';

const Workspace = () => {
    return (
        <Container>
            <Row>
                <Col>
                    <WorkspaceInfo>
                    </WorkspaceInfo>
                </Col>
            </Row>
            <Row>
                <Col>
                    <WorkspaceTabs>
                    </WorkspaceTabs>
                </Col>
            </Row>
        </Container>
    );
}
export default Workspace;