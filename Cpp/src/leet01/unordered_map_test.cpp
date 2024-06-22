#include <iostream>
#include <unordered_map>

using namespace std;

int main(int argc, char const *argv[])
{
    unordered_map<int, int> hashtable;
    hashtable.insert({1, 1});
    unordered_map<int, int>::iterator iter;
    for (iter = hashtable.begin(); iter != hashtable.end(); iter++)
    {
        cout << iter->first << ", " << iter->second << '\n';
    }

    return 0;
}
