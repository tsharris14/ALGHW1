import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Arrays.*;
public class myClass {
    
    private static List<List<Integer>> print(List<List<Integer>> list){
        List<List<Integer>> biggest = new ArrayList<List<Integer>>();
        int currentBiggest = -1;
        
        //get list size from start of list
        for(int i = 0; i < list.size(); i++){
            //if longer list, clear list and take bigger list
            if(list.get(i).get(0) > currentBiggest){
                currentBiggest = list.get(i).get(0);
                while(!biggest.isEmpty()){
                    biggest.remove(0);
                }
                biggest.add(list.get(i));
            }
            else if(list.get(i).get(0) == currentBiggest){
                biggest.add(list.get(i));
            }
        }
        return biggest;
    } 
    
      public static void main(String args[]) {
        int a[] = {10, 9, 2, 5, 3, 101, 7, 18};
        int max = 0;//max subseq length
        ArrayList<Integer> al = new ArrayList<Integer>(Arrays.asList());//list to store subsequences
        List<int[]> rows = new ArrayList<>();//2d array of lengths and subseq
        List<List<Integer>> L = new ArrayList<List<Integer>>();//subseq of 2d array
      
        int currentIdx = 0;
        for (int i = 0; i< a.length-1; i++){//for each int
            al.clear();//reset list
            al.add(a[i]);//add first item to subsequence
            //System.out.println("a[i]: "+ a[i]);
            for (int j = i+1; j < a.length; j++){
                if (a[i] < a[j]){
                    al.add(a[j]);
                }
            }
            //System.out.println("al before: " + al);
            ArrayList<Integer> al1 = new ArrayList<>(al);
            //System.out.println("al1 before: " + al1);
            //get subseq starting at last index
            for (int l = al.size()-1; l > 0; l--){
                if (al.get(l) < al.get(l-1)){
                    al.remove(l-1);
                }
            }
           //System.out.println("al after: " + al); 
           //System.out.println("L: " +al.size());
           //get subseq starting at first index
           for (int k = 0; k < al1.size()-2; k++){
               if ((al1.get(k) > al1.get(k+1)) && (!(al1.get(k) > (al1.get(k+2))))){
                   al1.remove(k+2);
               }
           }
            //check again
            for (int k = 0; k < al1.size()-1; k++){
                if (al1.get(k) > al1.get(k+1)){
                    al1.remove(al1.get(k+1));
                }
            }
            //System.out.println("al1 after: " +al1);
            //System.out.println("L: " +al1.size());
            
            //find the longest subseq and print it ...
            List<Integer> s = new ArrayList<Integer>();
            s.add(al.size());
            for (int n = 0; n < al.size(); n++){
                s.add(al.get(n));
            }
            L.add(s);
            
            List<Integer> s1 = new ArrayList<Integer>();
            s1.add(al1.size());
            for (int n = 0; n < al1.size(); n++){
                s1.add(al1.get(n));
            }
            L.add(s1);
        }
        L = print(L);
        System.out.println(L);
    }
}