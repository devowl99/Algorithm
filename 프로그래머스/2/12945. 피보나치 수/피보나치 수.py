def solution(n):
    dp = [0 for _ in range(n)]
    dp[1] = 1
    dp[2] = 2

    for i in range(3, n):
        dp[i] = dp[i-1] + dp[i-2]

    return dp[-1] % 1234567