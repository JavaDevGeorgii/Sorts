import java.util.Arrays;
import java.util.Timer;

public class Main {

    static final int SIZE_ARRAY=7000;

    public static void main(String[] args) {

        Integer[]arr=getNewArrays(SIZE_ARRAY);
        int count=5;
        long bbs=0L;
        long dbbs=0L;
        for (int i = 0; i < count; i++) {
            bbs+=bubbleSort(arr);
            dbbs+=biDirectionBubleSort(arr);
        }
        System.out.println("Avr.delay BubbleSort: "+(bbs/count)+"   biDirectionBubblrSort: "+(dbbs/count));
    }

    public static Integer[] getNewArrays(int s){
        long start=System.nanoTime();
        Integer [] integers=new InflateData().getIntData(s);
        long end=System.nanoTime();
        //System.out.println(Arrays.asList(integers));
        System.out.println("Create Integer["+SIZE_ARRAY+"] have delay msec= "+((end-start)/1000000));
        return integers;
    }


    public static long bubbleSort(Integer[] inputIntegers){
        Integer[] out=inputIntegers.clone();
        //System.out.println("Input  "+Arrays.asList(out));
        long start=System.nanoTime();

        int len=out.length-1;
        Integer tmp;
        for (int i = len; i >0;i--) {
            for (int j = 0; j <i ; j++) {
                if(out[j]>out[j+1]){
                    tmp=out[j];
                    out[j]=out[j+1];
                    out[j+1]=tmp;
                }
            }
        }
        long end=System.nanoTime();
        //System.out.println("Output "+Arrays.asList(out));
        //System.out.println("Output sorted by BubbleSort Integer have delay msec= "+((end-start)/1000000));
        //return out;
        return ((end-start)/1000000);
    }

    public static long biDirectionBubleSort(Integer[] inputIntegers){

        Integer[] out=inputIntegers.clone();
        //System.out.println("Input  "+Arrays.asList(out));
        long start=System.nanoTime();
        int i,j,k;
        k=0;

        int baseNumPos=0;
        int roofNumPos=out.length-1;
        Integer tmp;
        for ( ;roofNumPos >= baseNumPos;) {

            for ( j = baseNumPos; j <roofNumPos ; j++) {
                if(out[j]>out[j+1]){
                    tmp=out[j];
                    out[j]=out[j+1];
                    out[j+1]=tmp;
                }
            }
            roofNumPos--;

            for ( k = roofNumPos; k >baseNumPos ; k--) {
                if(out[k]<out[k-1]){
                    tmp=out[k];
                    out[k]=out[k-1];
                    out[k-1]=tmp;
                }
            }
            baseNumPos++;
        }
        long end=System.nanoTime();
        //System.out.println("Output "+Arrays.asList(out));
        //System.out.println("Output sorted by BiDirectionBubbleSort Integer have delay msec= "+((end-start)/1000000));
        //return out;
        return ((end-start)/1000000);
    }
}
