T = int(input())
for test_case in range(1, T + 1):
    n, m = map(int, input().split())
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))

    if n > m:
        A, B = B, A

    max_total = 0
    for j in range(len(B)-len(A)+1):
        total = 0
        for i in range(len(A)):
            total += A[i] * B[i+j]
        if total > max_total:
            max_total = total

    print(f'#{test_case} {max_total}')