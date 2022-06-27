import { useHistory } from 'react-router-dom';
import LoginForm from '../components/user-management/loginform';



function LoginPage(){

    const history = useHistory();

    function loginUserHandler(user){
        fetch('http://localhost:3000/user/save_user')
        .then(() => { 
            //remember to validate
            history.replace('/home')});
    }




    return(
        <div>
            <h1>Login!</h1>
            <LoginForm loginUser={loginUserHandler} />
        </div>
    );
}

export default LoginPage;