def state0(string,i,n,prev_state):              #State0 is similar to q0 in diagram and has 4 function arguments: String, index, string length and last state
    if i!=0:
        print(string[i-1],": From "+ prev_state + " to state0")
    if i==n:                                    #It is non accepting state so for full string length it would show error
        notValid()
    elif string[i]=='0' or string[i]=='1':      #For any 0 or q it goes to state1
        ans=state1(string,i+1,n,"state0")
    notValid()

def state1(string,i,n,prev_state):          #Similar to q1 in diagram
    print(string[i-1],": From "+ prev_state + " to state1")
    if i==n:
        valid()
    elif string[i]=='0':
        ans=state1(string,i+1,n,"state1")
    elif string[i]=='1':
        ans=state2(string,i+1,n,"state1")
    notValid()

def state2(string,i,n,prev_state):          #Similar to q2 in diagram
    print(string[i-1],": From "+ prev_state + " to state2")
    if i==n:
        notValid()
    elif string[i]=='1':
        ans=state3(string,i+1,n,"state2")
    elif string[i]=='0':
        ans=state4(string,i+1,n,"state2")
    notValid()

def state3(string,i,n,prev_state):          #Similar to q3 in diagram
    print(string[i-1],": From "+ prev_state + " to state3")
    if i==n:
        valid()
    elif string[i]=='1':
        ans=state2(string,i+1,n,"state3")
    elif string[i]=='0':
        ans=state4(string,i+1,n,"state3")
    notValid()

def state4(string,i,n,prev_state):          #Similar to q4 in diagram
    print(string[i-1],": From "+ prev_state + " to state4")
    if i==n:
        notValid()
    elif string[i]=='1' or string[i]=='0':
        ans=state4(string,i+1,n,"state4")
    notValid()
    
def notValid():                         #Not a state but a function to exit and print "no" message
    print("Not Accepted")
    exit(-1)

def valid():                            #Not a state but a function to exit and print "yes" message
    print("Accepted")
    exit(1)

string=input("Enter string: ")          #Scanning string
n=len(string)                           #Store lengths of string in n
if n==0:                                #IF null string is given then error would be shown
    print("Null String:",end=" ")
    notValid()
else:
    state0(string,0,n,"null_state")     #Else it will go for dfa start state