package nyc.esteban.pace_hw_class_6;

import android.graphics.Color;

/**
 * Created by Spoooon on 11/9/2014.
 */
public class RandomColorGenerator {

    public static int getRandomColor(){
        int rand = (int)(Math.random() * 5);
        int color =0;
        switch(rand){

            case 0: color = Color.WHITE;
                break;
            case 1: color = Color.BLUE;
                break;
            case 2: color = Color.RED;
                break;
            case 3: color = Color.GREEN;
                break;
            case 4: color = Color.YELLOW;
                break;
            case 5: color = Color.MAGENTA;
                break;
        }

        return color;
    }


}
