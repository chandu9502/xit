import java.util.*;
public class task2 {
    static ArrayList<ArrayList<Integer>>fl=new ArrayList<>();
    static void ck1(int ind,int d,ArrayList<Integer>al,ArrayList<Integer>l,int[]arr,HashMap<Integer,Integer>hm){

        if(ind>=al.size()){
        if(d==0){
                if(l.size()<arr[0]){
                   arr[0]=l.size();
                   fl.add(new ArrayList<>(l));
                }
               
        }
        return ;   
    }
        if(al.get(ind)<=d && hm.get(al.get(ind))>1){
            l.add(al.get(ind));
            int t=hm.get(al.get(ind));;
            t-=1;
            hm.put(al.get(ind),t);
            ck1(ind,d-al.get(ind),al,l,arr,hm);
            int t1=l.get(l.size()-1);
            l.remove(l.size()-1);
            hm.put(t1,hm.getOrDefault(t1,0)+1);
        }
        ck1(ind+1,d,al,l,arr,hm);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter amount:");
        int n=sc.nextInt();
        System.out.println("Enter 2000 notes:");
        int t=sc.nextInt();
        System.out.println("Enter 500 notes:");
        int f=sc.nextInt();
        System.out.println("Enter 200 notes:");
        int th=sc.nextInt();
        System.out.println("Enter 100 notes:");
        int h=sc.nextInt();
        sc.close();
        HashMap<Integer,Integer>hm=new HashMap<>();

        hm.put(100,h);
        hm.put(200,th);
        hm.put(500,f);
        hm.put(2000,t);

        ArrayList<Integer>al=new ArrayList<>();
        al.add(100);
        al.add(200);
        al.add(500);
        al.add(2000);
        ArrayList<Integer>l=new ArrayList<>();
      
        // ck(al.size()-1,n,hm,al,hm1);
        // System.out.println(hm1);
        int[]arr=new int[1];
        arr[0]=Integer.MAX_VALUE;
        
        ck1(0,n,al,l,arr,hm);
        HashMap<Integer,Integer>hm1=new HashMap<>();
        ArrayList<Integer>temp=fl.get(fl.size()-1);
        for(int i:temp){
            hm1.put(i,hm1.getOrDefault(i, 0)+1);
        }
        // Collections.sort(fl);
        // System.err.println(fl);
        System.out.println("Denominations :");
        for(int i:hm1.keySet()){
            System.out.println(i+"X"+hm1.get(i));
        }
        System.err.println();
        System.out.println("Remaining Notes:");
        for(int i:hm.keySet()){
            if(hm1.containsKey(i)){
                System.out.println(i+"X"+Math.abs(hm.get(i)-hm1.get(i)));
            }
            else{
                System.out.println(i+"X"+hm.get(i)+" ");
            }
        }
      
       

    }
}
