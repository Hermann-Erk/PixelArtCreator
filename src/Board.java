import java.awt.*;

/**
 * Created by Hermann on 10.08.2018.
 */
public class Board {

    public Color[][] board = new Color[14][14];

    public Board(){
        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 14; j++) {
                board[i][j] = Color.BLACK;
            }
        }

    }

    public void setColorToPixel(int column, int row, Color color){
        this.board[column][row] = color;
    }

    public Color getColorToPixel(int column, int row){
        return board[column][row];
    }

    public void reset(){
        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 14; j++) {
                board[i][j] = Color.BLACK;
            }
        }
    }


}
