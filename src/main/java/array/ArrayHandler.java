package array;

public class ArrayHandler {

    public boolean contains(int[] source, int itemToFind){
        for (int item: source
             ) {
            if (item == itemToFind) {
                return true;
            }
        }
        return false;
    }
    public int find(int[] source, int itemToFind){
        for (int i=0; i<source.length; i++) {
            if (source[i] == itemToFind) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {

        ArrayHandler ah= new ArrayHandler();
        int[] a={1,3,6,55};

        System.out.println(ah.contains(a,6));

        System.out.println(ah.find(a, 55));


    }

}
