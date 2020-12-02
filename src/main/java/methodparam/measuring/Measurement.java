package methodparam.measuring;

public class Measurement {

    private double[] measuring;

    public Measurement(double[] measuring) {
        this.measuring = measuring;
    }
    public int findFirstIndexInLimit(int lower, int upper){
        for(int i=0; i<measuring.length; i++){
            if(measuring[i] >lower && measuring[i] <upper){
                return i;
            }
        }
        return -1;
    }
    public double minimum(){
        double min= Double.MAX_VALUE;
        for(int i=0; i<measuring.length; i++){
            if(measuring[i] < min){
                min= measuring[i];
            }
        }
        return min;
    }

    public double maximum(){
        double max= Double.MIN_VALUE;
        for(int i=0; i<measuring.length; i++){
            if(measuring[i] > max){
                max= measuring[i];
            }
        }
        return max;
    }
    public ExtremValues minmax(){

        return new ExtremValues(minimum(), maximum());
    }
}
