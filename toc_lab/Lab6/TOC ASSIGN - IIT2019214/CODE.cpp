
//C++ program that checks whether the given string is accepted by the grammar or not.
#include <bits/stdc++.h>
using namespace std;

#define lli long long int

vector<string> vS;
vector<string> vE;

lli flag;
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

bool terminal(string str)
{
    for (int i = 0; i < str.size(); i++)
    {
        if (str[i] == 'E' || str[i] == 'S')
        {
            return false;
        }
    }
    return true;
}

int c;
void find(string p)
{
    if (flag == 1)
    {
        return;
    }

    if (p == s && terminal(p))
    {
        print();
        cout << p << endl;
        flag = 1;
        return;
    }
    lli a = p.size();
    lli b = s.size();
    a = a - 0;
    if (a > b)
    {
        return;
    }
    st.push(p);

    string g;
    for (lli i = 0; i < p.size(); i++)
    {
        if (flag == 1)
        {
            return;
        }

        if (p[i] == 'S')
        {
            string j;
            if (i + 1 < p.size())
            {
                j = p.substr(i + 1, p.size() - i - 1);
            }
            g = p.substr(0, i) + "(E)" + j;
            find(g);
            g = p.substr(0, i) + "E+E" + j;
            find(g);
        }
        if (p[i] == 'E')
        {
            string j;
            if (i + 1 < p.size())
            {
                j = p.substr(i + 1, p.size() - i - 1);
            }
            g = p.substr(0, i) + "S" + j;
            find(g);
            g = p.substr(0, i) + "0" + j;
            find(g);
            g = p.substr(0, i) + "1" + j;
            find(g);
        }
    }

    st.pop();
}

int main()
{
    cout << "Input the string to check:: ";
    cin >> s;
    find("(E)");
    find("E+E");

    if (flag == 1)
    {
        cout << "YES";
    }
    else
    {
        cout << "NO";
    }
    cout << endl;
}
