from itertools import permutations

def solution(k, dungeons):
    permutation_list = list(permutations(dungeons)) # 모든 경우의 수
    max_dungeons = 0

    for dungeon in permutation_list:
        current_p = k
        count = 0
        for need_p, use_p in dungeon:
            if need_p <= current_p:
                current_p -= use_p
                count += 1
            else:
                break
        if count > max_dungeons:
            max_dungeons = count
            
    return max_dungeons
