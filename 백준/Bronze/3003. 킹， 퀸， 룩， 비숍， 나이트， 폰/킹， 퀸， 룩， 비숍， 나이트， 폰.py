chess = list(map(int, input().split()))

king = 1 - chess[0]
queen = 1 - chess[1]
rook = 2 - chess[2]
bishop = 2 - chess[3]
knight = 2 - chess[4]
pawn = 8 - chess[5]

print(king, queen, rook, bishop, knight, pawn)