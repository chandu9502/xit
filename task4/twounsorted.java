import java.util.*;
public class twounsorted {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter list1 size");
        int n1=sc.nextInt();
        System.out.println("Enter list2 size");
        int n2=sc.nextInt();
        List<Integer>l1=new ArrayList<>();
        List<Integer>l2=new ArrayList<>();
        for(int i=0;i<n1;i++){
            l1.add(sc.nextInt());
        }
        for(int i=0;i<n2;i++){
            l2.add(sc.nextInt());
        }

        for(int i:l2){
            l1.add(i);
        }
        Collections.sort(l1);

        System.out.println(l1);


    }
}
