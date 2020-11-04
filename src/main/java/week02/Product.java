package week02;

public class Product {
    private String name;
    private String code;

    public Product(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
    public boolean areTheyEqual(Product p){
        return name.equals( p.name);
    }
    public boolean areStrictEqual(Product p){
        return code.length() == p.code.length();

    }

    public static void main(String[] args) {
        Product prod1 = new Product("deszka", "12345");
        Product prod2 = new Product("bödön", "12377");
        Product prod3 = new Product("deszka", "123441");

        System.out.println(prod1.areTheyEqual(prod3));
        System.out.println(prod2.areTheyEqual(prod3));

        System.out.println(prod1.areStrictEqual(prod2));
        System.out.println(prod1.areStrictEqual(prod3));
    }
    }

