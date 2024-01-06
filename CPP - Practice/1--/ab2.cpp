#include<iostream>
using namespace std;

class Enemy{
    public:
        virtual void attack()=0;
};

class Ninja: public Enemy{
    public:
        void attack(){
            cout<<"ninja attack!\n";
        }
};


class Monster: public Enemy{
    public:
        void attack(){
            cout<<"Monster attack\n";
        }
};

int main(){
    



    return 0;
}