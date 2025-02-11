from typing import List
import random

def create_board(width: int, height: int, num_bombs: int) -> List[List[int]]:
    assert width * height > num_bombs

    board = [[0 for _ in range(width)] for _ in range(height)]
    positions = list(range(width * height))
    random.shuffle(positions)
    for _ in range(num_bombs):
        bomb = positions.pop(0)
        x = bomb % width
        y = bomb // width
        board = update_board(x, y, width, height, board)
    return board
        

def update_board(x: int, y: int, width: int, height: int, board):
    # update board
    is_top = y == 0
    is_bottom = y == height - 1
    is_left = x == 0
    is_right = x == width - 1
    board[y][x] = -1
    if not is_top:
        if board[y-1][x] != -1:
            board[y-1][x] += 1
        if not is_left and board[y-1][x-1] != -1:
            board[y-1][x-1] += 1
        if not is_right and board[y-1][x+1] != -1:
            board[y-1][x+1] += 1
    if not is_bottom:
        if board[y+1][x] != -1:
            board[y+1][x] += 1
        if not is_left and board[y+1][x-1] != -1:
            board[y+1][x-1] += 1
        if not is_right and board[y+1][x+1] != -1:
            board[y+1][x+1] += 1
    if not is_left and board[y][x-1] != -1:
        board[y][x-1] += 1
    if not is_right and board[y][x+1] != -1:
        board[y][x+1] += 1
    return board
