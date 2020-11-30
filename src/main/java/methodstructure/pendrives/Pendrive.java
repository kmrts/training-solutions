package methodstructure.pendrives;

public class Pendrive {

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
