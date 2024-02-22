import java.util.*;
public class LinkedList {
    Node head;
    static class Node{
        int data;
        Node next;
        Node(int d){
            data=d;
            next=null;
        }
    }
    static LinkedList append(LinkedList l,int d){
        Node n=new Node(d);
        
        if(l.head==null){
            l.head=n;
        }
        
        else{
            Node t=l.head;
            while(t.next!=null){
                t=t.next;
            }
            t.next=n;
        }
        return l;
    }
    static void display(LinkedList l){
        Node t=l.head;

        while(t!=null){
            System.out.println(t.data);
            t=t.next;
        }
    }
    static Node  ck(LinkedList ll){
        Node n=new Node(-1);
        Node tl=n;
        Node t=ll.head;
        int z=0;
        while(t!=null){
            if(t.data!=0){
                Node nn=new Node(t.data);
                tl.next=nn;
                tl=tl.next;
            }
            if(t.data==0){
                z++;
            }
            t=t.next;
        }

        while(z>0){
            Node nn=new Node(0);
            tl.next=nn;
            tl=tl.next;
            z--;
        }
        return n.next;
    }
    static void display1(Node h){

        Node t=h;
        while(t!=null){
            System.out.print(t.data+" ");
            t=t.next;
        }
    }
    static Node Swap(LinkedList ll){
        Node h=new Node(-1);
        Node t1=h;
        Node t=ll.head;
        Node z=new Node(-1);
        Node t2=z;
     
        while(t!=null){
            if(t.data==0){
                t2.next=t;
               t2=t2.next;
            }
            else{
                t1.next=t;
                t1=t1.next;
            }
            t=t.next;
            
        }
        t2.next=null;
        t1.next=z.next;
        return h.next;
    }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        LinkedList ll=new LinkedList();
        for(int i=0;i<n;i++){
            int v=sc.nextInt();
            append(ll, v);
        }
        // display(ll);
        // Node r=ck(ll);
        Node r1=Swap(ll);
        display1(r1);

    }
}
