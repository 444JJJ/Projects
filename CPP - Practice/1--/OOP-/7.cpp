#include<iostream>
using namespace std;

class Test{

private:
    int n;

public:
    Test(){
        cout<<"Construcor is called.."<<endl;
        n=0;
    }

    void display(){
        cout<<n<<endl;
    }





};




int main(){
    Test T;
    T.display();






    return 0;
}