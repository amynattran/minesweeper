class MainClass
{
    public static void main(String[] args)
    {
        int height = 30;
        int width = 24;
        int numBombs = 160;

        Board gameBoard = new Board(height,width,numBombs);
        // System.out.println();
        // gameBoard.printBoard();

        GUI gui = new GUI(height, width, gameBoard);
        
        gui.frame.setVisible(true);

    }
}