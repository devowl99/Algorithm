T = int(input())
for test_case in range(1, T + 1):
    d, h, m = map(int, input().split())
    d_day = 11*24*60 + 11*60 + 11
    time = d*24*60 + h*60 + m

    if time - d_day < 0:
        answer = -1
    else:
        answer = time - d_day

    print(f'#{test_case} {answer}')