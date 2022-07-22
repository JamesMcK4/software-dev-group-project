import {Card} from 'react-bootstrap';

const BoardInfo = ({board}) => {

    return (
        <>
        {board !== undefined? 
            <Card className="bg-dark text-white p-3 text-center">
                <Card.Header className="text-warning text-capitalize">
                    <h1>
                    {board.name === undefined? "Board": board.name}
                    </h1>
                </Card.Header>
                <Card.Body>
                    <Card.Text className="lead">
                    {board.description === undefined? "Board Description": board.description}
                    </Card.Text>
                </Card.Body>
            </Card>: ""
        }
        </>
    );
}
export default BoardInfo;