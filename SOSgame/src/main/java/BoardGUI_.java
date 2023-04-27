import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BoardGUI_ extends JFrame {

    public static int CELL_SIZE = 100;
    public static int GRID_WIDTH = 3;

    public static final int CELL_PADDING = CELL_SIZE / 6;
    public static final int SYMBOL_SIZE = CELL_SIZE - CELL_PADDING * 2;
    public static final int SYMBOL_STROKE_WIDTH = 8;
    private int CANVAS_WIDTH;
    private int CANVAS_HEIGHT;

    private JRadioButton simpleGameRadioButton;
    private JRadioButton generalGameRadioButton;
    private JPanel mainPanel;
    private JTextField textBoardSize;
    private JRadioButton sRadioButtonBlue;
    private JRadioButton oRadioButtonBlue;
    private JRadioButton sRadioButtonRed;
    private JRadioButton oRadioButtonRed;
    private JButton newGameButton;
    private JPanel auxPanel;

    private GameBoardCanvas gameBoardCanvas;
    private GameBoardCanvas boardPanel;
    private SosGame game;

    public BoardGUI_(SosGame game) {
        this.game = game;
        setContentPane(mainPanel);
        setSize(720, 540);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("SOS Game");
        setVisible(true);
    }
    private void createUIComponents() {
        // TODO: place custom component creation code here
        mainPanel = new JPanel();
        auxPanel = new JPanel();
        auxPanel.setLayout(new GridLayout(1, 1));
        boardPanel = new GameBoardCanvas();
        auxPanel.add(boardPanel);
        newGameButton = new JButton();
        sRadioButtonBlue = new JRadioButton();
        sRadioButtonRed = new JRadioButton();
        textBoardSize = new JTextField();
    }
    private void $$$setupUI$$$ () {
        newGameButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    game.setBoardSize(textBoardSize.getText());
                } catch(Exception exception) {

                }
            }
        });
    }

    class GameBoardCanvas extends JPanel {
        private int boardSize = 10;
        private double cellSize;

        GameBoardCanvas(){
            //setFont(new Font());
            setResizable(false);
            setLayout(new GridLayout(boardSize, boardSize));
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    Button b = new Button();
                    b.setName("" + i + " " + j);
                    b.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            b.setEnabled(false);
                            String xy[] = b.getName().split(" ");
                            int x = Integer.parseInt(xy[0]);
                            int y = Integer.parseInt(xy[1]);
                            game.makeMove(x, y);
                            b.setLabel(game.getCurrentMove());
                            if (sRadioButtonBlue.isSelected()) {
                                game.setMove(SosGame.Cell.S);
                            } else {
                                game.setMove(SosGame.Cell.O);
                            }
                            if(sRadioButtonRed.isSelected()) {
                                game.setMove((SosGame.Cell.S));
                            } else {
                                game.setMove(SosGame.Cell.O);
                            }
                        }
                    });
                    add(b);
                }
            }

        }
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BoardGUI_(new SosGame());
            }
        });
    }
}
