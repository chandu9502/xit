import java.util.Scanner;

public class buyndsell{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[]arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int m=0;
        int min=arr[0];

        for(int i=1;i<arr.length;i++){
            if(arr[i]<min){
                min=arr[i];
            }
            else{
                m=Math.max(m,arr[i]-min);
            }
        }
        System.out.println(m);
    }
}