package week04;

public class NameChanger {
    private String fullName;

    public NameChanger(String fullName) {
        if(fullName==null || "".equals(fullName)){  //isBlank..  .trim()
            throw new IllegalArgumentException("Illegal name:"+fullName);
        }
        this.fullName = fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void changeFirstName(String firstName){
        String newS= getFullName().substring(0, getFullName().indexOf(' ')+1); //split()
        setFullName(newS.concat(firstName));
    }
    public boolean isTheSame(String otherFullName){
        return fullName.equals(otherFullName);
    }
}
