n, m = map(int, input().split())
arr = list(map(int, input().split()))

max_sum = 0
for i in range(n):
    for j in range(i + 1, n):
        for k in range(j + 1, n):
            sum = arr[i] + arr[j] + arr[k]
            if max_sum < sum <= m:
                max_sum = sum
print(max_sum)