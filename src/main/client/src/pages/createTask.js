import CreateTaskForm from "../components/task/createtaskform";
import {useNavigate, useParams} from "react-router-dom";
import React, {useRef} from "react";


const CreateTask = () => {
    const navigate=useNavigate();
    function createTask(task){
        fetch("http://localhost:9001/task/create_task/", {
            method: 'POST',
            mode: 'cors',
            body: JSON.stringify(task),
            headers: {'Content-Type': 'application/json'}
        }).then((res) => res.json()).
        then((data) => {
            navigate('/board/' + data.id)
            // After you create the task, it will return a task model, which contains the task Id.
            // You need to call the backend method addTask(boardId, taskId) and pass to it the task Id of the one you just create.
            // After it returns successfully, redirect the user back to the board.
        })
    }

    async function addTask(boardId, taskId) {
        // You can await here
        const response = await fetch("http://localhost:9001/board/addTask/" + boardId + "/" + taskId, {
            method: 'PUT',
            mode: 'cors',
            headers: {'Content-Type': 'application/json'}
        });
        var data = await response.json();
        return data;
    }

    return (
        <CreateTaskForm createTask={createTask}/>
    );
}
export default CreateTask;