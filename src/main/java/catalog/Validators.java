package catalog;

import java.util.List;

public class Validators {
    //Létre kell hozni egy isBlank() és isEmpty() statikus metódust,
    // az egyik egy Stringről vizsgálja meg, null vagy üres-e, a másik egy listáról dönti el, hogy null vagy üres-e.
    // Ezeket a metódusokat használhatjuk a metódusok paramétereinek ellenőrzésekor.
    public static boolean isBlank(String s){

        return s==null || s.trim().equals("") ? true : false; //ford nem, equals nem hívh. null-nál
    }
    static boolean isEmpty(List list){ //public
        return list==null || list.size()==0 ? true : false; //ford nem, size() és equals() nem hívható null nál

    }
}
