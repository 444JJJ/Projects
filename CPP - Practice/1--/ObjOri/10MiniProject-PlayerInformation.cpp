#include<iostream>
#include<string>
using namespace std;


class Player{
private:
    string playerName;
    int age;
    string teamName;

public:

    Player(){
        cout<<"Enter Player Name: "<<endl;
        cin>>playerName;
        cout<<"Enter Player Age: "<<endl;
        cin>>age;
        cout<<"Enter Player Team Name: "<<endl;
        cin>>teamName;
    }

    void inputData(){
        cout<<"Enter Player Name: "<<endl;
        cin>>playerName;
        cout<<"Enter Player Age: "<<endl;
        cin>>age;
        cout<<"Enter Player Team Name: "<<endl;
        cin>>teamName;
    }

    void changeData(string pName,int a,string tName){
        playerName=pName;
        age=a;
        teamName=tName;

    }

    void displayData(){
        cout<<"The player name is: "<<playerName;
        cout<<" their age is: "<<age;
        cout<<" and they play for the team: "<<teamName<<endl;
    }








};





int main(){
    system("clear");
    int choice;
    Player p;
    do{
        cout<<"---------------Main Menu-------------"<<endl;
        cout<<"1:- Input Player Data"<<endl;
        cout<<"2:- Display Player Data"<<endl;
        cout<<"3:- Change Player Data"<<endl;
        cout<<"4:- Exit"<<endl;
        cout<<"Enter any choice"<<endl;
        cin>>choice;
        switch(choice){
            case 1:
                p.inputData();
                break;
            case 2:
                p.displayData();
                break;
            case 3:
                p.changeData("Shaid", 55, "Unknown");
                break;
            case 4:
                exit(1);
                break;
            default:
                cout<<"You have entered an invalid value"<<endl;

        }
    }while(1);




    return 0;
}