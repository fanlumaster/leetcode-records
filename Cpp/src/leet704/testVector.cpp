#include <iostream>
#include <vector>

using namespace std;

int main(int argc, char const *argv[])
{
    vector<int> myVec01;
    for (int i = 0; i < 10; i++)
    {
        myVec01.push_back(i + 1);
    }
    for (int i = 0; i < myVec01.size(); i++)
    {
        cout << myVec01[i] << " ";
    }
    cout << "\n";
    cout << "========\n";

    vector<int> myVec02{2, 5, 8, 1, 6};
    for (int i = 0; i < myVec02.size(); i++)
    {
        cout << myVec02[i] << " ";
    }
    cout << "\n";

    vector<int> myVec03(12);
    for (int i = 0; i < myVec03.size(); i++)
    {
        cout << myVec03[i] << " ";
    }
    cout << "\n";

    vector<int> myVec04(12, 3);
    for (int i = 0; i < myVec04.size(); i++)
    {
        cout << myVec04[i] << " ";
    }
    cout << "\n";

    vector<int> myVec05{1, 2, 3, 4};
    for (int i = 0; i < myVec05.size(); i++)
    {
        cout << myVec05[i] << " ";
    }
    cout << "\n";
    cout << "size and capcity after initializing: \n";
    cout << myVec05.size() << endl;
    cout << myVec05.capacity() << endl;
    myVec05.push_back(12);
    cout << "size and capcity after expanding: \n";
    cout << myVec05.size() << endl;
    cout << myVec05.capacity() << endl;
    myVec05.clear();
    cout << "size and capcity after clearing: \n";
    cout << myVec05.size() << endl;
    cout << myVec05.capacity() << endl;
    myVec05.shrink_to_fit();
    cout << "size and capcity after shrinking: \n";
    cout << myVec05.size() << endl;
    cout << myVec05.size() << endl;

    return 0;
}
