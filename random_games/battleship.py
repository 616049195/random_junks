"""
Welcome to Battleship. 
This is a noobie version. 
Only purpose was to learn Python.

** didn't fix user-input yet.

1 Player game.
Grid size = 5x5
4 turns.

2014-08-15
by ...
"""

from random import randint

"""
Preparing for the Game
"""

board = []

for x in range(5):
    board.append(["O"] * 5)

def print_board(board):
    for row in board:
        print " ".join(row)

def random_row(board):
    return randint(0, len(board) - 1)

def random_col(board):
    return randint(0, len(board[0]) - 1)


"""
Game begins
"""

print "Let's play Battleship!"
print_board(board)

ship_row = random_row(board)
ship_col = random_col(board)

# user gets 4 turns.
for turn in range(4):
    # take user inputs
    guess_row = int(raw_input("Guess Row:"))
    guess_col = int(raw_input("Guess Col:"))
    
    # correct guess
    if guess_row == ship_row and guess_col == ship_col:
        print "Congratulations! You sunk my battleship!"
        break
    else: # incorrect guesses
        if (guess_row < 0 or guess_row > 4) or (guess_col < 0 or guess_col > 4):
            print "Oops, that's not even in the ocean."
        elif(board[guess_row][guess_col] == "X"):
            print "You guessed that one already."
        else:
            print "You missed my battleship!"
            board[guess_row][guess_col] = "X"
        # prints the board, turn, and "Game Over" message no matter what.
        print_board(board)
        print turn+1
        if turn == 3:
            print "Game Over"

# code ends.