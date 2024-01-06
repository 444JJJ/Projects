#include<iostream>
using namespace std;

class Book{
private:
    string name;
    int pages;
    float price;
public: 

    void setName(string sName){
        name=sName;
    }
    void setPages(int sPages){
        pages=sPages;
    }
    void setPrice(float sPrice){
        price=sPrice;
    }

    string getName(){
        return name;
    }
    int getPages(){
        return pages;
    }
    float getPrice(){
        return price;
    }




};


int main(){

    Book b1;

    b1.setName("Awsome Programming");
    b1.setPages(1003);
    b1.setPrice(10.235);

    cout<<"The name of the book is: "<<b1.getName();
    cout<<", it has "<<b1.getPages()<<" number of pages";
    cout<<", and costs "<<b1.getPrice()<<" GBP"<<endl;;




    return 0;
}