import sys

T = int(sys.stdin.readline())

res = []
for i in range(0, T):
    _, idx = map(int, sys.stdin.readline().split())
    inp = list(map(int, sys.stdin.readline().split()))
    Q = []
    for i, t in enumerate(inp):
        Q.append([t, i])

    while Q:
        tmp = sorted(Q, key=lambda x: x[0], reverse=True)

        n = Q.pop(0)

        if tmp[0][0] > n[0]:
            Q.append(n)
        elif tmp[0][1] == idx:
            print(len(inp)-len(Q))
            break