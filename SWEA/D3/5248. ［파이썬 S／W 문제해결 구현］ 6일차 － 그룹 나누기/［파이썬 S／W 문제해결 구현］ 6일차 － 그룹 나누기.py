T = int(input())
for test_case in range(1, T + 1):
    N, M = map(int, input().split())
    data = list(map(int, input().split()))

    form = []
    for i in range(0, len(data), 2):
        form.append([data[i], data[i + 1]])

    teams = []

    for a, b in form:
        merged = []
        for team in teams:
            if a in team or b in team:
                merged.append(team)
        if not merged:
            teams.append([a, b])
        else:
            for team in merged:
                teams.remove(team)
            new_team = [a, b]
            for team in merged:
                new_team.extend(team)
            teams.append(list(set(new_team)))

    all_grouped = set()
    for team in teams:
        all_grouped.update(team)

    for i in range(1, N + 1):
        if i not in all_grouped:
            teams.append([i])

    print(f"#{test_case} {len(teams)}")
