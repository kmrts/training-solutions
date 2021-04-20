package week05d03.senior;

import java.util.List;

public class UserValidator {

    public boolean validate(List<User> users){
        boolean res= false;
        if(users==  null){
            throw new IllegalArgumentException("list is null");
        }
//        if(users.contains(null)){
//            throw new NullPointerException("user is null");
//        }
        for(User user: users){
//            if(user== null){
//                throw new NullPointerException("user is null");
//            }
            if(user.getName()==null || user.getName().isEmpty()){
                throw new IllegalArgumentException("name is null or empty");
            }
            if(user.getAge()<0 || user.getAge()>120){
                throw new IllegalArgumentException("age should be 0-120");
            }
        }
        res= true;
        return res;

    }
}
