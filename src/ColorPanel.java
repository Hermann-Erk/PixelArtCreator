import javax.swing.*;
import java.awt.*;

/**
 * Created by Hermann on 10.08.2018.
 */
public class ColorPanel extends JPanel {
    public JButton squares[][] = new JButton[PixelArtCreator.colorPanelAccuracy][PixelArtCreator.colorPanelAccuracy];

    public ColorPanel(int CONTROL_PANEL_HEIGHT, int boardHeigt){
        PixelArtCreator.panelMouseListener = new ColorPanelMouseListener(this);
        this.initializeWindow(CONTROL_PANEL_HEIGHT,boardHeigt);
        this.initializeContent();
    }

    public void initializeWindow(int CONTROL_PANEL_HEIGHT,int boardHeight){
        this.setLayout(new GridLayout(PixelArtCreator.colorPanelAccuracy,PixelArtCreator.colorPanelAccuracy));
        this.setBounds(boardHeight + 30, CONTROL_PANEL_HEIGHT, boardHeight/2, boardHeight/2);
        this.setVisible(true);
    }

    public void initializeContent(){
        for (int i = 0; i < PixelArtCreator.colorPanelAccuracy; i++) {
            for (int j = 0; j < PixelArtCreator.colorPanelAccuracy; j++) {
                squares[i][j] = new JButton();
                squares[i][j].addMouseListener(PixelArtCreator.panelMouseListener);

                squares[i][j].setBackground(Color.getHSBColor((float) ((i*PixelArtCreator.colorPanelAccuracy+j)/
                        (float) (PixelArtCreator.colorPanelAccuracy*PixelArtCreator.colorPanelAccuracy)),
                        1,1));

                this.add(squares[i][j]);
            }
        }

        squares[PixelArtCreator.colorPanelAccuracy-1][PixelArtCreator.colorPanelAccuracy-1].setBackground(Color.BLACK);
    }

}
