def state0(string,i,n,prev_state):      #It has input list, current dfa index, length of list and previous state(that from which state it had arrived)
    if i!=0:                            #If index is non zero then the transition would be printed 
        print(string[i-1],": From "+ prev_state + " to state0")
    if i==n:                            #If index value becomes size of list then string is not valid
        notValid()
    elif string[i]=='5':                #If string/value at index is 5 then transition is done to state1 with index=index+1 and state0 as previous state
        state1(string,i+1,n,"state0")
    elif string[i]=='10':               #If string/value at index is 10 then transition is done to state2 with index=index+1 and state0 as previous state
        state2(string,i+1,n,"state0")
    elif string[i]=='25':               #If string/value at index is 25 then transition is done to state5 with index=index+1 and state0 as previous state
        state5(string,i+1,n,"state0")
    notValid()                          #If string/value at index is none of the above then it is invalid         

def state1(string,i,n,prev_state):
    print(string[i-1],": From "+ prev_state + " to state1")
    if i==n:                    
        notValid()
    elif string[i]=='5':                 
        state2(string,i+1,n,"state1") 
    elif string[i]=='10':             
        state3(string,i+1,n,"state1")
    elif string[i]=='25':                
        state5(string,i+1,n,"state1")
    notValid()                         

def state2(string,i,n,prev_state):     
    print(string[i-1],": From "+ prev_state + " to state2")
    if i==n:
        notValid()
    elif string[i]=='5':
        state3(string,i+1,n,"state2")
    elif string[i]=='10':
        state4(string,i+1,n,"state2")
    elif string[i]=='25':
        state5(string,i+1,n,"state2")
    notValid()                          

def state3(string,i,n,prev_state):     
    print(string[i-1],": From "+ prev_state + " to state3")
    if i==n:
       notValid()
    elif string[i]=='5':
        state4(string,i+1,n,"state3")
    elif string[i]=='10' or string[i]=='25':
        state5(string,i+1,n,"state3")
    notValid()                          

def state4(string,i,n,prev_state):     
    print(string[i-1],": From "+ prev_state + " to state4")
    if i==n:
        notValid()
    elif string[i]=='5' or string[i]=='10' or string[i]=='25':
        state5(string,i+1,n,"state4")
    notValid()                          

def state5(string,i,n,prev_state): 
    print(string[i-1],": From "+ prev_state + " to state5")
    if i==n:                                         #If index value becomes size of list then string is valid, because state5 is final state 
        valid()
    elif string[i]=='5' or string[i]=='10' or string[i]=='25':
        state5(string,i+1,n,"state5")
    notValid()  
    
def notValid():                         #Not a state but a function to exit and print "no" message
    print("Not Accepted")
    exit(-1)

def valid():                            #Not a state but a function to exit and print "yes" message
    print("Accepted")
    exit(1)

string=input("Enter string(use space to separate the coins): ").split(" ")
n=len(string)                           #length of string/list is stored in variable n
if string[n-1]=='':                     #Sometimes user may give space at the end so in that case the list generated would have '' at the end so we have to remove it
    string.pop()                        #If it is present the we poped it
    n=n-1                               #Since we poped one element so size of list reduces by 1

print("Input Array is: ",end="")        #print statement to show user the list that he had input
print(string)

if n==0:                                #If length is 0, then this means no coin has been put so it will call notValid function
    notValid()
state0(string,0,n,"null_state")
#if length is non zero, then state0/q0 is called with passed parameters as input list
#i is the index of list which is initially 0
#Since initially there is no state for dfa so i say it "null_state" 


#In transition diagram I have made with q0,q1,q2..,q5
#Here q0 is equivalent to state0 or q[i] is same as state[i] where i=0,1...,5