n1 = list(input())
n2 = list(input())

a = 0;
b = 0;
tmp = [0] * len(n1)


for i in range(0,len(n1)):
    if(n1[i] == n2[i]):
        a += 1
        tmp[i] = 1

for i in range(0,len(n1)):
    for j in range(0,len(n1)):
        if(i == j):
            continue
        else:
            if(n1[i] == n2[j] and tmp[i] == 0 and tmp[j] == 0):
                b += 1

print("{}A{}B".format(a,b))