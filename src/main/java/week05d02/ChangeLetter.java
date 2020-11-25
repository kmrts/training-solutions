package week05d02;

public class ChangeLetter {


//    írj meg egy String changeVowels(String) metódust, mely kicseréli a paraméterként átadott szövegben
//    az angol magánhangzókat csillag karakterre. Írj hozzá teszteseteket is!
    public  static final String VOWS= "AEIOUaeiou";

    public String changeVowels(String input){

        StringBuilder sb= new StringBuilder();

        for(int i=0; i<input.length(); i++){
//        for(char item: input){
            String nextVow= input.substring(i, i+1);
            if(VOWS.contains(nextVow)){
                sb.append('*');

            }else{
                sb.append(nextVow);
            }
        }
        return sb.toString();
    }
//    public static void main(String[] args) {
//        ChangeLetter c= new ChangeLetter();
//
//        System.out.println(c.changeVowels("FARAMUCI"));
//    }
}
