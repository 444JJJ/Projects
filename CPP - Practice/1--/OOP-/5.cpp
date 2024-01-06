#include<iostream>
#include<string>
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

    void display(string name, int pages, float price){
        cout<<endl;
        cout<<"The name of the book is "<<name;
        cout<<" it has "<<pages<<" number of pages";
        cout<<" and it costs "<<price<<endl;
        cout<<endl;
    }




};

int main(){

    Book b1,b2;

    b1.setName("Web Development");
    b1.setPages(345);
    b1.setPrice(89.90);
    b1.display(b1.getName(),b1.getPages(),b1.getPrice());

    b2.setName("Java Development");
    b2.setPages(145);
    b2.setPrice(78.99);
    b2.display(b2.getName(),b2.getPages(),b2.getPrice());




    return 0;
}