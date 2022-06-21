import {Row, Col, Container, Card, Button, ListGroup, ListGroupItem} from 'react-bootstrap';

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
            <Row>
                <Col md="4">
                    <Card bg="dark" text="light">
                        <Card.Header as="h3">Workspace Name</Card.Header>
                        <Card.Body>
                            <Card.Subtitle className="mb-2 text-warning">Total members: 10</Card.Subtitle>
                            <Card.Text>
                            This is a description of the work space.
                            </Card.Text>
                            <Button variant="warning">Visit</Button>
                        </Card.Body>
                        <Card.Body>
                            <Card.Title>Boards</Card.Title>
                        </Card.Body>
                        <ListGroup className="list-group-flush">
                            <ListGroupItem><a href="#" className="link-success">Board A</a></ListGroupItem>
                            <ListGroupItem><a href="#" className="link-success">Board B</a></ListGroupItem>
                            <ListGroupItem><a href="#" className="link-success">Board C</a></ListGroupItem>
                        </ListGroup>
                    </Card>
                </Col>
                <Col md="4">
                </Col>
                <Col md="4">
                </Col>
            </Row>
        </Container>
    )
}
export default Home;