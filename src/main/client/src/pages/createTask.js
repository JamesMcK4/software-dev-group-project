
import {useNavigate, useParams} from "react-router-dom";
import React, {useRef} from "react";
import CreateTaskForm from "../components/task/createtaskform";
const CreateTask = () => {
    const navigate=useNavigate();
    const boardId=useParams().boardId;

    function createTask(task){
        fetch("http://localhost:9001/task/create_task", {
            method: 'POST',
            mode: 'cors',
            body: JSON.stringify(task),
            headers: {'Content-Type': 'application/json'}
        }).then((res) => res.json()).
        then((data) => {
            navigate('/board/' + data.id)
        })
    }

    return (
        <CreateTaskForm createWorkspace={createTask}/>
    );
}
export default CreateTask;