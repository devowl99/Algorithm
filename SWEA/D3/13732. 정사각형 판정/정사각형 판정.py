T = int(input())
for test_case in range(1, T + 1):
    size = int(input())
    board = []
    for _ in range(size):
        board.append(input())

    start_y = -1
    save = ''
    for y in range(size):
        for x in range(size):
            if board[y][x] == '#':
                start_y = y
                save = board[y]
                break
        if start_y != -1:
            break

    closed_num = save.count('#')

    can_make = True
    for y in range(size):
        if start_y <= y < start_y + closed_num:
            if board[y] != save:
                can_make = False
        else:
            if board[y].count('#') != 0:
                can_make = False

    first_sharp = save.index('#')
    if save[first_sharp:first_sharp+closed_num] != '#'*closed_num:
        can_make = False

    if can_make:
        print(f'#{test_case} yes')
    else:
        print(f'#{test_case} no')