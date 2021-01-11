#Here, for this question I have taken grammar to make a palindromic string be:
#S -> aAa | aSa | c | ε
#A -> bAb | ε




global arr
#Global array to store all the resulting arrays

def state_S(text,n,enable_epsilon,from_state):
    if len(text)>=1:
        print("Transition: ",from_state," --> S ,   String becomes: ",text)
    if len(text)>=n:
        print("Final Transition:  S  --> S ,   Final String: ",text[:int(n/2)]+'ε'+text[int(n/2):])
        print()
        arr.append(text)
        return 
    if len(text)==n-1 and enable_epsilon==False:
        t=n-1
        t=int(t/2)
        text=text[:t]+'c'+text[t:]
        print("Final Transition:  S  --> S ,   Final String: ",text)
        print()
        arr.append(text)

    if len(text)<=n-2:
        text='a'+text+'a'
        state_S(text,n,enable_epsilon,'S')
    return

def state_A(text,n,enable_epsilon,from_state):
    if len(text)>=1:
        print("Transition: ",from_state," --> A ,   String becomes: ",text)
    if len(text)>=n:
        arr.append(text)
        return
    state_S(text,n,enable_epsilon,'A')
    if len(text)<=n-4:
        text='b'+text+'b'
        state_A(text,n,enable_epsilon,'A')
    return


print("Grammar is: ")
print("S -> aAa | aSa | c | ε")
print("A -> bAb | ε")
n=int(input("Enter length of palindromic string: "))
enable_epsilon=False
if n%2==0:
    enable_epsilon=True
text=""
arr=[]
state_A(text,n,enable_epsilon,'ε')
print("Palindromic strings of given length for this grammar: ")
if n==0:
    print('ε')
    exit(-1)
for each in arr:
    print(each)