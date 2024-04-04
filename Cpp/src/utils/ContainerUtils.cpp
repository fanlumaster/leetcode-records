#include "ContainerUtils.h"

void fany::printVector(vector<int> &myVec) {
    cout << '[';
    for (unsigned int i = 0; i < myVec.size(); i++) {
        if (i < myVec.size() - 1)
            cout << myVec[i] << ", ";
        else
            cout << myVec[i];
    }
    cout << ']';
    cout << "\n";
}
