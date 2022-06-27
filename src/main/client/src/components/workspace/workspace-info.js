import {Card, Container} from 'react-bootstrap';

const WorkspaceInfo = () => {
    return (
    <Card className="bg-dark text-white p-3">
        <Container className="d-flex p-0 mb-2 align-items-start">
            <div className="bg-warning text-white d-flex" style={{width: '3em', height: '3em'}}>
                <p className="my-auto mx-auto d-block display-6">
                    W
                </p>
            </div>
            <Card.Title className="my-auto p-2">Workspace name</Card.Title>
        </Container>
        <Card.Text>
            This is a wider card with supporting text below as a natural lead-in to
            additional content. This content is a little bit longer.
        </Card.Text>
    </Card>
    );
}
export default WorkspaceInfo;