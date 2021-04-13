#include <stdio.h>
#include <assert.h>


int bicollatz(int A, int B) {
    int i=0;
    while(A!=1||B!=1)
        {
            if(A%2==0&&B%2==0)
                    {
                    A=A/2;
                    B=B/2;
                    }
                else if(A%2!=0&&B%2!=0)
                                {
                                A=(A*3)+1;
                                B=(B*3)+1;
                                }
                            else if(A%2!=0)A+=3;
                                    else B+=3;

     i++;
   }
    return i;
}


int main() {
    FILE *fr, *fw;
    int A, B;

    fr = fopen("input.txt", "r");
    fw = fopen("output.txt", "w");
    assert(2 == fscanf(fr, "%d %d", &A, &B));

    fprintf(fw, "%d\n", bicollatz(A, B));
    fclose(fr);
    fclose(fw);
    return 0;
}
