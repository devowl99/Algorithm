T = 10
for test_case in range(1, T + 1):
    pw_len = int(input())
    pw = list(map(int, input().split()))
    cmd_len = int(input())
    cmd = input().split()

    i = 0
    while i < len(cmd):
        edit = []
        if cmd[i] == 'I':
            i += 1
            idx = int(cmd[i])
            i += 1
            count = int(cmd[i])
            i += 1
            for _ in range(count):
                edit.append(int(cmd[i]))
                i += 1
            pw[idx:idx] = edit

        elif cmd[i] == 'D':
            i += 1
            start = int(cmd[i])
            i += 1
            end = start + int(cmd[i])
            i += 1
            del pw[start:end]

    answer = pw[:10]
    print(f'#{test_case}', *answer)