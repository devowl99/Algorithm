def turn_90(board):
    new_board = [[0] * b_len for _ in range(b_len)]
    for j in range(b_len):
        for i in range(b_len):
            new_board[i][j] = board[j][i]
    for k in range(b_len):
        new_board[k] = new_board[k][::-1]

    return new_board

T = int(input())
for test_case in range(1, T + 1):
    n = int(input())
    board = [list(map(int, input().split())) for _ in range(n)]
    b_len = len(board)

    t90 = turn_90(board)
    t180 = turn_90(t90)
    t270 = turn_90(t180)

    print(f'#{test_case}')
    for i in range(b_len):
        r90 = ''.join(map(str, t90[i]))
        r180 = ''.join(map(str, t180[i]))
        r270 = ''.join(map(str, t270[i]))

        print(f"{r90} {r180} {r270}")