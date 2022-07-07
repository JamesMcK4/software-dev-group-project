import {Card, Container} from 'react-bootstrap';

const WorkspaceInfo = ({workspace}) => {

    return (
    <Card className="bg-dark text-white p-3">
        <Container className="d-flex p-0 mb-2 align-items-start">
            <div className="bg-warning text-white d-flex" style={{width: '3em', height: '3em'}}>
                <p className="my-auto mx-auto d-block display-6">
                    {workspace.name === undefined? "W": workspace.name.charAt(0)}
                </p>
            </div>
            <Card.Title className="my-auto p-2">{workspace.name === undefined? "workspace name": workspace.name}</Card.Title>
        </Container>
        <Card.Text>
            {workspace.description === undefined? "workspace description": workspace.description}
        </Card.Text>
    </Card>
    );
}
export default WorkspaceInfo;