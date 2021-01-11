#include<bits/stdc++.h>
#include <queue>
#include <stack>
#include <string.h>
#include <string>

#define MP make_pair
#define PB push_back
#define ll long long 
#define lli long long int

using namespace std;
lli flag ;				//Variable to check that whether string made by passed integer exists in the grammar or not
string s;				//Variable to store binary string
stack<string>st;		//Used to store transitions
int c;

void print_transitions();
void check_for_parsing(string p);
string DecimalToBinary(int n);


int main()
{
	cout<<"Grammar given is: S -> AA|0, A -> SS|1"<<endl;
    cout<<"Enter a number: ";
	lli t;
	cin>>t;
	
	while(t>40)					//While loop is used to notify user for each wrong input of integer
	{
	    cout<<"Note: Required Number should be less than 41, TRY AGAIN!!"<<endl;
	    cout<<"Enter a number: ";
	    cin>>t;
	}
	if(t==0)
	{
	    s="0";
	}
	else
	{
	    s=DecimalToBinary(t);		//To convert integer to binary string, I have made a function
	}
	
	cout<<t<<" in binary is: "<<s<<endl;

			check_for_parsing("AA");	//This function will check that whether from starting from first transition can we conclude about the string
			check_for_parsing("0");
		
		if(flag==1)						//flag variable is used to check that whether string exists in the grammar
		{
			cout<<s<<" is Acceptable by the grammar"<<endl;		//If string is accepted then print 'yes'
		}
		else
		{
			cout<<s<<" is Not Acceptable by the grammar"<<endl;	//Else print 'no'
		}
}

void print_transitions()
{
	cout<<"Transitions: ";
    stack<string>st2;			//We have define a new stack to reverse the stack st because transitions are in reverse order
    while(st.size()!=0)
    {
        st2.push(st.top());
        st.pop();
    }
    while(st2.size()!=0)
    {
        st.push(st2.top());
        cout<<st2.top()<<"->";
        st2.pop();
    }
}


void check_for_parsing(string p)
{
    if(p.size()>6)			//Since max value of n could be 40 so max size of p can be 6 and if size exceeds then we have to return to ignore infinite loops
    {
        return;
    }
	if(flag==1)				//if value of flag becomes 1 then we have to return to move further.
	{
	    return;
	}
	
	if(p==s)				//if string made becomes equals to binary string then we have to print transitions stored in the stack by calling print_transitions function
	{
	    print_transitions();
	    cout<<p<<endl;
		flag =1;			//flag is redefined as 1 so that later we always know that whether string exists in the grammar or not
		return ;
	}
	lli a = p.size();		//Store size of string that is being made in variable a
	lli b = s.size();		//Store size of binary string in variable b
	a = a - 1;
	if(a>b) 				//This condition will return the code if size of p exceeds the size of s
	{
	   
	    return;			
	}
	st.push(p);				//Since we are using stack st to show transitions so we have to push p into stack
	
	
	for(lli i=0;i<p.size();i++)
	{
	    string g;
	    if(p[i]=='S')		//If ith character is 'S' then we have to run conditions for S
	    {	
	        string j;
	        if(i+1<p.size())
	        {
	            j = p.substr(i+1,p.size()-i-1);
	        }
	        g = p.substr(0,i) + "AA" + j;		//For every transition of S we have to check the condition of parsing
	        check_for_parsing(g);
	        g = p.substr(0,i) + "0" + j;
	        check_for_parsing(g);
	    }
	    if(p[i]=='A')		//If ith character is 'A' then we have to run conditions for A
	    {
	        string j;
	         if(i+1<p.size())
	        {
	            j = p.substr(i+1,p.size()-i-1);
	        }
	        g = p.substr(0,i) + "SS" +j;		//For every transition of A we have to check the condition of parsing
	        check_for_parsing(g);
	        g = p.substr(0,i) + "1" + j;
	        check_for_parsing(g);
	        
	    }
	}
	
	st.pop();
	
}

string DecimalToBinary(int n)		//This function will convert the passed integer into binary string
{ 
  
   string s;
    int i = 0; 
    while (n > 0) { 				//This is the basic loop to find binary equivalent of an integer
  
        lli p = n % 2; 				//Store remainder into p
        if(p==1)
        {
            s=s+'1';
        }
        else
        {
            s=s+'0';
        }
        n = n / 2; 					//Store divident into n
        i++; 
    } 								//After this loop the binary equivalent will get stored in the string s in reverse order
  
    reverse(s.begin(),s.end());		//Now we have to reverse the final string to get final binary equivalent
    return s;						//return the final answer back to main function
} 
