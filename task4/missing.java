import java.util.Scanner;

public class missing {
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[]arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int[]vis=new int[n+1];

        for(int i:arr){
            vis[i]=1;
        }
        for(int i=1;i<vis.length;i++){
            if(vis[i]==0){
                System.out.println(i);
                System.exit(0);
            }
        }
        System.out.println("-1");
    }
}
