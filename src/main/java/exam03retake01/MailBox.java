package exam03retake01;

import java.util.ArrayList;
import java.util.List;

public class MailBox {
    /*
    Egy levelet egy Mail osztály tárol, a következő attribútumokkal: feladó, címzettek, tárgy és szöveg.
    A feladót és a címzetteket egy Contract tárol, melynek két attribútuma van: viselt név és e-mail cím.
    A MailBox tárolja a leveleket egy Mail listában. Ennek legyen egy findByCriteria() metódusa,
    mely paraméterként egy keresési feltételt vár, és leveleket ad vissza.

A keresési feltételek lehetnek:
from:John Doe vagy from:johndoe@example.com - from: előtaggal visszaadja az összes olyan levelet,
ahol a feladó neve vagy e-mail címe pontosan a from: után szereplő szöveg
to:John Doe vagy to:johndoe@example.com - from: előtaggal visszaadja az összes olyan levelet,
ahol a címzettek között szerepel olyan, akinek a neve vagy e-mail címe pontosan a to: után szereplő szöveg
egyéb esetben visszaadja az összes olyan levelet, amiben szerepel a tárgyban vagy üzenetben a megadott szó
     */
    private List<Mail> mails = new ArrayList<>();

    public List<Mail> getMails() {
        return mails;
    }

    public void addMail(Mail mail) {
        mails.add(mail);
    }

    public List<Mail> findByCriteria(String criteria) {
        List<Mail> result = new ArrayList<>();

        if (criteria.contains(":")) {
            String[] splt = criteria.split(":");
            String pre = splt[0];
            String find = splt[1];
            return findIfFromOrTo(pre, find);
        } else {
            return findSimple(criteria, result);
        }

    }

    private List<Mail> findSimple(String criteria, List<Mail> result) {
        for (Mail mail : mails) {
            if (mail.getSubject().contains(criteria) || mail.getMessage().contains(criteria)) {
                result.add(mail);
            }
        }
        return result;
    }

    private List<Mail> findIfFromOrTo(String pre, String find) {

        List<Mail> result = new ArrayList<>();
        for (Mail mail : mails) {
            if ("from".equals(pre)) {
                if (mail.getFrom().getName().equals(find) || mail.getFrom().getEmail().equals(find)) {
                    result.add(mail);
                }
            }
            if("to".equals(pre)){
                for(Contact con: mail.getTo()){
                    if(con.getName().equals(find) || con.getEmail().equals(find)){
                        result.add(mail);
                    }
                }
            }
        }
        return result;
    }


}
