package controlselection.accents;

public class WithoutAccents {
    public static final String ACC = "áéíóőúű";

    public char withoutA (char c) {
        switch (c){
            case 'á':
                    return 'a';
                case 'é':
                    return 'e';
                case 'í':
                    return 'i';
                case 'ó':
                case 'ő':
                    return 'o';
                case 'ú':
                case 'ű':
                    return 'u';
                default:
                    return c;
            }
    }
//      "áéíóöőúüűÁÉÍÓÖŐÚÜŰ";
//      "aeiooouuuAEIOOOUUU";

    public static void main(String[] args) {
        WithoutAccents wa= new WithoutAccents();

        System.out.println(wa.withoutA('ő'));
        System.out.println(wa.withoutA('k'));
        System.out.println(wa.withoutA('e'));
        System.out.println(wa.withoutA('ú'));
    }

}



