import java.util.*;
public class task8{
    static int[]finalarray=new int[1]; // This is used to get max product for combinations
  
    static void combinationCheck(int index,int[]productArray,int[]array,int target,List<Integer>al){ //Complexity:O(2*n)
        //ind -index p[]-used to store product,arr[]-array,k-target,al-Arraylist
        if(index>=array.length){
            if(target==0){  
                finalarray[0]=Math.max(finalarray[0],productArray[0]);  //Here if we reach end of array and if target is 0 we are updating max product
            }
            return ;
        }
        if(array[index]<=target){
            al.add(array[index]);                                  
            productArray[0]*=array[index];
            combinationCheck(index,productArray,array,target-array[index],al);   // this is array element is less than target i.e k we are adding 
            productArray[0]/=al.get(al.size()-1);
            al.remove(al.size()-1);
        }
        combinationCheck(index+1,productArray,array,target,al);                     // this is not picking element at that index
    }
    static int breakInt(int number){  //Complexity:O(n)
       if(number<=3){
        return number-1;
       }
        int product=1;   /// 5   p=3=>n=2  
        while(number>4){
            product*=3;      
            number-=3;
        }
        product*=number;
        return product;
    }
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.err.println("Enter number: ");
        int number=input.nextInt();
        input.close();
        int[]array=new int[number];
        for(int i=1;i<=number;i++){    // 1 2 3 4 

            array[i-1]=i;     //Here we are initializing array ex:n=3,then possible combinations that sum to 3 are 1+1+1,1+2,3+0 so we need to array with 3 elements [1,2,3]
        }                                   
            int[]productarray=new int[1];
            productarray[0]=1;
       
        List<Integer>list=new ArrayList<>();
      
        combinationCheck(0,productarray,array,number,list); //In this approach we are checking combinations and find max product
        System.out.println(finalarray[0]);

        // System.out.println(breakInt(number));




    
}
}