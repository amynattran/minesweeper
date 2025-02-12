import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class Utils {
    Utils()
    {
        Frame frame = new Frame("Example 2");

        // setting size, layout and visibility of frame
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);

        // Using WindowListener for closing the window
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });

    }
    

    public int add_nums(int x, int y) {
        return x + y;
    }
}
