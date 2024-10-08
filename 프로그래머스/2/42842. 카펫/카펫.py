def solution(brown, yellow):
    sumAll = brown + yellow
    answer = []

    for i in range (1, int(sumAll ** 0.5) + 1):
        j = sumAll // i
        if sumAll % i == 0:
            if (i - 2) * (j - 2) == yellow:
                if i > j:
                    answer.append(i)
                    answer.append(j)
                else:
                    answer.append(j)
                    answer.append(i)

                return answer