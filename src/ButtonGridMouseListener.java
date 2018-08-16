import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Created by Hermann on 10.08.2018.
 */
public class ButtonGridMouseListener implements MouseListener {
    private Board board;
    private ButtonGrid buttonGrid;

    public ButtonGridMouseListener(Board board,ButtonGrid buttonGrid){
        this.board = board;
        this.buttonGrid =  buttonGrid;
    }

    public void mouseEntered(MouseEvent e){

    }

    public void mouseExited(MouseEvent e){

    }

    public void mousePressed(MouseEvent e){
        for (int i=0; i<14;i++){
            for(int j=0;j<14;j++){
                if(e.getSource() == buttonGrid.squares[i][j]){
                    board.setColorToPixel(j,i,PixelArtCreator.currentColor);
                }
            }
        }
    }

    public void mouseClicked(MouseEvent e){

    }

    public void mouseReleased(MouseEvent e){

    }

}
