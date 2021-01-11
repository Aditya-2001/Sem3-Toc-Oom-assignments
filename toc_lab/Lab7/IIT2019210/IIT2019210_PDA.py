stack = ['z']               #Defining the stack which initially has 'z'
def state0(string,index,lastState):     #This is staring state q0 and it takes string, current index and last state as the parameters
    if index!=0:                        #For index=0 there is no meaning of print statement
        print(lastState + " --> q0 , Stack: ",stack)
    if index==len(string):              #if it index reaches end of string then string does not exists in PDA so exitCode is called
        exitCode(string)
    if string[index]=='a':              #If character at index is 'a' then it is pushed into stack and state0 is called with index+1, lastState as q0
        stack.append(string[index])
        print(string[index],end=": ")
        state0(string,index+1,'q0')
    elif string[index]=='b':            #If character at index is 'b' then state1 is called with index+1 and q0 as lastState
        print(string[index],end=": ")
        state1(string,index+1,'q0')
    else:                               #If there is any other character at this index then string will not exist and we exit from code
        exitCode(string)

def state1(string,index,lastState):     #This is q1 state and it also takes string, current index and last state as the parameters
    print(lastState + " --> q1 , Stack: ",stack)
    if index==len(string):               #if it index reaches end of string then string does not exists in PDA so exitCode is called
        exitCode(string)
    if string[index]=='b':               #If character at index is 'b' then one character is poped from stack and state2 is called with index+1 and q1 as lastState
        stack.pop()
        print(string[index],end=": ")
        state2(string,index+1,'q1')
    else:                               #If there is any other character at this index then string will not exist in PDA and we exit from code
        exitCode(string)

def state2(string,index,lastState):     #This q2 state and it also takes string, current index and last state as the parameters
    print(lastState + " --> q2 , Stack: ",stack)
    if index==len(string):              #If end of string is reached then there are 2 possibilities
        if len(stack)==1 and stack[0]=='z':    #First: is that only 'z' is remaining in stack in that case we jumped to final state q3
            print("ε",end=": ")
            state3(string,lastState)
        else:                                  #Second: If String does not exist in PDA and we exit from code     
            exitCode(string)
    elif string[index]=='b':            #If character at index is 'b' then state1 is called with index+1 and q2 as lastState
        print(string[index],end=": ")
        state1(string,index+1,'q2')
    else:                               #Else we exit from code
        exitCode(string)

def state3(string,lastState):       #This q3 (final) state and takes string and lastState as parameters
    print(lastState + " --> q3 , Stack: ",stack)
    print(string + " is accepted by this PDA")  #If any string reaches this state then it is accepted by PDA

def exitCode(string):               #This is exit function which when called ends the code
    print("Finally, the stack is: ",stack)
    if(len(string)==0):
        string='ε'
    print(string + " is not accepted by this PDA")
    exit(-1)

inputString = input("Enter String: ")   #A string is taken as input and stored in a variable
state0(inputString,0,'0')               #State0 is called with inputString, index=0, no last state