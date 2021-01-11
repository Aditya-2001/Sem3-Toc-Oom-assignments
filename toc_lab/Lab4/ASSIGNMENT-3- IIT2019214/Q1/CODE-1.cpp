//C++ program that checks given string is accpeted by the grammar or not.
#include <bits/stdc++.h>
using namespace std;
#define MP make_pair
#define PB push_back
#define ll long long
#define lli long long int

using namespace std;

lli flag;

int n = 58;
int m = 1;
vector<vector<string> > vec(n, vector<string>(m, "."));

string s;

stack<string> st;

void print()
{
    stack<string> st2;
    while (st.size() != 0)
    {
        st2.push(st.top());
        st.pop();
    }
    while (st2.size() != 0)
    {
        st.push(st2.top());
        cout << st2.top() << "->";
        st2.pop();
    }
}

void find(string p)
{
    if (flag == 1)
    {
        return;
    }
    if (p == s)
    {
        cout << "Found" << endl;
        print();
        cout << p << endl;
        flag = 1;
        return;
    }
    if (p.size() - 1 > s.size())
    {
        return;
    }
    st.push(p);

    for (lli i = 0; i < p.size(); i++)
    {
        char o = p[i];
        for (lli j = 1; j < vec[o - 'A'].size(); j++)
        {
            string k;
            if (vec[o - 'A'][j] == "#")
            {
                k = p.substr(0, i) + p.substr(i + 1, p.size() - i - 1);
            }
            else
            {
                k = p.substr(0, i) + vec[o - 'A'][j] + p.substr(i + 1, p.size() - i - 1);
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
    cout << endl;

    vector<string> ini;
    lli r = 1;
    while (p--)
    {
        r++;
        char a;
        string b;
        cin >> a >> b;
        vec[a - 'A'].push_back(b);
        if (a == 'S')
        {
            ini.push_back(b);
        }
    }
 
    cout << endl;
    
        cout << "Enter string to check " << endl;
        flag = 0;

        cin >> s;

        for (lli i = 0; i < ini.size(); i++)
        {
            string l = ini[i];
            find(l);
        }

        if (flag == 1)
        {
            cout << s << " is Acceptable " << endl;
        }
        else
        {
            cout << s << " is Not Acceptable " << endl;
        }
        cout << "-------------------" << endl;

}
