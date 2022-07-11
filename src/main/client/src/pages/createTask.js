
import {useNavigate} from "react-router-dom";
import React, {useRef} from "react";
import CreateTaskForm from "../components/task/createtaskform";
const CreateTask = () => {
    const navigate=useNavigate();

    function createTask(task){
        fetch("http://localhost:9001/task/save_task", {
            method: 'POST',
            mode: 'cors',
            body: JSON.stringify(task),
            headers: {'Content-Type': 'application/json'}
        }).
        then(() => {
            navigate('/create-workspace' )
        });
    }

    return (
        <CreateTaskForm createWorkspace={createTask}/>
    );
}
export default CreateTask ;