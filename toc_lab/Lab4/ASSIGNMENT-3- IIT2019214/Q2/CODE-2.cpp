//C++ program that outputs palindrome string for a given length of string.
#include <bits/stdc++.h>
using namespace std;
#define MP make_pair
#define PB push_back
#define ll long long 
#define lli long long int


  
using namespace std;

lli flag ;
lli sze;
	int n = 58; 
		int m = 1; 
		vector<vector<string> > vec( n , vector<string> (m, ".")); 

string s;

stack<string>st;

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


bool pallin(string l)
{
    
    for(lli i=0;i<l.size();i++)
    {
        if(l[i]!=l[l.size()-i-1])
        {
            return false;
        }
        if(vec[l[i]-'A'].size()>1)
        {
            return false;
        }
    }
    
    return true;
}


void find(string p)
{
		if(p.size()==sze && pallin(p) )
	{
	    
	    cout<<"Found-> "<<p<<endl;
	    print();
	    cout<<p<<endl;
		flag =1;
		cout<<"-------------"<<endl;
		return ;
	}
	lli a = p.size();
	lli b = s.size();
	a = a - 10;
	if(a>b) 
	{
	    //cout<<a<<"--"<<b<<" so ===";
	    //cout<<"3"<<endl;
	    return;
	}
	st.push(p);
	for(lli i=0;i<p.size();i++)
	{
		char o = p[i];
		for(lli j=1;j<vec[o -'A'].size();j++)
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
		 	//cout<<k<<endl;
			find(k);
		}
		
	}
	st.pop();
	
}


int main()
{
		cout << "Enter number of rules:- " << endl;
    lli p;
    cin >> p;
    cout << "Enter rules line by line starting with a character denoting the Non terminal,"<<endl<< "then a space, then a string consisting of Terminals and Non Terminals " << endl;
		

		lli arr[n][2];
		
		cout<<endl;
		vector<string> ini;
		while(p--)
		{
			char a;
			string b;
			cin>>a>>b;
			vec[a-'A'].push_back(b);
			if(a=='S')
			{
			    ini.push_back(b);
			}
		}
		
		cout<<"Input the size of string required :: ";
		cin>>sze;
		cout<<sze<<endl;
		flag=0;
		for(lli i=0;i<ini.size();i++)
		{
			string l = ini[i];
			find(l);	
		}
	
	
	    if(flag ==0)
	    {
	        cout<<"No pallindrome string found "<<endl;
	    }
	
	
	

}
