import {Form, Row, Col} from 'react-bootstrap';
import Moment from 'moment';

function FilterTask({setTasks, tasks}) {

  const filterTask = (e) => {
    console.log(e.target.value);
    const filter = e.target.value;
    var filterTasks = tasks.filter((task) => {
        switch(filter) {
          case "today":
            var start = Moment().subtract(1, 'days');
            var end = Moment();
            return Moment(task.dueOn).isBetween(start, end);
          case "week":
            var start = Moment().subtract(1, 'days');
            var end = Moment().add(1, "week");
            return Moment(task.dueOn).isBetween(start, end);
          case "over":
            // code block
            var end = Moment().subtract(1, "day");
            return Moment(task.dueOn).isBefore(end);
          default:
            // code block
            return true;
        } 
      });
    console.log(filterTasks);
    setTasks(filterTasks);
  }

  return (
    <Form.Group as={Row} className="mt-5" controlId="filterDate">
      <Form.Label column md="4" className="h3">Filter tasks by date</Form.Label>
      <Col md="8">
        <Form.Select aria-label="date filter" onChange={filterTask}>
          <option value="none">None</option>
          <option value="today">Due today</option>
          <option value="week">Due in one week</option>
          <option value="over">Overdue</option>
        </Form.Select>
      </Col>
    </Form.Group>
  );
}

export default FilterTask;