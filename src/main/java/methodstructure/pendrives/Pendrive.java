package methodstructure.pendrives;

public class Pendrive {
    //    attribútumai: name, capacity, price. A kapacitás egész szám Gb-ben megadott érték.
    //    Az ár egész szám forintban megadott érték.
    //    Legyenek getterei az attribútumokra.
    //    Legyen String toString() metódusa, amely egy Stringbe összefűzve adja vissza a pendrive adatait.
    //    Legyen void risePrice(int percent) metódusa, amely megadott százalékkal megemeli a pendrive árát.
    //    Legyen int comparePricePerCapacity(Pendrive) metódusa, amely összehasonlítja a példányt
    //    egy paraméterként kapott másik példánnyal az ár/kapacitás alapján.
    //    Az eredmény 1 legyen, ha az aktuális példány ár/kapacitása nagyobb, az eredmény -1 legyen
    //    ha a paraméterként kapott példányé nagyobb, és az eredmény 0 legyen, ha egyformák.
    //    Legyen egy boolean cheaperThan(Pendrive) metódusa, amely igazat ad ha a példány ára kisebb,
    //    mint a paraméterben kapott példány ára.
    private String name;
    private int capacity;
    private int price;

    public Pendrive(String name, int capacity, int price) {
        this.name = name;
        this.capacity = capacity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Pendrive{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", price=" + price +
                '}';
    }
    public void risePrice(int percent){
        price= price* (100+percent) /100;
    }
    public int comparePricePerCapacity(Pendrive otherPen){
        if(pricePerCapacity()> otherPen.pricePerCapacity()){
            return 1;
        }else if(pricePerCapacity()< otherPen.pricePerCapacity()){
            return -1;
        }else{
            return 0;
        }

    }
    public double pricePerCapacity(){
        return (double)getPrice()/ getCapacity();   //int ről double-ra
    }
    public boolean cheaperThan(Pendrive otherPen){
        return price< otherPen.price;
    }

        }
