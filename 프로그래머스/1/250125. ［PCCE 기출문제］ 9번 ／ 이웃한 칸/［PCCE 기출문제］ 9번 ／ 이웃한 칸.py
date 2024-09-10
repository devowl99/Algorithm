def solution(board, h, w):
    n = len(board)
    count = 0
    if h+1 < n and board[h+1][w] == board[h][w]:
        count += 1
    if w+1 < n and board[h][w+1] == board[h][w]:
        count += 1
    if 0 <= h-1 and board[h-1][w] == board[h][w]:
        count += 1
    if 0 <= w-1 and board[h][w-1] == board[h][w]:
        count += 1

    return count