package week06d01.senior;

public class SeparatedSum {
    /*
    Írj egy SeparatedSum.sum(String s) metódust, mely kap egy String-et, melyben lebegőpontos számok szerepelnek
    pontosvesszővel elválasztva.
    A számoknál vessző a tizedeselválasztó.
    Ezt szétszedi, és összeadja külön a pozitív és külön a negatív számokat.
    Mivel térnél vissza ebből a metódusból?
     */
    public NumPair sum(String s){
        String[] parts= s.split(";");
        double sumNeg= 0;
        double sumPos= 0;

        for(int i=0; i<parts.length; i++){
            String next= parts[i].replace(",", ".");
            double nextNum= Double.parseDouble(next);
            if(nextNum>= 0){
                sumPos+= nextNum;
            }else{
                sumNeg+= nextNum;
            }
        }
        return new NumPair(sumNeg, sumPos);
    }
}
