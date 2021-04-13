#include <iostream>
#include <math.h>
using namespace std;
int main()
{
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  int rem=0;
  char siNo;
  int i=1;
  int pos=1;
  int a=0;
  int e=0;
  int vir=0;
  int due=2;
  int dec=0;
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  while(i !=0 ){
    cout<<"/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////";
    cout<<"CALCOLATRICE"<<endl;
    cout<< "0" <<" " << "per uscire" <<endl;
    cout<< "1" <<" "<<"converto il numero in binario" <<endl;
    cout<< "2" <<" "<<"converto il numero in ottale" <<endl;
    cout<< "3" <<" "<<"converto in numero in esadecimale" <<endl;
    cout<< "4" <<" "<<"ti do la parte decimale che vuoi"<<endl;
    cin>>i;
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    if(i == 0){
        break;
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    else if(i == 1){
            a=0;
            e=0;
            int binario[20];
            int binarioDEC[20];
            cout<<"e' un numero con virgola? s/n"<<endl;
            cin>>siNo;
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            if(siNo='s'){
    cout << "dimmi la parte intera"<<endl;
    cin >> dec;
    cout << "dimmi la parte della virgola"<<endl;
    cin >> vir;
        while(dec != 0){
            binario[a] = (dec % 2);
            dec = dec / 2;
            cout<< binario[a];
            a++;
        }
        cout<<",";
        dec=0;
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        while(vir != 0){
            binarioDEC[e] = (vir % 2);
            vir = vir / 2;
            cout<< binarioDEC[e];
            e++;
        }
        cout<<" "<<endl;
        vir=0;
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        cout<<"vuoi riconvertirlo? digitare s/n"<<endl;
        cin>>siNo;
        if(siNo=='s'){

            if(binario[0]==1){
                    dec=dec+1;
            }
                    while(pos<=a){
                    if(binario[pos]==1){
                    dec=dec+pow(due,pos);
                        }
                    pos++;
                    }
                    pos=1;
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            if(binarioDEC[0]==1){
                    vir=vir+1;
            }
                    while(pos<=e){
                    if(binarioDEC[pos]==1){
                    vir=vir+pow(due,pos);
                        }
                    pos++;
                    }

                cout<<"ecco il numero riconvertito:"<<dec<<","<<vir<<endl;
            }
        }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        else{
           cout << "enter decimal number: ";
           cin >> dec;
           while(dec != 0){
                 binario[a] = (dec % 2);
                 dec = dec / 2;
                 cout<< binario[a];
                 a++;
                }
        cout<<" "<<endl;
        dec=0;
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        cout<<"vuoi riconvertirlo?  digitare s/n"<<endl;
        cin>>siNo;
        if(siNo=='s'){

            if(binario[0]==1){
                    dec=dec+1;
            }
                    while(pos<=a){
                    if(binario[pos]==1){
                    dec=dec+pow(due,pos);
                        }
                    pos++;
                    }
                cout<<"ecco il numero riconvertito:"<<dec<<endl;
            }
       }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
       }
        else if(i == 2){
               cout << "enter decimal number: ";
               cin >> dec;
               if((dec % 8) == 0){
                  rem = rem + (dec / 8)*2;
                  }
               rem = rem + dec;
               cout<< rem<<endl;
              }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
       else if(i==3){
               cout << "enter decimal number: "<<endl;
               cin >> dec;
               while (dec > 0) {
                      rem = dec % 16;
                      if (rem > 9) {
                          switch (rem) {
                          case 10: cout << "A"; break;
                          case 11: cout << "B"; break;
                          case 12: cout << "C"; break;
                          case 13: cout << "D"; break;
                          case 14: cout << "E"; break;
                          case 15: cout << "F"; break;
                         }
                       }
                else {
                     cout << rem;
                     }
                dec = dec / 16;
               }
                cout<<" "<<endl;
         }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      else if(i==4){
              cout << "enter decimal number: "<<endl;
              cin >> dec;
              cout<<"divisione per due:"<<dec%2<<endl;
              cout<<"divisione per quattro:"<<dec%4<<endl;
              cout<<"divisione per otto:"<<dec%8<<endl;
              }
   }
}

