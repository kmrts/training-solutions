package collectionsmap;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class LogParser {
    /*
    Gyűjtsd ki az ugyanahhoz az IP-címhez tartozó napló bejegyzéseket egy szöveges naplóból.
    A napló sorokban tárolja az adatokat, egy sor egy Entry objektumnak felel meg, IP cím, dátum és login mezőkből áll.
    Írj egy log feldolgozást implementáló osztályt, LogParser néven, amely elvégzi a dátum String konvertálását,
    a sor feldolgozását, és Map-be szortírozását.
    A fő tevékenységet a (parseLog(String log)) metódus végzi, amely egy (Map<String, List<Entry>>) értéket ad vissza.

Hibakezelés
Ha a dátum String nem dolgozható fel, a metódus dobjon egy IllegalArgumentException kivételt.

Ha a parseLog(String log) metódus bemenete olyan String, amely nem dolgozható fel, mint Entry objektum,
szintén IllegalArgumentException kivételt dobjon.

Megvalósítás
A sorfeldolgozáshoz szükséges adatok - elemek száma, pozíciója, mező szeparátor, dátum String formátuma -
statikus final változóként kerüljenek be a LogParser osztályba.

Tippek
Ha a sor nem dolgozható fel, vagy a dátum nem konvertálható, az egész feldolgozást töröljük és kivételt dobunk a probléma megjelölésével.

[rating feedback=java-collectionsmap-naploelemzes]

Ellenőrző kérdés
Mi várható, ha nem HashMap, hanem TreeMap az implementáció? Mikor előnyös egyik, vagy másik?
     */
    private static final int NUM_OF_ELEMENTS = 3;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");  //not mm
    private static final String SEPARATOR = ":";


    public Map<String, List<Entry>> parseLog(String log) {
//        Map<String, List<Entry>> map = new HashMap<>();
//        Scanner sc = new Scanner(log);
//        while (sc.hasNext()) {   //(next = sc.nextLine()) != null
//            Entry nextEntry = makeEntry(sc.nextLine());
//            String key = nextEntry.getIpAddress();
//            List<Entry> entryList = new ArrayList<>();
//            if (map.containsKey(key)) {
//                entryList = map.get(key);
//            }
//            entryList.add(nextEntry);
//            map.put(key, entryList);
//
//        }
//        return map;
        try (Scanner sc = new Scanner(log)) {
            Map<String, List<Entry>> map = new HashMap<>();
            while (sc.hasNext()) {   //(next = sc.nextLine()) != null
                Entry nextEntry = makeEntry(sc.nextLine());
                String key = nextEntry.getIpAddress();
                List<Entry> entryList = new ArrayList<>();
                if (map.containsKey(key)) {
                    entryList = map.get(key);
                }
                entryList.add(nextEntry);
                map.put(key, entryList);

            }
            return map;
        }
    }

    private Entry makeEntry(String line) {
        String[] spl = line.split(SEPARATOR);

        if (spl.length != NUM_OF_ELEMENTS) {
            throw new IllegalArgumentException("Incorrect log: incorrect number of fields");
        }
        try {
            LocalDate date = LocalDate.parse(spl[1], FORMATTER);
            Entry entry = new Entry(spl[0], date, spl[2]);  ///
            return entry;
        } catch (DateTimeParseException ex) {         //not IllegalArgumentExc.
            throw new IllegalArgumentException("Incorrect log: incorrect date", ex);
        }

    }
}
