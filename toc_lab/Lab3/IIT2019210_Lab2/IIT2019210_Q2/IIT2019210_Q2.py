def state0(string,i,n,prev_state):
    ans="No"
    if i!=0:
        print(string[i-1],": From "+ prev_state + " to state0")
    if i==n:
        return "Yes"
    elif string[i]=='a' and string[i+1]=='b':
        ans=state2(string,i+1,n,"state0")
    elif string[i]=='a' :
        ans=state1(string,i+1,n,"state0")
    return ans

def state1(string,i,n,prev_state):
    ans="No"
    print(string[i-1],": From "+ prev_state + " to state1")
    if i==n:
        return "Yes"
    elif string[i]=='a':
        ans=state1(string,i+1,n,"state1")
    return ans

def state2(string,i,n,prev_state):
    ans="No"
    print(string[i-1],": From "+ prev_state + " to state2")
    if i==n:
        return "No"
    elif string[i]=='b':
        ans=state3(string,i+1,n,"state2")
    return ans

def state3(string,i,n,prev_state):
    ans="No"
    print(string[i-1],": From "+ prev_state + " to state3")
    if i==n:
        return "Yes"
    elif string[i]=='a':
        ans=state2(string,i+1,n,"state3")
    return ans

string=input("Enter string: ")
n=len(string)
ans=state0(string,0,n,"null_state")
print(ans)