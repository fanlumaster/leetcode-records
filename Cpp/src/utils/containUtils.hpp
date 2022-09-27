#pragma once
#include <iostream>
#include <vector>

using namespace std;

namespace fany
{
    void printVector(vector<int> &myVec)
    {
        for (int i = 0; i < myVec.size(); i++)
        {
            cout << myVec[i] << " ";
        }
        cout << "\n";
    }
}