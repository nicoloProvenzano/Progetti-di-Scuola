#include <stdio.h>
#include <assert.h>

int compra(int N, int M, int A, int B)
{
    int minimo=0;
	while(N>0)
	{
		if (N>M)
		{
			if((A*M)>=B) minimo+=B;
			else minimo+=(A*M);
			N-=M;
		}
		else
		{
			if((A*N)>=B) minimo+=B;
			else minimo+=(A*N);
			N-=M;
		}
		printf("%d",minimo);
	}
	return minimo;
}

int main() {
    FILE *fr, *fw;
    int N, M, A, B;

    fr = fopen("input.txt", "r");
    fw = fopen("output.txt", "w");

    assert(4 == fscanf(fr, "%d%d%d%d", &N, &M, &A, &B));

    fprintf(fw, "%d\n", compra(N, M, A, B));
    fclose(fr);
    fclose(fw);
    return 0;
}
