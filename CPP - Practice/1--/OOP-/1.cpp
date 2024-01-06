#include<iostream>
using namespace std;

class Test{
    private:
    int n=10;
    public:
    void show(){
        cout<<"The value of n: "<<n<<endl;
    }
};


int main(){

    Test t1;
    t1.show();




    return 0;
}