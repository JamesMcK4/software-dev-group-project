import { useState, setState } from 'react';
import { useNavigate } from 'react-router-dom';

const Component = ({property}) => {
    const [stateVariable, setStateVariableName] = useState("default");

    const navigate = useNavigate()

    const handleOnChange = (e) => {
        setStateVariableName(e.target.value)
    }

    const handleOnClick = (e) => {
        navigate('/')
    }
    return (
        <>    
        <p>{stateVariable}</p>
        <input type="text" onChange={handleOnChange}></input>
        <button onClick={handleOnClick}>Register Form</button>
        </>
    )
}

// Properties - passed from one component to another. State - characteristics of a component.
// Cannot have two tags in parallel in the return statement.
export default Component;