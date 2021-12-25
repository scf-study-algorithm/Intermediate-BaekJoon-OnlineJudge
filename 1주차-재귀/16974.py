# L = 0 -> P 
# L = 1 -> B P P P B 
# L = 2 -> B BPPPB P BPPPB B 
# L(N) = B + L(N-1) + P + L(N-1) + B
# 전체 개수 = 2^(n+2)-3
# 패티 개수 = 2^(n+1)-1
b = []
ans = 0
def burger(n, x):
    global ans
    cnt = 2**(n+2)-3
    p = 2**(n)-1        # 이전 레벨의 패티 개수
    
    if n == 0:
        b.append('p')
        return
    
    if (cnt-1)//2 <= x:
        ans += p
        x -= (cnt-1)//2
    
    burger(n-1, x)
    
    
n, x = map(int, input().split())

burger(n, x)

print(ans)