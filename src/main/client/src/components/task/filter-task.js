import {Form, Row, Col} from 'react-bootstrap';

function FilterTask({setTasks, tasks}) {
  return (
    <Form.Group as={Row} className="mt-5" controlId="filterDate">
      <Form.Label column md="4">Filter tasks by date</Form.Label>
      <Col md="8">
        <Form.Select aria-label="date filter">
          <option value="">None</option>
          <option value="today">Due today</option>
          <option value="week">Due in one week</option>
          <option value="over">Overdue</option>
        </Form.Select>
      </Col>
    </Form.Group>
  );
}

export default FilterTask;