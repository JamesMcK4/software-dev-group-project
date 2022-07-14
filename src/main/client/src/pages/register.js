import RegisterForm from "../components/user-management/regform";

function RegisterPage(){
    
    return (
        <div>
            <RegisterForm registerUser={registerUserHandler}/>
        </div>
    );

}

export default RegisterPage;