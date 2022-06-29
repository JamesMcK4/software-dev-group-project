import { useHistory } from "react-router-dom";
import RegisterForm from "../components/user-management/regform";

function RegisterPage(){

    const history = useHistory();

    function registerUserHandler(user){
        fetch("http://localhost:3000/user/save_user", {
            method: 'POST',
            body: JSON.stringify(user),
            headers: {'Content-Type': 'application/json'}
        }).then(() => history.push('/login'));
        
    }
    return (
        <div>
            <RegisterForm registerUser={registerUserHandler}/>
        </div>
    );

}

export default RegisterPage;