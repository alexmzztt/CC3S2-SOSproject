/*import javax.swing.*;
import java.awt.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BoardGUI extends JFrame {

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
    private JTextField textField1;
    private JRadioButton sRadioButton;
    private JRadioButton oRadioButton;
    private JRadioButton sRadioButton1;
    private JRadioButton oRadioButton1;
    private JButton newGameButton;
    private JPanel auxPanel;

    private GameBoardCanvas gameBoardCanvas;
    private GameBoardCanvas boardPanel;

    public BoardGUI() {
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
    }

//    private void setContentPane(){
//        gameBoardCanvas = new GameBoardCanvas();
//        gameBoardCanvas.setPreferredSize(new Dimension(720, 540));
//
//        Container contentPane = getContentPane();
//        contentPane.setLayout(new BorderLayout());
//        contentPane.add(gameBoardCanvas, BorderLayout.CENTER);
//    }

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
                            b.setLabel("s");
                            b.setEnabled(false);
                            System.out.println(b.getName());
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
                new BoardGUI();
            }
        });
    }
}*/