def solution(s):
    s = s.lower()
    s = list(s)
    if s[0] not in ['0','1','2','3','4','5','6','7','8','9']:
        s[0] = s[0].upper()
    
    for i in range(1, len(s)):
        if s[i-1] == ' ':
            s[i] = s[i].upper()

    answer = ''.join(s)

    return answer