import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class GridClicked implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        GameButton button = (GameButton) e.getComponent();

        if (SwingUtilities.isLeftMouseButton(e)) {
            button.setText(Integer.toString(button.getNumBombs()));
            if (button.getNumBombs() == -1){
                JPanel panel = (JPanel) button.getParent();
                // panel.add(new JLabel("GAME OVER!"));
                GridLayout layout = (GridLayout) panel.getLayout();
                layout.addLayoutComponent(null, new JLabel("GAME OVER!"));
            } else {
                button.exposeEmpty();
            }
            // System.out.println("left clicked " + button.getNumBombs());
        } else if (SwingUtilities.isRightMouseButton(e)) {
            // System.out.println("right clicked " + button.getNumBombs());
            if (button.getText() == "X") {
                button.setText("");
            } else {
                button.setText("X");
            }
            
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
