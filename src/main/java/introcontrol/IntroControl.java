package introcontrol;

public class IntroControl {

    public int substractTenIfGreaterThanTen(int number) {
        if (number<=10) {
            return number;
        }else{
            return number-10;
        }
    }
    public String describeNumber(int number){
        if (number==0){
            return "zero";
        }else{
            return "not zero";
        }
    }
    public String greetingToJoe(String name){
        if (name=="Joe"){
            return "Hello Joe";
        }else{
            return "";
        }
    }
    //... ...

}
