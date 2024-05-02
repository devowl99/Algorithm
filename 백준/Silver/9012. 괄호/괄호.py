t = int(input())

for _ in range(t):
    vps = []
    data = input()
    for i in data:
        if i == '(':
            vps.append(i)
        elif i == ')':
            if vps and vps[-1] == '(':
                vps.pop()
            else:
                vps.append(i)
    if vps:
        print('NO')
    else:
        print('YES')