import {Button, Card, Col, Container, Row} from "react-bootstrap";

import TaskCards from "../components/task/task-card";

const Board = () => {
    return(
        <Container style={{width: "90%"}}>
            <Row className="justify-content-md-center mt-5">
                <Col md="auto">
                    <h1 className='text-warning'>
                        Board
                    </h1>
                </Col>
            </Row>
            <Row className="justify-content-md-center mb-5">
                <Col md="auto">
                    <h2>
                        All Tasks
                    </h2>
                    <Button variant="warning" href="/create-Task">
                        Create a new Task
                    </Button>
                </Col>
            </Row>
            <TaskCards></TaskCards>
        </Container>
    )
}
export default Board ;