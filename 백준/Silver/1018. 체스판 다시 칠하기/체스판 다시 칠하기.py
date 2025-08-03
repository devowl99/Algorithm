n, m = map(int, input().split())
board = [list(input()) for _ in range(n)]

min_paint = float('inf')
for i in range(n-8+1):
    for j in range(m-8+1):
        W_start = 0 # W로 시작
        B_start = 0 # B로 시작
        for k in range(i, i+8):
            for l in range(j, j+8):
                current = board[k][l]
                if (k+l) % 2 == 0:
                    if current == 'W':
                        B_start += 1
                    else: # current == 'B'
                        W_start += 1
                else: # (k+l) % 2 == 1
                    if current == 'W':
                        W_start += 1
                    else: # current == 'B'
                        B_start += 1
        min_paint = min(min_paint, W_start, B_start)

print(min_paint)