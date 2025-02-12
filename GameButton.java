import java.awt.*;

public class GameButton extends Button{
    int num;

    GameButton(int numBomb) {
        this.num = numBomb;
    }

    public int getNum() {
        return this.num;
    }
}
