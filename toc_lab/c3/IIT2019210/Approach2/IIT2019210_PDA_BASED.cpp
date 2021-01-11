//I have created using DFA but since its a cfg so always for cfg there exists a PDA

#include<bits/stdc++.h>
using namespace std;

long long int flag ;
int n = 100,m = 1,c; 
vector<vector<string> > vec( n , vector<string> (m, ".")); 
string s;
stack<string>st;
void print();
void search(string p);

int main()
{
		vec['S'-'A'].push_back("ABC");
		vec['A'-'A'].push_back("0");
		vec['A'-'A'].push_back("1");
		vec['B'-'A'].push_back("0B");
		vec['B'-'A'].push_back("#");
		vec['C'-'A'].push_back("11C");
		vec['C'-'A'].push_back("#");
		cout<<"Enter String: ";
		flag =0;
	
		cin>>s;
		search("ABC");
		
		if(flag==1)
		{
			cout<<"Accepted "<<endl;
		}
		else
		{
			cout<<"Not Accepted "<<endl;
		}
		cout<<endl;
}

void search(string p)
{
   	if(flag==1)
	{
	    return;
	}
	
	if(p==s)
	{
	    print();
	    cout<<p<<endl;
		flag =1;
		return ;
	}
	long long int a = p.size();
	long long int b = s.size();
	a = a - 15;
	if(a>b) 
	{
	    return;
	}
	st.push(p);
	
	
	for(long long int i=0;i<p.size();i++)
	{
	    char o = p[i];
		for(long long int j=1;j<vec[o -'A'].size();j++)
		{
			string k;
			if(vec[o-'A'][j]== "#")
			{
				k = p.substr(0,i) +  p.substr(i+1,p.size()-i-1);
			}
			else
			{
				k = p.substr(0,i) + vec[o-'A'][j] + p.substr(i+1,p.size()-i-1);
			}
			search(k);
		}
	}
	st.pop();
	
}

void print()
{
    stack<string>st2;
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
