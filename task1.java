import java.util.*;
class task1{
    // public static void ck1(int e,ArrayList<Integer>al){

    //     for(int i=0;i<al.size();i++){
    //         if(al.get(i)==e){
    //             al.remove(i);
    //         }
    //     }
    // }
    // public static void ck(int e,ArrayList<Integer>l,ArrayList<ArrayList<Integer>>al,Queue<Integer>q,HashMap<Integer,Integer>hm){
    //     ArrayList<Integer>k=new ArrayList<>(hm.keySet());

    //     int m1=Integer.MAX_VALUE,m2=Integer.MAX_VALUE;

    //     for(int i:k){
    //         if(i<e){
    //             m1=Math.min(m1,i);
    //         }
    //     }
    //     for(int i:l){
    //         if(i<e){
    //             m2=Math.min(m2,i);
    //         }
    //     }
    // if(m1<m2){
    //     q.add(m1);
    //     ck1(m1,k);
    //     hm.remove(m1);
    // }
    // if(m2<m1){
    //     q.add(m2);
    //     ck1(m2,l);
    // }



    // }
    public static void ck2(Queue<Integer>q,int cf,ArrayList<Integer>al){
        if(al.size()==0){
            return ;
        }
    int id=-1,m=Integer.MAX_VALUE;
    for(int i=0;i<al.size();i++){

        if(Math.abs(al.get(i)-cf)<m){
            m=Math.abs(al.get(i)-cf);
            id=i;
        }
    }
    int k=al.get(id);
    q.add(al.get(id));
    al.remove(id);
    ck2(q,k,al);
}
   
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter number of floors:");
        int n=sc.nextInt();
        System.out.println("Enter current floor");
        int c=sc.nextInt();
        System.out.println("Enter number of persons entering");
        int p=sc.nextInt();
    
        ArrayList<Integer>al=new ArrayList<>();
        System.out.println("Enter persons floor number:");
        for(int i=0;i<p;i++){
            al.add(sc.nextInt());
        }

        
       HashMap<Integer,Integer>hm=new HashMap<>();
    Queue<Integer>q=new LinkedList<>();
        ck2(q,c,al);
       
        System.out.println(q);


        
        


        

    }
}