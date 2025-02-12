import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class GridClicked implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        GameButton button = (GameButton) e.getComponent();

        if (SwingUtilities.isLeftMouseButton(e)) {
            button.setLabel(Integer.toString(button.getNum()));
            if (button.getNum() == 0) {
                Frame frame = (Frame) button.getParent();
                frame.remove(button);
            }
            System.out.println("left clicked " + button.getNum());
        } else if (SwingUtilities.isRightMouseButton(e)) {
            System.out.println("right clicked " + button.getNum());
            button.setLabel("X");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
    }
    
}
