import React from 'react';
import { useState, setState } from 'react';
import './style.css';


function RegisterForm(){

    //set constants/values for each section of form to be able to use states properly
    const [firstName, setFirstName] = useState(null);
    const [lastName, setLastName] = useState(null);
    const [email, setEmail] = useState(null);
    const [password, setPassword] = useState(null);

    //making an input handler to deal with all the inputs - e representing the event.
    //Using a bunch of if statements in order to capture all the different sections
    const inputHandler = (e) =>{
        const {id, value} = e.target;
        if(id==="firstName"){
            setFirstName(value);
        }
        if(id==="lastName"){
            setLastName(value);
        }
        if(id==="email"){
            setEmail(value);
        }
        if(id==="password"){
            setPassword(value);
        }

        const submissionHandler = () => {
            console.log(firstName, lastName, email, password)
        }

        
    }



    return(
        <><div className="form">
            <div className="form-body">
                <div className="username">
                    <label className="form__label" for="firstName">First Name</label>
                    <input className="form__input" type="text" id="firstName" placeholder="First Name" />
                </div>

                <div className="lastname">  
                    <label className="form__label" for="lastName">Last Name</label>
                    <input className="form__input" type="text" id="lastName" placeholder="Last Name" />
                </div>

                <div className="email">
                    <label className="form__label" for="email">Email</label>
                    <input className="form__input" type="email" id="email" placeholder="Email" />
                </div>

                <div className="password">
                    <label className="form__label" for="password">Password</label>
                    <input className="form__input" type="password" id="password" placeholder="Email" />
                </div>

            </div>
        </div><div class="footer">
                <button type="submit" class="btn">Submit</button>
            </div></>
        
    );
}

export default RegisterForm;