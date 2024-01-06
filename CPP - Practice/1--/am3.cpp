#include<iostream>
#include<string>
using namespace std;

class Books{
    public:
    void setName(string x){
        name=x;
    }
    string getName(){
        return name;
    }


    private:
    string name;

};


int main(){
    Books b1;

    b1.setName("C++ getters and Setters");
    
    cout<<b1.getName()<<endl;



    return 0;
}