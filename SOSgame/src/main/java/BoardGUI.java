import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BoardGUI extends JFrame {
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
    private JLabel colorTurn;

    private GameBoardCanvas gameBoardCanvas;
    private GameBoardCanvas boardPanel;
    private SosGame game;

    public BoardGUI(SosGame game) {
        this.game = game;
        setContentPane(mainPanel);
        setSize(720, 540);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("SOS Game");
        setVisible(true);
        newGameButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    game.setBoardSize(textBoardSize.getText());
                } catch(Exception exception) {
                    JOptionPane.showMessageDialog(BoardGUI.this, exception.getMessage());
                }
                game.resetGame();
                auxPanel.remove(boardPanel);
                boardPanel = new GameBoardCanvas();
                auxPanel.add(boardPanel);
                auxPanel.revalidate();
                auxPanel.repaint();
            }
        });
    }
    private void createUIComponents() {
        // Los objetos JPanel son solo contenedores
        mainPanel = new JPanel();
        auxPanel = new JPanel();
        auxPanel.setLayout(new GridLayout(1, 1));
        boardPanel = new GameBoardCanvas();
        auxPanel.add(boardPanel);
        newGameButton = new JButton();
        sRadioButtonBlue = new JRadioButton();
        sRadioButtonRed = new JRadioButton();
        textBoardSize = new JTextField();
        colorTurn = new JLabel();

    }

    class GameBoardCanvas extends JPanel {
        GameBoardCanvas(){
            //setFont(new Font());
            setResizable(false);
            setLayout(new GridLayout(game.getBoardSize(), game.getBoardSize()));
            for (int i = 0; i < game.getBoardSize(); i++) {
                for (int j = 0; j < game.getBoardSize(); j++) {
                    Button b = new Button();
                    b.setName("" + i + " " + j);
                    b.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            b.setEnabled(false);
                            String xy[] = b.getName().split(" ");
                            int x = Integer.parseInt(xy[0]);
                            int y = Integer.parseInt(xy[1]);
                            if (SosGame.Player.getCurrentPlayer() == SosGame.Player.BLUE) {
                                if (sRadioButtonBlue.isSelected())
                                    game.setMove(SosGame.Cell.S);
                                else
                                    game.setMove(SosGame.Cell.O);
                            } else {
                                if (sRadioButtonRed.isSelected())
                                    game.setMove((SosGame.Cell.S));
                                else
                                    game.setMove(SosGame.Cell.O);
                            }
                            game.makeMove(x, y); // Actualiza el turno
                            colorTurn.setText(SosGame.Player.getCurrentPlayer() + " turn");
                            b.setLabel(game.getCurrentMove());
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
                new BoardGUI(new SosGame());
            }
        });
    }
}
