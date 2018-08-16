import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

/**
 * Created by Hermann on 10.08.2018.
 */
public class MenuPanel extends JPanel {

    public MenuPanel(int width, int height){
        this.initializeWindow(width,height);
        this.initializeContent();
    }

    private void initializeContent(){

        JButton newGameButton = new JButton("New File");
        newGameButton.addActionListener(PixelArtCreator.getActionListener());
        newGameButton.setBounds(10, 10, 100, 40);
        this.add(newGameButton);

        JButton loadingButton = new JButton("Load File");
        loadingButton.addActionListener(PixelArtCreator.getActionListener());
        loadingButton.setBounds(120, 10, 100, 40);
        this.add(loadingButton);

        JButton savingButton = new JButton("Save File");
        savingButton.addActionListener(PixelArtCreator.getActionListener());
        savingButton.setBounds(120, 60, 100, 40);
        this.add(savingButton);

        JTextField redField = new JTextField();
        redField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                int red = Integer.parseInt(redField.getText());
                if (red >= 0 && red <= 255){
                    Color newColor = new Color(red, PixelArtCreator.currentColor.getGreen(),
                            PixelArtCreator.currentColor.getBlue());
                    PixelArtCreator.currentColor = newColor;
                    PixelArtCreator.curColorButton.setBackground(newColor);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
        redField.setBounds(240, 10, 100, 40);
        PixelArtCreator.redField = redField;
        this.add(redField);

        //-----------------------------------------

        JTextField greenField = new JTextField();
        greenField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                int green = Integer.parseInt(greenField.getText());
                if (green >= 0 && green <= 255){
                    Color newColor = new Color(PixelArtCreator.currentColor.getRed(),green,
                            PixelArtCreator.currentColor.getBlue());
                    PixelArtCreator.currentColor = newColor;
                    PixelArtCreator.curColorButton.setBackground(newColor);
                }

            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
        greenField.setBounds(350, 10, 100, 40);
        PixelArtCreator.greenField = greenField;
        this.add(greenField);

        //------------------------------------------------

        JTextField blueField = new JTextField();
        blueField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                int blue = Integer.parseInt(blueField.getText());
                if (blue >= 0 && blue <= 255){
                    Color newColor = new Color(PixelArtCreator.currentColor.getRed(),
                            PixelArtCreator.currentColor.getGreen(),
                            blue);
                    PixelArtCreator.currentColor = newColor;
                    PixelArtCreator.curColorButton.setBackground(newColor);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
        blueField.setBounds(460, 10, 100, 40);
        PixelArtCreator.blueField = blueField;
        this.add(blueField);

        JButton currentColor = new JButton();
        currentColor.setBounds(580, 10 ,40, 40);
        PixelArtCreator.curColorButton = currentColor;
        this.add(currentColor);



        // Maybe a Label that indicates which player's turn it is...

        // loading bar for possible ChessBot? But now for something completely different first...

    }


    private void initializeWindow(int width, int height){
        Dimension windowSize = new Dimension(width,height);

        this.setLayout(null);			// We need no layout-manager
        this.setSize(windowSize);
        this.setVisible(true);
    }





}

