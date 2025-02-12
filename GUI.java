import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class GUI {
    int height;
    int width;
    Button[][] board;
    Frame frame;
    int buttonSize = 30;
    int startX = 50;
    int startY = 50;
    Board numBoard;

    GUI(int height, int width, Board board) {
        this.height = height;
        this.width = width;
        this.numBoard = board;
        this.frame = new Frame("Minesweeper");
        this.board = createGUIBoard(width, height, this.buttonSize, this.startX, this.startY, this.frame);

        this.frame.setSize(buttonSize * (width + 4), buttonSize * (height + 4));
        this.frame.setLayout(null);
        this.frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });


    }

    private Button[][] createGUIBoard(int width, int height, int buttonSize, int startX, int startY, Frame frame){
        Button[][] ret = new Button[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                GameButton button = new GameButton(this.numBoard.board[j][i]);
                int xDiff = startX + (i * buttonSize);
                int yDiff = startY + (j * buttonSize);

                button.setBounds(xDiff, yDiff, buttonSize, buttonSize);
                button.addMouseListener(new GridClicked());
                frame.add(button);
                ret[i][j] = button;
            }
        }
        
        return ret;
    }
    
}
