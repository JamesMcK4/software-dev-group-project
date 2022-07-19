import {Row, Col, Container, Button} from 'react-bootstrap';
import {WorkspaceCards} from '../index.js';

const Home = ({userId}) => {
    return (
        <Container style={{width: "90%"}}>
            <Row className="justify-content-md-center mt-5">
                <Col md="auto">
                    <h1 className='text-warning'>
                        Trello Clone
                    </h1>
                </Col>
            </Row>
            <Row className="justify-content-md-center mb-5">
                <Col md="auto">
                    <h2>
                        All workspaces
                    </h2>
                    <Button variant="warning" href="/create-workspace">
                        Create a new workspace
                    </Button>
                </Col>
            </Row>
            <WorkspaceCards></WorkspaceCards>
        </Container>
    )
}
export default Home;