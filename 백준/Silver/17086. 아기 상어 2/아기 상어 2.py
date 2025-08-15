from collections import deque

n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]

dx = [1, -1, 1, -1, 1, -1, 0, 0]
dy = [0, 0, 1, -1, -1, 1, 1, -1]

def bfs(xx, yy, c):
    q = deque([(xx, yy, c)])
    visited = [[False] * m for _ in range(n)]
    visited[xx][yy] = True

    while q:
        x, y, count = q.popleft()

        for o in range(8):
            nx = x + dx[o]
            ny = y + dy[o]

            if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny]:
                if board[nx][ny] == 0:
                    visited[nx][ny] = True
                    q.append((nx, ny, count+1))
                elif board[nx][ny] == 1:
                    return count+1

max_d = 0
for i in range(n):
    for j in range(m):
        if board[i][j] == 0:
            comp = bfs(i, j, 0)
            max_d = max(max_d, comp)

print(max_d)