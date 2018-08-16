import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Hermann on 10.08.2018.
 */
public class ColorPanelMouseListener implements MouseListener {
    private ColorPanel buttonGrid;

    public ColorPanelMouseListener(ColorPanel buttonGrid){
        this.buttonGrid =  buttonGrid;
    }

    public void mouseEntered(MouseEvent e){

    }

    public void mouseExited(MouseEvent e){

    }

    public void mousePressed(MouseEvent e){
        for (int i=0; i<PixelArtCreator.colorPanelAccuracy;i++){
            for(int j=0;j<PixelArtCreator.colorPanelAccuracy;j++){
                if(e.getSource() == buttonGrid.squares[i][j]){
                    PixelArtCreator.changeCurrentColor(buttonGrid.squares[i][j].getBackground());
                }
            }
        }
    }

    public void mouseClicked(MouseEvent e){

    }

    public void mouseReleased(MouseEvent e){

    }

}
