#include<iostream>
using namespace std;

class Test{
private: 
    int n;
public:
    Test(){
        cout<<"Constructor is called..."<<endl;
    }
    ~Test(){
        cout<<"Destructor is called.."<<endl;
    }
    void objCreate(){
        Test T1,T2;;
    }
   


};



int main(){

    objCreate();    




    return 0;
}