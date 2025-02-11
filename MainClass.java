class MainClasss
{
    public static void main(String[] args)
    {
        Board gameBoard = new Board(10,15,45);
        System.out.println();
        gameBoard.printBoard();
        Utils util = new Utils();
        System.out.println(util.add_nums(3,5));
    }
}