package controliteration.pi;

public class PiGenerator {

    private static final String PI_VERS ="Nem a régi s durva közelítés,\n" +
            "mi szótól szóig így kijön\n" +
            "betűiket számlálva.\n" +
            "Ludolph eredménye már,\n" +
            "ha itt végezzük húsz jegyen.\n" +
            "De rendre kijő még tíz pontosan,\n" +
            "Azt is bízvást ígérhetem.";

    public String Pi(){
//        int count= 0;
//        boolean newWord= true;
        int digit=0;
        String piString= "";
        for(int i=0; i < PI_VERS.length(); i++){
            if(Character.isAlphabetic(PI_VERS.charAt(i) ) ){
                digit++;
            }else{
                if(piString.length()==1){
                    piString+= '.';
                }
                if(digit!=0){
                    piString = piString+ Integer.toString(digit);
                }
                digit= 0;
            }
        }
        return piString;
    }

    public static void main(String[] args) {

        PiGenerator pg=  new PiGenerator();
//        System.out.println(PI_VERS);

        System.out.println(pg.Pi());






    }
}
