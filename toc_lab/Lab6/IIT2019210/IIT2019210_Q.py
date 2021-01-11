def check_transition_1(string,mystr,i,length):
    global final                    #global variable to store final string
    print(mystr,end='->')           #Print statement to print the transitions    
    if len(mystr)>=length:          #Condition to return to main function
        final=mystr
        return 
    if string[i]==mystr[i]:         #if character at ith index matches then skip and proceed further
        check_transition_1(string,mystr,i+1,length)
    elif string[i]=='(':            #if character at ith index is ( then call second function
        check_transition_2(string,mystr,i,length)
    else:                           #Else it will add S to mystr
        newstr=mystr+'+S'
        check_transition_1(string,newstr,i+1,length)

def check_transition_2(string,mystr,i,length):
    n=0
    mystr2='S'
    for j in range(i+1,len(string)):        #loop will tell how many characters are their between ( and )
        if string[j]==')':
            break
        n=n+1
    x=len(mystr2)
    while x<n:                              #Iterated to add S till length matched to passed string
        mystr2=mystr2 + '+S'
        x=x+2
    mystr2 = '(' + mystr2 + ')'
    mystr=mystr[:i]+mystr2+mystr[i+1:]      #mystr is updated
    check_transition_1(string,mystr,i+n,length) #Again function 1 is called



#Main Function
string=input('Enter the string: ')
mystr='S'           #String where we will perform first 3 transitions
final=''            #String where final string after performing first 3 transitions will be stored
print("Transitions: ",end='')
check_transition_1(string,mystr,0,len(string))      #this function takes 4 parameters(both strings, index and string length)
if len(string)==len(mystr):                         #If final made string has length more than mystr then it will exit
    print("No,",string,"can not be parsed!!!")
    exit(0)
for i in range(0,len(string)):              #Checking for the extra variables, if there passed then we have to exit
    if string[i]==final[i]:
        if string[i]=='(' or final[i]==')' or final[i]=='+':        #if S is also a charcter then it will exit
            continue
        else:
            print("No,",string,"can not be parsed!!!")
            exit(0)
    else:
        if final[i]=='S':                    #If in place of S there is any other character then it will exit
            if string[i]=='0' or string[i]=='1':
                final = final[:i] + string[i] + final[i + 1:]       #If we got write character then transition is done for T->0 or T->1
            else:
                print("No,",string,"can not be parsed!!!")
                exit(0)
        else:
            print("No,",string,"can not be parsed!!!")
            exit(0)
print(final)            #Printing final string after all productions
print("Yes,",string,"can be parsed!!!")            #If it had reached here and code had not been terminated yet then string can be parsed