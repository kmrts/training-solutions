package stringtype.registration;

public class UserValidator {
    public boolean isValidUsername(String username){
        return !(username.equals(""));
    }
    public boolean isValidPassword(String password1, String password2){
        return password1.equals(password2);
    }
    public boolean isValidEmail(String email){
        return email.contains("@") && email.contains(".")
                && email.indexOf("@")+1< email.indexOf(".")
                && email.indexOf("@")>0 && email.indexOf(".")<email.length()-1;
    }
}
