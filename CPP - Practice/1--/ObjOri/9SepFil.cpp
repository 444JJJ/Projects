#include<iostream>
using namespace std;


class Test{
private:
    int n;

public:
    Test():n(0){
        cout<<"construtor is called"<<endl;
    }

    void setValue(int num){
        n=num;
    }
    int getValue(){
        return n;
    }
};


int main(){
    Test t1;
    t1.setValue(20);
    cout<<"The value of n is: "<<t1.getValue()<<endl;


    return 0;
}