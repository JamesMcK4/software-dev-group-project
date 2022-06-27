import {Row, Col, Container} from 'react-bootstrap';
import {WorkspaceCards} from '../index.js';

const Home = () => {
    return (
        <Container style={{width: "90%"}}>
            <Row className="justify-content-md-center mt-5">
                <Col md="auto">
                    <h1 className='text-warning'>
                        Trello Clone
                    </h1>
                </Col>
            </Row>
            <Row className="justify-content-md-center">
                <Col md="auto">
                    <h2>
                        Your workspaces
                    </h2>
                </Col>
            </Row>
            <WorkspaceCards></WorkspaceCards>
        </Container>
    )
}
export default Home;