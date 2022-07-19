
import {useNavigate, useParams} from "react-router-dom";
import React, {useRef} from "react";
import CreateTaskForm from "../components/task/createtaskform";

const CreateTask = () => {
    const navigate=useNavigate();
    const boardId=useParams().boardId;

    function createTask(boardId,task){
        fetch("http://localhost:9001/task/create_task/", {
            method: 'POST',
            mode: 'cors',
            body: JSON.stringify(task),
            headers: {'Content-Type': 'application/json'}
        }).then((res) => res.json()).
        then((data) => {
            navigate('/board/' + boardId)
            // After you create the task, it will return a task model, which contains the task Id.
            // You need to call the backend method addTask(boardId, taskId) and pass to it the task Id of the one you just create.
            // After it returns successfully, redirect the user back to the board.
        })
    }

    return (
        <CreateTaskForm createTask={createTask}/>
    );
}
export default CreateTask;