import java.util.Random;

/**
 * Created by DG on 09.03.2017.
 */
public class InflateData {
    private Integer[] data;

    public Integer[] getIntData(int value){
        Random r;
        data =new Integer[value];
        for (int i = 0; i < value; i++) {
            data[i]=50-new Random().nextInt(100);
        }
        return data;
    }

}
