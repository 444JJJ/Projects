#include<iostream>
#include<string>
using namespace std;

class Player{
private:
    char Name[40];
    int Age;
    char Team[40];

public:

    Player(){
        cout<<"Enter your name: "<<endl;
        cin.getline(Name,40);
        cout<<"Enter your player team: "<<endl;
        cin.getline(Team,40);
        cout<<"Enter your age"<<endl;
        cin>>Age;


        
    }


    void input(){
        cout<<"Enter player name: "<<endl;
        cin>>Name;
        cout<<"Enter Player Team"<<endl;
        cin>>Team;
        cout<<"Enter age: "<<endl;
        cin>>Age;

    }






    void display(){
        cout<<"Player name is: "<<Name<<endl;
        cout<<"Player team name is: "<<Team<<endl;
        cout<<"Player age is: "<<Age<<endl;
    }
    


    void change( char n[40],char t[40], int a){
        strcpy(Name,n);
        strcpy(Team,t);
        Age=a;


    }
 

    

    






};





int main(){

    Player p;
    p.display();

    int choice;
    do{
        cout<<"-------Main Menu----------------"<<endl;
        cout<<"1:-   Input Player Data"<<endl;
        cout<<"2:-   Display Player Data"<<endl;
        cout<<"3:-   Chage player data"<<endl;
        cout<<"4:-   Exit"<<endl;
        cout<<"Enter any choice:"<<endl;
        cin>>choice;

        switch(choice){
            case 1:
                p.input();
                break;
            case 2:
                p.display();
                break;
            case 3:
                p.change("Joe", "AI",40);
                break;
            case 4:
                exit(1);
                break;
            default:
                cout<<"You have entered invalid number"<<endl;
        }
    }while(1);








    return 0;
}