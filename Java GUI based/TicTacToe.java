import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.font.*;

public class TicTacToe {

    int width = 600;
    int height = 650;

    Color teal = new Color(19,122,99);
    Color greendark = new Color(10,58,42);
    Color tiecolor = new Color(246,178,107);
    Color wincolor = new Color(105,190,199);

    JFrame frame = new JFrame("Tic Tac Toe - By: Subhadip");
    JPanel textpanel = new JPanel();
    JLabel textlabel = new JLabel();
    JPanel boardpanel = new JPanel();

    JButton[][] board = new JButton[3][3];

    String player1 = "X";
    String player2 = "O";
    String currentPlayer = "X";

    boolean gameOver = false;

    int moves = 0;

    TicTacToe(){
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        textlabel.setBackground(greendark);
        textlabel.setForeground(Color.WHITE);
        textlabel.setFont(new Font("Algerian", Font.BOLD, 80));
        textlabel.setHorizontalAlignment(JLabel.CENTER);
        textlabel.setText("Tic Tac Toe");
        textlabel.setOpaque(true);
        
        textpanel.setLayout(new BorderLayout());
        textpanel.add(textlabel);
        frame.add(textpanel, BorderLayout.NORTH);

        boardpanel.setLayout(new GridLayout(3,3, 5, 5));
        boardpanel.setBackground(Color.darkGray);
        frame.add(boardpanel);

        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                JButton tile = new JButton();
                board[i][j] = tile;
                boardpanel.add(tile);

                tile.setBackground(teal);
                tile.setForeground(Color.white);
                tile.setFont(new Font("PrinceTown", Font.BOLD, 100));
                tile.setFocusable(false);

                tile.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (gameOver){
                            return;
                        }

                        JButton tile = (JButton)e.getSource();
                        if (tile.getText() == "") {
                            tile.setText(currentPlayer);
                            moves++;
                            checkWinner();
                            if (!gameOver){
                            currentPlayer = currentPlayer == player1 ? player2 : player1;
                            textlabel.setText(currentPlayer + "'s turn");
                            }
                        }

                    }

                });



            }
        }




    }

    void checkWinner(){
        for (int i=0; i<3; i++){
            // Horizontal check
            if (board[i][0].getText() == currentPlayer && board[i][1].getText() == currentPlayer && board[i][2].getText() == currentPlayer){
                textlabel.setText(currentPlayer + " wins!");
                for (int j=0; j<3; j++){
                    setWinnerColor(board[i][j]);
                                        
                }
                gameOver = true;
                return;
            }
        }
            // Vertical check
        for (int q=0; q<3; q++){
            if (board[0][q].getText() == currentPlayer && board[1][q].getText() == currentPlayer && board[2][q].getText() == currentPlayer){
                textlabel.setText(currentPlayer + " wins!");
                for (int r=0; r<3; r++){
                    setWinnerColor(board[r][q]);
                                        
                }
                gameOver = true;
                return;
            }
        }    
            // Diagonal check   
            if (board[0][0].getText() == currentPlayer && board[1][1].getText() == currentPlayer && board[2][2].getText() == currentPlayer){
                textlabel.setText(currentPlayer + " wins!");
                for (int s=0; s<3; s++){
                    setWinnerColor(board[s][s]);
                                        
                }
                gameOver = true;
                return;
            }
        
            // Anti-diagonal check
            if (board[0][2].getText() == currentPlayer && board[1][1].getText() == currentPlayer && board[2][0].getText() == currentPlayer){
                textlabel.setText(currentPlayer + " wins!");
                for (int s=0; s<3; s++){
                    setWinnerColor(board[s][2-s]);
                                        
                }
                gameOver = true;
                return;
            }

            if (moves == 9){
                textlabel.setText("It's a draw!");
                for (int z=0; z<3; z++){
                    for (int y=0; y<3; y++){
                        setTie(board[z][y]);
                    }
                }
                gameOver = true;
                return;
            }
        
    }

    void setWinnerColor(JButton button){
        button.setBackground(wincolor);
        button.setForeground(Color.white);
    }

    void setTie(JButton button){
    button.setBackground(tiecolor);
        button.setForeground(Color.white);
    }

}