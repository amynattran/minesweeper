import javax.swing.*;
import java.awt.*;
import java.lang.Math;


public class GameButton extends JButton{
    int numBombs;
    int x;
    int y;
    JButton[][] board;

    GameButton(int numBomb, int x, int y, JButton[][] board) {
        this.numBombs = numBomb;
        this.board = board;
        this.x = x;
        this.y = y;
    }

    public int getNumBombs() {
        return this.numBombs;
    }

    public void exposeEmpty() {
        if (this.board[this.y][this.x] == null) {
            return;
        }
        
        // System.out.println("help me");
        // Remove button from panel and board
        // JPanel panel = (JPanel) this.getParent();
        // panel.remove(this);
        this.board[this.y][this.x] = null;

        if (this.numBombs == 0) {
            this.setVisible(false);
            for (int j = Math.max(this.x-1, 0); j<=Math.min(this.x+1, this.board[0].length-1); j++) {
                for (int k = Math.max(this.y-1, 0); k <= Math.min(this.y+1, this.board.length-1); k++) {
                    if (j == 0 && k == 0) {continue;}
                    GameButton nextButton = (GameButton) this.board[k][j];
                    if (nextButton == null) { continue; }
                    nextButton.exposeEmpty();
                }
            }
        }
        else {
            this.setText(Integer.toString(this.numBombs));
            switch(this.numBombs) {
                case 1:
                    this.setForeground(Color.BLUE);
                    break;
                case 2:
                    this.setForeground(Color.PINK);
                    break;
                case 3:
                    this.setForeground(Color.RED);
                    break;
                case 4:
                    this.setForeground(Color.MAGENTA);
                    break;
                case 5:
                    this.setForeground(Color.ORANGE);
                    break;
                case 6:
                    this.setForeground(Color.YELLOW);
                    break;
                case 7:
                    this.setForeground(Color.DARK_GRAY);
                    break;
            }
        }
    }
}
