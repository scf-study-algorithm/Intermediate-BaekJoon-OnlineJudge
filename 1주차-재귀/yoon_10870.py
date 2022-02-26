def Fibonacci(n):
    if n==0:
        return 0
    elif n==1:
        return 1
    else:
        print("count",n,">>>>>",Fibonacci(n-1)+Fibonacci(n-2))
        return Fibonacci(n-1)+Fibonacci(n-2)
        #for example,
        # enter 4 -> 3, 2
        # 1) 3 -> 2 -> 1 => 1
        #      -> 1 -> 1 => 1
        # 2) 2 -> 1 => 1
        #      -> 0 => 0
        # total => 3
        # idiot



n = int(input())
print(Fibonacci(n))