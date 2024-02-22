import java.util.*;
class duplicates{
    public static void main(String[] args) {
        System.out.println("Enter no of elements:");
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    
    int[]arr=new int[n];
    System.out.println("Enter array elements:");
    for(int i=0;i<n;i++){
        arr[i]=sc.nextInt();
    }
    ArrayList<Integer>al=new ArrayList<>();
    for(int i=0;i<n;i++){
            if(!al.contains(arr[i])){
                al.add(arr[i]);
            }
    }
    System.err.println("No duplicates");
}
}