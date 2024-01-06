#include<iostream>
using namespace std;

class Cars{
private:
    string companyName;
    string modelName;
public:

    Cars(){
        companyName="Toyota";
    }

    Cars(string cName,string mName){
        companyName=cName;
        modelName=mName;
    }
    
    Cars(Cars &obj){
        companyName=obj.companyName;
        modelName=obj.modelName;
    }

    

    void setData(string company_Name,string model_Name){
        companyName=company_Name;
        modelName=model_Name;
    }

    void display(){
        cout<<"-------------Vehicle Properties----------------"<<endl;
        cout<<"Vehicle Make: "<<companyName<<endl;
        cout<<"Vehicle Model: "<<modelName<<endl;
    }

    ~Cars(){
        cout<<"desctructor called"<<endl;
    }

};


int main(){
    Cars c1;
    c1.display();
    Cars c2("Toyota", "4Runner");
    c2.display();

    Cars c3=c2;
    c3.display();
    




    return 0;
}