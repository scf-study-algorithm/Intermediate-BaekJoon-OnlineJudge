n = input()
x = []
result=''
for i in range(len(n)):
    x.append(n[i])
x.sort(reverse=True)

for i in range(len(x)):
    result += x[i]
print(result)