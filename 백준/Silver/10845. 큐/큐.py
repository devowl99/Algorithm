import sys
input = sys.stdin.readline
n = int(input())
q = []

for _ in range(n):
    com = input().split()

    if com[0] == 'pop':
        if (len(q)!=0):
            print(q.pop(0))
        else:
            print(-1)
    elif com[0] == 'size':
        print(len(q))
    elif com[0] == 'empty':
        if (len(q)==0):
            print(1)
        else:
            print(0)
    elif com[0] == 'front':
        if (len(q)!=0):
            print(q[0])
        else:
            print(-1)
    elif com[0] == 'back':
        if (len(q)!=0):
            print(q[-1])
        else:
            print(-1)
    else:
        q.append(com[1])