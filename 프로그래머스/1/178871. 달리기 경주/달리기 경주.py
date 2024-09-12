def solution(players, callings):
    pdic = {player: i for i, player in enumerate(players)}

    for call in callings:
        i = pdic[call]
        pdic[call] -= 1
        pdic[players[i-1]] += 1 # gpt
        
        if i > 0:
            players[i-1], players[i] = players[i], players[i-1]
    
    return players