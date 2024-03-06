import java.util.*;
public class twounsorted {

    static void merge(int l,int mid,int h,ArrayList<Integer>al){
        int left=l,right=mid+1;
        ArrayList<Integer>t=new ArrayList<>();
        while(left<=mid && right<=h){
            if(al.get(left)<=al.get(right)){
                t.add(al.get(left));
                left++;
            }
            else{
                t.add(al.get(right));
                right++;
            }
        }
        while(left<=mid){
            t.add(al.get(left));
            left++;
        }
        while(right<=h){
            t.add(al.get(right));
            right++;
        }

        for(int i=l;i<=h;i++){
            al.set(i,t.get(i-l));
        }
    }
    static void mergeSort(int l,int h,ArrayList<Integer>al){
        if(l>=h){
            return ;
        }
        int mid=(l+h)/2;
        mergeSort(l,mid,al);
        mergeSort(mid+1, h, al);
        merge(l,mid,h,al);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter list1 size");
        int n1=sc.nextInt();
        System.out.println("Enter list2 size");
        int n2=sc.nextInt();
        ArrayList<Integer>l1=new ArrayList<>();
        ArrayList<Integer>l2=new ArrayList<>();
        for(int i=0;i<n1;i++){
            l1.add(sc.nextInt());
        }
        for(int i=0;i<n2;i++){
            l2.add(sc.nextInt());
        }

        for(int i:l2){
            l1.add(i);
        }
        mergeSort(0,l1.size()-1,l1);
        // Collections.sort(l1);

        System.out.println(l1);


    }
}
