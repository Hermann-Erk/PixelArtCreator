import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Hermann on 10.08.2018.
 */
public class PixelArtActionListener implements ActionListener {
        private GUI frame;

        public PixelArtActionListener(GUI frame){
            this.frame = frame;
        }

        public void actionPerformed(ActionEvent e){
            switch (e.getActionCommand()){
                case "Load File":
                    PixelArtCreator.load();
                    break;
                case "Save File":
                    PixelArtCreator.save();
                    break;
                case "New File":
                    PixelArtCreator.resetBoard();
                    // TODO create new board and connect it to boardSquares like when loading, implement in ChessStatics

                    break;
                case "Exit":
                    System.exit(0);
                    // TODO choice window

                    break;
            }









        }

        public GUI getFrame() {
            return frame;
        }

        public void setFrame(GUI frame) {
            this.frame = frame;
        }

    }
