import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Hermann on 10.08.2018.
 */
public class PixelArtCreator {
    public static final int colorPanelAccuracy = 10;
    public static Color currentColor = Color.BLUE;
    public static ButtonGridMouseListener mouseListener;
    public static ColorPanelMouseListener panelMouseListener;
    private static PixelArtActionListener actionListener;
    public static Board board;

    public static JTextField redField;
    public static JTextField greenField;
    public static JTextField blueField;

    public static JButton curColorButton;


    public static void main(String args[]){
        initializeGui();
    }

    public static void initializeGui(){
        board = new Board();
        GUI gui = new GUI(board);

        while(true){
            try {Thread.sleep(100);}
            catch(InterruptedException e){};



            gui.getButtonGrid().repaint();
        }
    }

    public static void save(){
        JFrame frame = actionListener.getFrame();
        final JFileChooser saveChooser = new JFileChooser();
        //saveChooser.setFileFilter(new ChessFileFilter());		// The filefilter filters file endings
        saveChooser.setCurrentDirectory(new File("."));			// Here we set the default directory for saving
        int saveSelection = saveChooser.showSaveDialog(null);	// Pops up a save dialog
        if (saveSelection == JFileChooser.APPROVE_OPTION) {
            try {
                File selectedFile = saveChooser.getSelectedFile();		// Gets the selected file (either marked in the window or written)
                if (!selectedFile.getAbsolutePath().endsWith(".txt")) {		// We automatically use the file ending
                    selectedFile = new File(selectedFile.getAbsolutePath()
                            + ".txt");
                }
                PrintWriter out = new PrintWriter(selectedFile);

                int[] boardArray = BoardTransformerWS2812B.transformToIntArray(board.board);

                for(int i = 0; i < boardArray.length; i++){
                    out.print(boardArray[i]);
                    if(i < boardArray.length-1){
                        out.print(" ");
                    }
                }

                out.close();						// Here we close the handle

                JOptionPane.showConfirmDialog(frame, "Saving succeeded!",
                        "Saving succeeded", JOptionPane.DEFAULT_OPTION,
                        JOptionPane.PLAIN_MESSAGE);

            } catch (Exception e2) {
                JOptionPane.showConfirmDialog(frame, "Saving failed!",
                        "Saving failed", JOptionPane.DEFAULT_OPTION,
                        JOptionPane.ERROR_MESSAGE);
                e2.printStackTrace();
            }
        }
    }

    public static void load() {
        final JFileChooser loadChooser = new JFileChooser();	// Similar to saving we use a filefilter
        //loadChooser.setFileFilter(new ChessFileFilter());		// to select only the .chs files
        loadChooser.setCurrentDirectory(new File("."));
        int selection = loadChooser.showOpenDialog(null);		// Here's the loading selection window
        if (selection == JFileChooser.APPROVE_OPTION) {
            try (Scanner scanner =  new Scanner(loadChooser.getSelectedFile())){
                while (scanner.hasNextLine()){
                    processLine(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }

    }

    private static void processLine(String line) {
        //use a second Scanner to parse the content of each line
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter(" ");
        for (int i = 0; i < 14; i++){
            for (int j = 0; j < 14; j++){
                if (scanner.hasNext()) {
                    try {
                        int red = scanner.nextInt();
                        int green = scanner.nextInt();
                        int blue = scanner.nextInt();

                        board.setColorToPixel(i, j, new Color(red, green, blue));

                    } catch (InputMismatchException e) {
                        //Is thrown for the Header, can be ignored
                        //e.printStackTrace();
                    }
                } else {
                    //System.out.println("Empty or invalid line. Unable to process.");
                }
            }
        }
    }

    public static void resetBoard(){
        board.reset();
    }

    public static void setMouseListener(ButtonGridMouseListener listener) {
        mouseListener = listener;
    }

    public static PixelArtActionListener getActionListener() {
        return actionListener;
    }


    public static void setActionListener(PixelArtActionListener listener) {
        actionListener = listener;
    }

    public static void changeCurrentColor(Color color){
        currentColor = color;

        redField.setText("" + color.getRed());
        greenField.setText("" + color.getGreen());
        blueField.setText("" + color.getBlue());

        curColorButton.setBackground(color);
    }
}
