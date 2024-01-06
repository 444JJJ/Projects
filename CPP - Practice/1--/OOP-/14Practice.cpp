#include<iostream>
#include<string>
using namespace std;


class Player{
    private:
        string name;
        int age;
        string team;
    public:
        Player(){
            cout<<"Enter player name: "<<endl;
            cin>>name;
            cout<<"Enter player age"<<endl;
            cin>>age;
            cout<<"Enter player team"<<endl;
            cin>>team;
        }

        void input(){
            cout<<"Enter player name: "<<endl;
            cin>>name;
            cout<<"Enter player age"<<endl;
            cin>>age;
            cout<<"Enter player team"<<endl;
            cin>>team;        
        }

        void display(){
            cout<<"Player name is: "<<name<<endl;
            cout<<"Player team is: "<<team<<endl;
            cout<<"Player age is: "<<age<<endl;
        }

        void change(string s,string t,int a){
            name=s;
            team=t;
            age=a;
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