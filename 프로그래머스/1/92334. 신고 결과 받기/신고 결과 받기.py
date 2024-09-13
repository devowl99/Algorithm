def solution(id_list, report, k):
    user_reports = {user: [] for user in id_list}
    report_count = {user: 0 for user in id_list}

    for rep in report:
        reporter, target = rep.split(' ')

        if target not in user_reports[reporter]:
            user_reports[reporter].append(target)
            report_count[target] += 1

    banned_users = []
    for user, count in report_count.items():
        if count >= k:
            banned_users.append(user)
            
    result = {user: 0 for user in id_list}
    for reporter in id_list:
        for target in user_reports[reporter]:
            if target in banned_users:
                result[reporter] += 1
    
    return list(result.values())