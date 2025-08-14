n, m = map(int, input().split())
square = [list(map(int, input())) for _ in range(n)]

max_num = min(n, m)
biggest_x = 0
answer = -1
for i in range(n):
    for j in range(m):
        for x in range(max_num):
            if 0 <= i+x < n and 0 <= j+x < m:
                if square[i][j] == square[i+x][j] == square[i][j+x] == square[i+x][j+x]:
                    if x > biggest_x:
                        biggest_x = x

print((biggest_x+1)**2)