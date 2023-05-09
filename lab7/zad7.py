import random
import sys
import pytest

board = [' ' for x in range(56)]
field = 0

def main():
	start = random.randrange(11, 15)
	global field
	field = start
	finish = random.randrange(51, 55)
	for i in range(2,5):
		obstacle = random.randrange(i*10 + 1, i*10 + 5)
		board[obstacle] = "O"
	board[start] = "S"
	board[finish] = "F"
	print_board(board)
	print("\n")
	i = 1
	while i>0:
		i = move()
def print_board(board):
	print(board[11], ' |', board[12], ' |', board[13], ' |', board[14], ' |', board[15])
	print('--', '+', '--', '+', '--', '+', '--', '+', '--')
	print(board[21], ' |', board[22], ' |', board[23], ' |', board[24], ' |', board[25])
	print('--', '+', '--', '+', '--', '+', '--', '+', '--')
	print(board[31], ' |', board[32], ' |', board[33], ' |', board[34], ' |', board[35])
	print('--', '+', '--', '+', '--', '+', '--', '+', '--')
	print(board[41], ' |', board[42], ' |', board[43], ' |', board[44], ' |', board[45])
	print('--', '+', '--', '+', '--', '+', '--', '+', '--')
	print(board[51], ' |', board[52], ' |', board[53], ' |', board[54], ' |', board[55])


def move():
	try:
		move = input("Wpisz ruch jaki chcesz wykonać: up - ruch w górę, down - ruch w dół, ,right - ruch w prawo, left - ruch w lewo\n S - start, F - koniec gry, O - przeszkoda, P - gracz\n")
		return move_validation(move)
	except ValueError:
		print("Niepoprawnie wpisałeś ruch. Wpisz up, down, right lub left\n")

def move_validation(move):
	global field
	if board[available_move(move)] == ' ':
		board[available_move(move)] = "P"
		field = available_move(move)
	elif board[available_move(move)] == 'F':
		print("Wygrałeś grę :)!")
		return 0
	else:
		print("Ruch niepoprawny\n")
		return 2
	print_board(board)
	print("\n")
	return 1

def available_move(move):
	global field
	if move == "up":
		if field-10 > 11:
			if board[field] == "P":
				board[field] = " "
			return field-10
	elif move == "down":
		if field+10 < 56:
			if board[field] == "P":
				board[field] = " "
			return field+10
	elif move == "right":
		if (field + 1) % 10 < 6:
			if board[field] == "P":
				board[field] = " "
			return field+1
	elif move == "left":
		if (field-1) % 10 != 0:
			if board[field] == "P":
				board[field] = " "
			return field-1
	return field

def static_board():
	board[14] = "S"
	board[23] = "O"
	board[31] = "O"
	board[43] = "O"
	board[54] = "F"

def clear_board():
	global board
	board = [' ' for x in range(56)]


#main()
def setup():
	static_board()
	print("\nboard built")
def teardown():
	clear_board()
	print("\ncleaned board")

class TestsBorder:
	right_fields = [15,25,35,45,55]
	left_fields = [11,21,31,41,51]
	top_fields = [11,12,13,14,15]
	bottom_fields = [51,52,53,54,55]

	@pytest.mark.parametrize("actual_fields_right", right_fields)
	def test_right_border(self,actual_fields_right):
		global field
		field = actual_fields_right
		board[field] = "P"
		assert available_move("right") == field

	@pytest.mark.parametrize("actual_fields_left", left_fields)
	def test_left_border(self,actual_fields_left):
		global field
		field = actual_fields_left
		board[field] = "P"
		assert available_move("left") == field

	@pytest.mark.parametrize("actual_fields_top", top_fields)
	def test_top_border(self,actual_fields_top):
		global field
		field = actual_fields_top
		board[field] = "P"
		assert available_move("up") == field

	@pytest.mark.parametrize("actual_fields_bottom", bottom_fields)
	def test_bottom_border(self,actual_fields_bottom):
		global field
		field = actual_fields_bottom
		board[field] = "P"
		assert available_move("down") == field

class TestsGameMove:
	@pytest.mark.skipif(sys.version_info < (3, 12), reason="requires python3.12 or higher")
	def test_win(self):
		global field
		field = 53
		assert move_validation("right") == 0
		field = 55
		assert move_validation("left") == 0
		field = 44
		assert move_validation("down") == 0
		
	@pytest.mark.skip(reason="trzeba było tego użyć")
	def test_obstacle_four_directions(self):
		global field
		field = 22
		assert move_validation("right") == 2
		field = 24
		assert move_validation("left") == 2
		field = 33
		assert move_validation("up") == 2
		field = 13
		assert move_validation("down") == 2
		
	@pytest.mark.xfail
	def test_path(self):
		global field
		field = 14
		assert move_validation("down") == 1 #24
		assert move_validation("down") == 1 #34
		assert move_validation("down") == 1 #44
		assert move_validation("down") == 0 #54




