def state0(string,i,n,prev_state):
    ans="No"
    if i!=0:
        print(string[i-1],": From "+ prev_state + " to state0")
    if i==n:
        return "Yes"
    elif string[i]=='1':
        ans=state0(string,i+1,n,"state0")
    elif string[i]=='0':
        ans=state1(string,i+1,n,"state0")
    return ans

def state1(string,i,n,prev_state):
    ans="No"
    print(string[i-1],": From "+ prev_state + " to state1")
    if i==n:
        return "No"
    elif string[i]=='1':
        ans=state1(string,i+1,n,"state1")
    elif string[i]=='0':
        ans=state0(string,i+1,n,"state1")
    return ans


string=input("Enter string: ")
n=len(string)
if n==0:
    print("Yes")
else:
    ans=state0(string,0,n,"null_state")
    print(ans)