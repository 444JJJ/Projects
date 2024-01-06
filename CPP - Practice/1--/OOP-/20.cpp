#include<iostream>
using namespace std;

//Default copy constructor

class Test{
private:
    const int n;
public:
    Test():n(10){
        

    }


    void setValue(int x){
        n=x;
        cout<<"N: "<<n<<endl;
    }
    


};


int main(){

    Test T;
    T.setValue(30);



    return 0;
}