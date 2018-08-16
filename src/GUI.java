import javax.swing.*;
import java.awt.*;

/**
 * Created by Hermann on 10.08.2018.
 */
public class GUI extends JFrame {
    private MenuPanel menuPanel;
    private ButtonGrid buttonGrid;
    private ColorPanel colorPanel;
    // Screen size is in capital letters due to its constant behaviour
    private Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    private final int CONTROL_PANEL_HEIGHT = 120;

    public GUI(Board board) {
        super("PixelArt Editor");
        this.initializeWindow();
        PixelArtCreator.setActionListener(new PixelArtActionListener(this));
        buttonGrid = new ButtonGrid(SCREEN_SIZE,CONTROL_PANEL_HEIGHT,board);
        this.getContentPane().add(buttonGrid);
        menuPanel = new MenuPanel(SCREEN_SIZE.width,CONTROL_PANEL_HEIGHT);
        this.getContentPane().add(menuPanel);
        int boardHeight = SCREEN_SIZE.height - CONTROL_PANEL_HEIGHT - 80;
        colorPanel = new ColorPanel(CONTROL_PANEL_HEIGHT,boardHeight);
        this.getContentPane().add(colorPanel);


        this.pack();
        this.setVisible(true);
    }

    private void initializeWindow(){
        this.setLayout(null);
        this.setPreferredSize(SCREEN_SIZE);
        // TODO Windowlistener?
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(true);	// for now...
        // TODO custom cursor?
    }

    public ButtonGrid getButtonGrid(){
        return buttonGrid;
    }
}
