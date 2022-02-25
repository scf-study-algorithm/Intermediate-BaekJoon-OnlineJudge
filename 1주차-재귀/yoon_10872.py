def Factorial(n):
    if n <= 1:
        return 1
    else:
        return n * Factorial(n-1)
        #예를 들어 
        # 10 일때 -1 을 하면서 1이 나올때 까지 수를 나열해간다.

n = int(input())

res = Factorial(n)
print(res)