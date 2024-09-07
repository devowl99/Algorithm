def solution(n, arr1, arr2):
    sol1 = toTwo(arr1, n)
    sol2 = toTwo(arr2, n)
    result= [""]*n

    print(sol1)
    print(sol2)

    for i in range(n):
        for j in range(n):
            if(sol1[i][j]==1 or sol2[i][j]==1):
                result[i]+="#"
            else:
                result[i]+=" "

    return result


def toTwo(arr, n):
    result = [[0 for i in range(n)] for j in range(n)]  # 2차원 배열 만들기

    for i in range(len(arr)):  # 입력받은 값을 하나씩 꺼냄
        flag = n - 1
        while arr[i] > 0:  # arr[i]가 0이 될 때까지 반복
            result[i][flag] = arr[i] % 2
            arr[i] //= 2
            flag -= 1
        # arr[i]가 0일 때 추가 작업 필요 없음 (이미 0으로 초기화되어 있음)
    
    return result