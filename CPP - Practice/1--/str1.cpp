#include<iostream>
using namespace std;


struct User{
    string fName;
    string lName;
    

   string getStatus(){
    return status;
   }

   private:
   string status;

};


int main(){
    User me;
    me.fName="Joe";
    me.lName="Battery";
    me.getStatus()="Gold";

    cout<<me.fName<<" "<<me.lName<<" "<<me.getStatus()<<endl;

    

    return 0;
}