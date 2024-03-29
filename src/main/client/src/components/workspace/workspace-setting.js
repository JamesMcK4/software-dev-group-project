import {Button, Form } from 'react-bootstrap';

const WorkspaceSetting = ({workspace}) => {

    async function handleInput(e) {
        e.preventDefault();
        var name = e.target.name.value;
        var description = e.target.description.value;
        console.log(name);
        console.log(description);
        if (workspace.id !== undefined){
            if (name !== ""){
                workspace.name = name;
            }
            if (description !== ""){
                workspace.description = description;
            }
            var data = await updateWorkspace(workspace);
            if (data.object != "error"){
                alert("Workspace updated! Workspace name is " + data.object.name + " .Description is " + data.object.description);
                window.location.reload(false);
            }
            else{
                alert("Fail to update workspace.");
            }
        }
    };

    async function updateWorkspace(workspace){
        const response = await fetch("http://localhost:9001/workspace/update_workspace", {
            method: 'PUT',
            mode: 'cors',
            body: JSON.stringify(workspace),
            headers: {'Content-Type': 'application/json'}
        })
        var data = await response.json();
        return data;
    }

    return (
        <Form onSubmit={handleInput}>
        <Form.Group className="mb-3" controlId="formWorkspaceName">
            <Form.Label>Name</Form.Label>
            <Form.Control type="text" placeholder={workspace.name === undefined? "workspace name": workspace.name} name="name"/>
        </Form.Group>
        <Form.Group className="mb-3" controlId="formWorkspaceDescription">
            <Form.Label>Description</Form.Label>
            <Form.Control type="text" placeholder={workspace.description === undefined? "workspace description": workspace.description} name="description"/>
        </Form.Group>
        <Button variant="warning" type="submit">
            Change
        </Button>
        </Form>
    )
}
export default WorkspaceSetting;