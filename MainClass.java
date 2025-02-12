class MainClass
{
    public static void main(String[] args)
    {
        int height = 13;
        int width = 10;
        int numBombs = 25;

        Board gameBoard = new Board(height,width,numBombs);
        // System.out.println();
        // gameBoard.printBoard();

        GUI gui = new GUI(height, width, gameBoard);
        
        gui.frame.setVisible(true);

    }
}