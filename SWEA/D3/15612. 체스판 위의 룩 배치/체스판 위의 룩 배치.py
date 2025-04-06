T = int(input())
for test_case in range(1, T + 1):
    cant = []
    can = True
    rooks = 0

    for _ in range(8):
        line = input()
        if line.count('O') != 1:
            can = False
        else:
            rooks += 1
            if line.index('O') in cant:
                can = False
            else:
                cant.append(line.index('O'))

    if can:
        print(f'#{test_case} yes')
    else:
        print(f'#{test_case} no')