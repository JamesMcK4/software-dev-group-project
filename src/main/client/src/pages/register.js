import { useHistory } from "react-router-dom";
import RegisterForm from "../components/user-management/regform";

function RegisterPage(){

    const history = useHistory();

    function registerUserHandler(user){
        fetch("http://localhost:3003/user/save_user", {
            method: 'POST',
            body: JSON.stringify(user),
            headers: {'Content-Type': 'application/json'}
        }).then(() => history.replace('/login'));
    }
    return (
        <div>
            <RegisterForm registerUser={registerUserHandler}/>
        </div>
    );

}

export default RegisterPage;