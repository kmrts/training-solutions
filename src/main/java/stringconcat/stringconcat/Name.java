package stringconcat.stringconcat;

public class Name {
    private String familyName;
    private String middleName;
    private String givenName;
    private Title title;

    // ez miért?
    public Name(String familyName, String middleName, String givenName, Title title) {
        this(familyName, middleName, givenName);  ////
        this.title = title;
    }

    public Name(String familyName, String middleName, String givenName) {

        if(isEmpty(familyName)){
            throw new IllegalArgumentException("Családi név megadása kötelező");
        }
        if(isEmpty(givenName)){
            throw new IllegalArgumentException("Keresztnév megadása kötelező");
        }
        this.familyName = familyName;
        this.middleName = middleName;
        this.givenName = givenName;
        this.title = title;


    }

    public String concatNameWesternStyle(){
        String s;
        if(title==null){
            s= givenName;
        }else{
            s= title.getTitleString();
            s+= " "+givenName;
        }
        s+=" ";
        if(middleName!=null && !"".equals(middleName)){
            s+=middleName+ " ";
        }
        s+=familyName;
        return s;

    }
    public String concatNameHungarianStyle(){
        String s;
        if(title==null){
            s= familyName;
        }else{
            s= title.getTitleString();
            s= s.concat(" ");
            s= s.concat(familyName);
        }
        s= s.concat(" ");
        if(middleName!=null && !"".equals(middleName)){
            s= s.concat(middleName);
            s= s.concat(" ");
        }
        s= s.concat(givenName);
        return s;

    }

    public boolean isEmpty(String input){
        if(input==null || input.isEmpty()){
            return true;
        }
        return false;

    }


}
