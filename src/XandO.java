import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class XandO {
    int boardWidth = 600;
    int boardHeight = 650;
    
    JFrame frame = new JFrame("X and O");
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel boardPanel = new JPanel();

    JButton[][] board = new JButton[3][3];
    String playerX = "X";
    String playerO = "O";
    String currentPlayer = playerX;

    boolean gameOver = false;
    int turns = 0;

    
    XandO (){
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        textLabel.setBackground(Color.darkGray);
        textLabel.setForeground(Color.white);
        textLabel.setFont(new Font("Ariel", Font.BOLD, 60));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText(currentPlayer + "'s turn.");
        textLabel.setOpaque(true);

        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel);
        frame.add(textPanel, BorderLayout.NORTH);

        boardPanel.setLayout(new GridLayout(3,3));
        boardPanel.setBackground(Color.darkGray);
        frame.add(boardPanel);

        for (int r = 0; r<3; r++){
            for (int c = 0; c<3; c++){
                JButton tile = new JButton();
                board[r][c] = tile;
                boardPanel.add(tile);

                tile.setBackground(Color.darkGray);
                tile.setForeground(Color.white);
                tile.setFont(new Font("Ariel", Font.BOLD, 120));
                tile.setFocusable(false);

                tile.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        if (gameOver) return;
                        JButton tile = (JButton) e.getSource();
                        if (tile.getText() == ""){
                            tile.setText(currentPlayer);
                            turns++;
                            checkWinner();
                            if (!gameOver){
                                currentPlayer = currentPlayer == playerX ? playerO:playerX;
                                textLabel.setText(currentPlayer + "'s turn.");
                            }
                        }
                    }
                });
            }
        }


        // keep at the bottom
        frame.setVisible(true);

    }
    
    void checkWinner(){
        //horizontal check
        for (int r = 0; r<3; r++){
            if (board[r][0].getText() == board[r][1].getText() && 
            board[r][1].getText() == board[r][2].getText()
             && board[r][0].getText() != ""){
                for (int i = 0; i<3;i++){
                    setWinner(board[r][i]);
                }
                gameOver = true;
                return;
            }
        }
        // vertical check
        for (int c = 0; c<3; c++){
            if (board[0][c].getText() == board[1][c].getText() && 
            board[1][c].getText() == board[2][c].getText() &&
            board[0][c].getText() != ""){
                for (int i = 0; i<3;i++){
                    setWinner(board[i][c]);
                }
                gameOver = true;
                return;
            }
        }
        // diagonally
        if (board[0][0].getText() != "" && 
            board[0][0].getText() == board[1][1].getText() && 
            board[1][1].getText() == board[2][2].getText()){
            for (int i = 0; i<3;i++){
                setWinner(board[i][i]);
            }
            gameOver = true;
            return;
        }
        //antidiagonally
        if (board[0][2].getText() != "" && 
        board[0][2].getText() == board[1][1].getText() && 
        board[1][1].getText() == board[2][0].getText()){
            setWinner(board[0][2]);
            setWinner(board[1][1]);
            setWinner(board[2][0]);
            gameOver = true;
            return;
        }
        if (turns == 9){
            for (int r = 0; r<3; r++){
                for (int c = 0; c<3; c++){
                    setTie(board[r][c]);
                }
                
            }
            gameOver = true;
            return;
        }
    }

    void setWinner(JButton tile){
        tile.setBackground(Color.yellow);
        tile.setForeground(Color.green);
        textLabel.setText(currentPlayer + " is the winner");
    }

    void setTie(JButton tile){
        tile.setBackground(Color.gray);
        tile.setForeground(Color.yellow);
        textLabel.setText( "Tie!");
    }
}
