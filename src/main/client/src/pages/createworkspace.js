import CreateWorkspaceForm from "../components/workspace/createworkspaceform";

import {useNavigate} from "react-router-dom";
import React, {useRef} from "react";
const CreateWorkspace = () => {
    const navigate=useNavigate();

    function creatWorkspace(workspace){
        fetch("http://localhost:9000/workspace/save_workspace", {
            method: 'POST',
            mode: 'cors',
            body: JSON.stringify(workspace),
            headers: {'Content-Type': 'application/json'}
        }).then(() =>navigate('/workspace/1'));
    }

    return (
        <CreateWorkspaceForm creatWorkspace={creatWorkspace}/>
      );
}
export default CreateWorkspace ;