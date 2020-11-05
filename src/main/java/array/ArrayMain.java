package array;

public class ArrayMain {
    public static void main(String[] args) {

        String[] week= {"hétfő", "kedd", "szerda", "csütörtök", "péntek", "szombat", "vasárnap"};
        System.out.println(week[1]);
        System.out.println(week.length);

        int[] hatv= new int[5];
        for(int i=0; i<5; i++){

            hatv[i]= (int) Math.pow(2,i);
            /*
            if (i==0){
                hatv[i]= 1;
            }else{
                hatv[i]= hatv[i-1]*2;
            }
            */
        }

        boolean[] ih= new boolean[6];
        for (int i=0; i<6; i++){
            if (i%2==0){
                ih[i]=false;
            }else{
                ih[i]=true;
            }
        }
        for (boolean item: ih
             ) {
            System.out.println(item);
        }
    }
}
