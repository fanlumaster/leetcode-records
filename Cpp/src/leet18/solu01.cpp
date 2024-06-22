#include <iostream>
#include <vector>
#include "ContainerUtils.h"

using namespace std;

// class Solution {
// public:
//     vector<vector<int>> fourSum(vector<int>& nums, int target) {

//     }
// };

vector<int> testVector()
{
    vector<int> myarr{1, 2, 3, 4, 5, 65};
    myarr.insert(myarr.end(), 1234);
    myarr.insert(myarr.end(), 45);
    myarr.insert(myarr.end(), 67);
    myarr.insert(myarr.end(), 89);
    return myarr;
}

int main(int argc, char const *argv[])
{
    vector<int> res = testVector();
    fany::printVector(res);

    return 0;
}
