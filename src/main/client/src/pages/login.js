import LoginForm from '../components/user-management/loginform';



function LoginPage(){
    
    return(
        <div>
            <h1>Login!</h1>
            <LoginForm loginUser={loginUserHandler} />
        </div>
    );
}

export default LoginPage;