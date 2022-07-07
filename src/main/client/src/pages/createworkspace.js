import CreateWorkspaceForm from "../components/workspace/createworkspaceform";

import {useNavigate} from "react-router-dom";
import React, {useRef} from "react";
const CreateWorkspace = () => {
    const navigate=useNavigate();

    function createWorkspace(workspace){
        fetch("http://localhost:9001/workspace/save_workspace", {
            method: 'POST',
            mode: 'cors',
            body: JSON.stringify(workspace),
            headers: {'Content-Type': 'application/json'}
        }).then((res) => res.json()).
        then((data) => {
            navigate('/workspace/' + data.id)
        });
    }

    return (
        <CreateWorkspaceForm createWorkspace={createWorkspace}/>
      );
}
export default CreateWorkspace ;