import utils
import interface



def main():
    board = utils.create_board(15, 7, 30)
    for i in board:
        print(i) 
    interface.create_window()


if __name__=="__main__":
    main()
