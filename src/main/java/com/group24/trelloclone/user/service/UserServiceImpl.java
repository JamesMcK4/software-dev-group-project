import com.group24.trelloclone.exception.EmptyPasswordException;
import com.group24.trelloclone.exception.InvalidCredentialsException;
import com.group24.trelloclone.exception.InvalidUserIdException;
import com.group24.trelloclone.user.model.UserModel;
import com.group24.trelloclone.user.repository.UserRepository;
import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.*;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserModel addUser(UserModel UserModel)
    {
        return userRepository.save(UserModel);
    }

    @Override
    public UserModel getUserById(Long userId)
    {
        UserModel user = null;
        Optional<UserModel> optionalUser = userRepository.findById(userId);
        if(optionalUser.isPresent())
        {
            user = optionalUser.get();
        }
        return user;
    }

    @Override
    public List<UserModel> getAllUsers()
    {
        return userRepository.findAll();
    }

    @Override
    public UserModel getUserByEmailId(String emailId) throws InvalidCredentialsException {

        UserModel user = userRepository.findByEmailId(emailId);;

        return user;
    }

    @Override
    public boolean deleteAllUsers(){
        userRepository.deleteAll();
        if (userRepository.count()==0){
            return true;
        }
        return false;
    }

    @Override
    public boolean validateUser(String emailId, String password) throws EmptyPasswordException, InvalidCredentialsException {

        UserModel user = null;
        Optional<UserModel> optionalUser = Optional.ofNullable(userRepository.findByEmailId(emailId));

        if(!optionalUser.isPresent()){
           throw new InvalidCredentialsException();
        }
        else {
            user = optionalUser.get();
        }
        if(user.getPassword() != password){
            throw new InvalidCredentialsException();
        }
        else{
            return true;
        }

    }

    @Override
    public UserModel deleteUser(Long userId) throws InvalidUserIdException {

        Optional<UserModel> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            throw new InvalidUserIdException();
        }
        else{
            userRepository.deleteById(userId);
        }


        return null; //not sure what to return here since its a delete, maybe change to void?
    }
   @Override
    public boolean updatePassword(Long userId, String password) throws EmptyPasswordException, InvalidUserIdException {

        String newPassword = "";
        Optional<UserModel> optionalUser = userRepository.findById(userId);
        UserModel user = null;
        if(optionalUser.isEmpty()){
            throw new InvalidUserIdException();
        }
        else{
            user = optionalUser.get();
        }
        if(!user.getPassword().equals(password)){
            throw new EmptyPasswordException();
        }

        else{
		    user.getPassword() = user.setPassword();//something here..
        }
        return false;
    }//NOT SURE I WANNA USE THIS ONE

    /*
    public void resetPasswordToken(String email) throws InvalidCredentialsException {

        UserModel user = userRepository.findByEmailId(email);
        if(user != null){
            //SOMETHING HERE
            userRepository.save(user); //not sure if its save or addUser****
        }
        else{
            throw new InvalidCredentialsException();
        }
    }

    public UserModel getResetPasswordToken(String token){
        return userRepository.findResetPassword(token);
    }

    public void updatePassword (UserModel user, String newPassword){

        user.setPassword(newPassword);
        user.setResetPasswordToken(null);
        userRepository.save(user);
    }
*/
    public boolean validatePassword(String password){

        String regexpression = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";

        //use Pattern class to compile the regular expression to later use for matching
        Pattern regPattern = Pattern.compile(regexpression);

        //check if password is empty
        if(password == null){
            return false;
        }

        //setup matcher from Pattern class to check regex against password
        Matcher matcher = regPattern.matcher(password);

        return matcher.matches();
    }
}