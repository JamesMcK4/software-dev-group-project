import { useNavigate } from 'react-router-dom';
import LoginForm from '../components/user-management/loginform';



function LoginPage(){

    const nav = useNavigate();

    function loginUserHandler(user){
        fetch('http://localhost:9000/user/save_user', {
            method: 'Get',
            body: JSON.stringify(user),
            headers: {'Content-Type': 'application/json'}
        }).then(() => nav('../home'));
    }




    return(
        <div>
            <h1>Login!</h1>
            <LoginForm loginUser={loginUserHandler} />
        </div>
    );
}

export default LoginPage;