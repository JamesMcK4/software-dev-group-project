import Form from 'react-bootstrap/Form';

function FilterTask({setTasks, tasks}) {
  return (
    <Form.Select aria-label="Default select example">
      <option>Filter tasks by date</option>
      <option value="1">Due today</option>
      <option value="2">Due in one week</option>
      <option value="3">Overdue</option>
    </Form.Select>
  );
}

export default FilterTask;