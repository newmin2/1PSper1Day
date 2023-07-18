A,B=map(int,input().split()); 0<=A<=23; 0<=B<=59;
C=int(input()); 0<=C<=1000;

if B+C>=60:
    print((A+(B+C)//60)%24, (B+C)%60)

elif B+C<60:
    print(A,B+C)