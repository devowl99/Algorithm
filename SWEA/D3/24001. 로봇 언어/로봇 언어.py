T = int(input())
for test_case in range(1, T + 1):
    commands = list(input().strip())
    recent1 = 0
    recent2 = 0
    case = []

    for cmd in commands:
        if cmd == 'R':
            recent1 += 1
            recent2 += 1
            case.append(abs(recent1))
            case.append(abs(recent2))
        elif cmd == 'L':
            recent1 -= 1
            recent2 -= 1
            case.append(abs(recent1))
            case.append(abs(recent2))
        elif cmd == '?':
            recent1 += 1
            case.append(abs(recent1))
            recent2 -= 1
            case.append(abs(recent2))

    print(f'{max(case)}')