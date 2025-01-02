def solution(s):
    trans = 0
    total_0 = 0

    while s != '1':
        count_0 = s.count('0')
        total_0 += count_0
        s = s.replace('0', '')

        s = bin(len(s))[2:]  # 길이를 이진 변환
        trans += 1

    return [trans, total_0]