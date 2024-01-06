#include<iostream>
using namespace std;

class Test{
private:
    int n;
public:
    void inputData(){
        cout<<"Enter number: ";
        cin>>n;
    }
    void outputData(){
        cout<<"The value of n is "<<n<<endl;
    }

};


int main(){
    Test t1;
    t1.inputData();
    t1.outputData();



    return 0;
}