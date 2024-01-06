#include<iostream>
using namespace std;

class Test{
private:
    int n;
public:
    Test():n(0){
        cout<<"Constructor is called..."<<endl;
    }
    void setValue(int num){
        n=num;
    }
    int getValue(){
        return n;
    }
};