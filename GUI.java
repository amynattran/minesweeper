import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class GUI {
    int height;
    int width;
    JButton[][] board;
    JFrame frame;
    int buttonSize = 30;
    int startX = 50;
    int startY = 50;
    Board numBoard;
    JPanel panel;

    GUI(int height, int width, Board board) {
        this.height = height;
        this.width = width;
        this.numBoard = board;
        this.board = new JButton[width][height];
        this.frame = new JFrame("Minesweeper");
        this.panel = createMinePanel(width, height);
        int midX = Math.floorDiv(width, 2);
        int midY = Math.floorDiv(height, 2);

        GameButton temp = (GameButton) this.board[midX][midY];
        temp.exposeEmpty();
        this.frame.add(this.panel);
        
        // frame.setContentPane(this.panel);
        // frame.getContentPane().add(this.panel); 

        this.frame.setSize(buttonSize * (width + 4), buttonSize * (height + 4));
        this.frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });


    }

    private JPanel createMinePanel(int width, int height) {
        JPanel mineFieldContainer = new JPanel(new GridLayout(
                width, height));
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                GameButton button = new GameButton(this.numBoard.board[j][i], j, i, this.board);
                button.setMargin(new Insets(5,5,5,5));
                button.addMouseListener(new GridClicked());

                mineFieldContainer.add(button);
                this.board[i][j] = button;
            }
        }
        return mineFieldContainer;
    }
    
}
