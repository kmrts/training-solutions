package classstructureconstructors;

public class Store {
    private String product;
    public int stock;

    public Store(String product) {
        this.product = product;
        this.stock= 0;
    }
    public void store(int store){
        stock= stock + store;
    }
    public void dispatch(int dispatch){
        stock= stock - dispatch;
    }
}
