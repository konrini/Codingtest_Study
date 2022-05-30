# 테스트 케이스의 수
T = int(input())
for test_case in range(1, T + 1):
    # N : 배열의 크기, M : 나라의 개수 
    N, M = map(int, input().split())
    # 지도
    board = [[] * N] * N
    # 각 나라의 위치
    location = [[0, 0]] * M
    for i in range(N):
        board[i] = list(map(int, input().split()))
        for j in range(N):
            if board[i][j] != 0:
                location[board[i][j] - 1] = [i, j]
    # 누적 거리
    dist = 0
    # 현재 위치
    now = [0, 0]
    for i in range(M):
        # 가고자 하는 나라 위치 
        target = location[i]
        r = abs(target[0] - now[0])
        r = min(N - r, r)
        dist += r
        c = abs(target[1] - now[1])
        c = min(N - c, c)
        dist += c
        # 현재값 갱신
        now[0] = target[0]
        now[1] = target[1]
    print(f'#{test_case} {dist}')