package teste1;

public class Arrays {

    public static int maxSumKSubArray(int arr[],int k)
    {
        // Processar a primeira janela de dimensão k
        int res = 0;
        for (int i=0; i<k; i++)
            res += arr[i];
        // Processar a soma das janelas restantes, removendo o primeiro elemento
        // da janela anterior e adicionando o último elemento da janela atual.
        int curr_sum = res;
        for (int i=k; i<arr.length; i++)
        {
            curr_sum += arr[i] - arr[i-k];
            res = Math.max(res, curr_sum);
        }
        return res;
    }

    public static void main(String[] args){
       int[] a= {100, 200, 300, 400};
       int k=2;
       System.out.println(maxSumKSubArray(a,2));
       //700
       int[] b = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        k = 4;
        System.out.println(maxSumKSubArray(b,4));
        //39
        //O subarray é {4, 2, 10, 23}

    }
}
