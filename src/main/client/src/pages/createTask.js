
import {useNavigate, useParams} from "react-router-dom";
import React, {useRef} from "react";
import CreateTaskForm from "../components/task/createtaskform";

const CreateTask = () => {
    const navigate = useNavigate();

    async function createTask(boardId ,task){
        const response = await fetch("http://localhost:9001/task/create_task/", {
            method: 'POST',
            mode: 'cors',
            body: JSON.stringify(task),
            headers: {'Content-Type': 'application/json'}
        });
        var data = await response.json();
        console.log(data);
        if (data.object !== undefined){
            data = await addTaskToBoard(boardId, data.object.id);
            if (data.object !== undefined){
                navigate('/board/' + boardId);
            }
            else if (data.error == undefined) {
                alert(data.error);
            }
            else if (data.message == undefined){
                alert(data.message);
            }
        }
    }

    async function addTaskToBoard(boardId ,taskId){
        const response = await fetch("http://localhost:9001/board/add-task/" + boardId + "/" + taskId, {
            method: 'PUT',
            mode: 'cors',
            headers: {'Content-Type': 'application/json'}
        });
        var data = await response.json();
        console.log(data);
        return data;
    }

    return (
        <CreateTaskForm createTask={createTask}/>
    );
}
export default CreateTask;