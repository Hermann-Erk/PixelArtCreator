import java.awt.*;

/**
 * Created by Hermann on 10.08.2018.
 */
public class BoardTransformerWS2812B {

    public static int[] transformToIntArray(Color[][] board){
        int[] intArray = new int[3*14*14];

        for(int i = 0; i < 14; i++){
                for(int j = 0; j<14;j++){
                    intArray[i*14*3+j*3] = board[i][j].getRed();
                    intArray[i*14*3+j*3+1] = board[i][j].getGreen();
                    intArray[i*14*3+j*3+2] = board[i][j].getBlue();
                }
        }

        return intArray;
    }

    public static void printIntArray(int[] intArray){
        System.out.print("\n");
        for(int i = 0; i < 14; i++){
            System.out.print("{");
            for(int j = 0; j < 14; j++){
                System.out.print("{");
                for(int k = 0; k < 3; k++){
                    System.out.print(intArray[i*14*3+j*3+k+4] + " ");
                }
                System.out.print("}");
            }
            System.out.print("}\n");
        }
        System.out.println("------------------------End");
    }
}
