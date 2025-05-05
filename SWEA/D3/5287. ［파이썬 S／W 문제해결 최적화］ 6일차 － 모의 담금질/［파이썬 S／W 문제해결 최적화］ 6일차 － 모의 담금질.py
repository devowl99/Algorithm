TC = int(input())
for test_case in range(1, TC + 1):
    T, T_end, k = map(float, input().split())
    count = 0
    while T > T_end:
        T *= k
        count += 1
    print(f'#{test_case} {count}')