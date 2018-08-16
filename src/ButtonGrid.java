import javax.swing.*;
import java.awt.*;

/**
 * Created by Hermann on 10.08.2018.
 */
public class ButtonGrid extends JPanel {
    public JButton squares[][] = new JButton[14][14];
    private int boardHeight;
    private Board board;

    public ButtonGrid(Dimension SCREEN_SIZE, int CONTROL_PANEL_HEIGHT, Board board){
        boardHeight = SCREEN_SIZE.height - CONTROL_PANEL_HEIGHT - 80;
        this.initializeWindow(CONTROL_PANEL_HEIGHT);
        this.board = board;
        PixelArtCreator.setMouseListener(new ButtonGridMouseListener(board,this));

        this.initializeContent();
    }

    public void initializeWindow(int CONTROL_PANEL_HEIGHT){
        this.setLayout(new GridLayout(14,14));
        this.setBounds(0, CONTROL_PANEL_HEIGHT, boardHeight, boardHeight);
        this.setVisible(true);
    }

    public void initializeContent(){

        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 14; j++) {
                squares[i][j] = new JButton();
                squares[i][j].addMouseListener(PixelArtCreator.mouseListener);

                squares[i][j].setBackground(Color.BLACK);

                this.add(squares[i][j]);
            }
        }


    }


    public void paintComponent(Graphics og){
        super.paintComponent(og);
        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 14; j++) {
                squares[i][j].setBackground(board.getColorToPixel(j,i));
            }
        }

    }

}
