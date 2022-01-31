/*
TaCoya Harris, Matt Skrbec, Cole Paulline
CSCE 340
Prof. Wu
February 1st, 2022
Longest Increasing Subsequence
*/

import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Arrays.*;
public class myClass {
    
    //function that returns largest subsequence
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
        //uncomment the array you want to test
        //int a[] = {10,9,2,1,5,3,101,207,7,18,6,12,150};
        
        int a[] = {10, 9, 2, 5, 3, 101, 7, 18};
        
        /*int a[] = {186, 359, 274, 927, 890, 520, 571, 310, 916, 798, 732, 23, 196, 579,
        426, 188, 524, 991, 91, 150, 117, 565, 993, 615, 48, 811, 594, 303, 191,
        505, 724, 818, 536, 416, 179, 485,334, 74, 998, 100, 197, 768, 421,
        114, 739, 636, 356, 908, 477, 656};*/
        
        /*int a[] = {318, 536, 390, 598, 602, 408, 254, 868, 379, 565, 206, 619, 936, 195,
        123, 314, 729, 608, 148, 540, 256, 768, 404, 190, 559, 1000, 482, 141, 26,
        230, 550, 881, 759, 122, 878, 350, 756, 82, 562, 897, 508, 853, 317,
        380, 807, 23, 506, 98, 757, 247};*/
        
        ArrayList<Integer> al = new ArrayList<Integer>(Arrays.asList());//list to store subsequences
        List<int[]> rows = new ArrayList<>();//2d array of lengths and subseq
        List<List<Integer>> L = new ArrayList<List<Integer>>();//subseq of 2d array
      
        for (int i = 0; i< a.length-1; i++){//for each int
            al.clear();//reset list
            al.add(a[i]);//add first item to subsequence

            for (int j = i+1; j < a.length; j++){
                if (a[i] < a[j]){
                    al.add(a[j]);
                }
            }
            //make copy of list
            ArrayList<Integer> al1 = new ArrayList<>(al);

            //get subseq starting at last index
            for (int l = al.size()-1; l > 0; l--){
                if (al.get(l) < al.get(l-1)){
                    al.remove(l-1);//remove larger value
                }
            }
           //get subseq starting at first index
           for (int k = 0; k < al1.size()-2; k++){
               //if current value is greater than value after it and current value is greater the value after that value
               if ((al1.get(k) > al1.get(k+1)) && (!(al1.get(k) > (al1.get(k+2))))){
                   al1.remove(k+2);//remove the value that the current value is greater than
               }
           }
            //check the array again for other subsequences
            for (int k = 0; k < al1.size()-1; k++){
                //if current value is greater than value after it, remove the smaller value
                if (al1.get(k) > al1.get(k+1)){
                    al1.remove(al1.get(k+1));
                }
                //check if array[k] < all values after it
                for (int l = al1.size()-1; l > 2; l--){
                    //if current value is greater than the last value in the list, remove that value
                    if (al1.get(k) > al1.get(l)){
                        al1.remove(al1.get(l));
                    } 
                }
            }
            
            //add found subsequence to 2d list of other subsequences
            List<Integer> s = new ArrayList<Integer>(); //new subsequence
            s.add(al.size());//add length of subseq at first index
            for (int n = 0; n < al.size(); n++){
                s.add(al.get(n));//add each value of the subseq
            }
            L.add(s);//add the list to the list of subsequences
            
            //repeat
            List<Integer> s1 = new ArrayList<Integer>();
            s1.add(al1.size());
            for (int n = 0; n < al1.size(); n++){
                s1.add(al1.get(n));
            }
            L.add(s1);
        }
        L = print(L);
        //System.out.println(L);
        for (int i = 0; i<L.size();i++){
            System.out.println(L.get(i));
        }//THE FIRST INDEX = LENGTH OF SUBSEQUENCE
    }
}
