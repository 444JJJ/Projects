#include<iostream>
using namespace std;

//Continue from video 5 in playlist

class student{
private:
    int rollno;
    string name;


public:
    void inputData(){
        cout<<"Enter roll no: "<<endl;
        cin>>rollno;
        cout<<"Enter name"<<endl;
        cin>>name;
    }
    void outputData(){
        cout<<"Your rollno us: "<<rollno;
        cout<<" Your name is: "<<name<<endl;
    }



};


int main(){

    student s1;
    cout<<"----------------InputData----------------"<<endl;
    s1.inputData();
    cout<<"----------------Output----------------"<<endl;
    s1.outputData();




    return 0;
}