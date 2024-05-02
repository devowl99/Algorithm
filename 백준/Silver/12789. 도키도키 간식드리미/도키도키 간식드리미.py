n = int(input())

line = list(map(int, input().split()))
space = []
get = [0]

while line:
    if line[0] == get[-1]+1:
        get.append(line.pop(0))
    else:
        space.append(line.pop(0))

    while space:
        if space[-1] == get[-1]+1:
            get.append(space.pop())
        else:
            break

if get[-1] == n:
    print('Nice')
else:
    print('Sad')