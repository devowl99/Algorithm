T = int(input())
for test_case in range(1, T + 1):
    n, m = map(int, input().split())
    board = [list(map(int, input().split())) for _ in range(n)]

    dx1 = [1,-1,0,0]
    dy1 = [0,0,1,-1]
    dx2 = [1,1,-1,-1]
    dy2 = [1,-1,1,-1]

    kill = 0
    for y in range(n):
        for x in range(n):
            plus_case = board[y][x]
            x_case = board[y][x]

            for o in range(4):
                for ex in range(1, m):
                    nx = x + dx1[o] * ex
                    ny = y + dy1[o] * ex
                    if 0 <= nx < n and 0 <= ny < n:
                        plus_case += board[ny][nx]

                    nx = x + dx2[o] * ex
                    ny = y + dy2[o] * ex
                    if 0 <= nx < n and 0 <= ny < n:
                        x_case += board[ny][nx]

            max_case = max(plus_case, x_case)
            if max_case > kill:
                kill = max_case

    print(f'#{test_case} {kill}')