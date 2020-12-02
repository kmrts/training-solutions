package week06d03;

public class WordEraser {

    //legyen egy eraseWord(String words, String word) metódus, mely az első paraméter szöveget úgy változtatja meg,
    // hogy a második paraméter összes előforulását kitörli belőle.
    // A words paraméterben a szavak szóközzel vannak elválasztva.
    // metódus térjen vissza a törölni kívánt szavak nélküli Stringgel. (Mellőzzük a replace és replaceAll használatát)

    public String eraseWord(String words, String word){
        if(words==null){  // word==null ||
            throw new NullPointerException("could not be null");
        }
        String[] wordArr= words.split(" ");
        StringBuilder sb= new StringBuilder();
        for(int i=0; i<wordArr.length; i++){
            if(!wordArr[i].equals(word) && !wordArr[i].isBlank()){  //2. felt kellett
                sb.append(wordArr[i]);  //.trim() nem kellett a több szóköz ellen
                if(i!=wordArr.length-1){
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }
}
