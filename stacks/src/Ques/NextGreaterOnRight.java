package Ques;

import java.io.*;
import java.util.*;

public class NextGreaterOnRight{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] nge = solve(a);
    display(nge);
 }

 public static int[] solve(int[] arr){
   // solve
   int res[] = new int[arr.length];
   for(int i = 0; i < res.length; i++){
       res[i] = -1;
   }
   Stack<Integer> st = new Stack<>();
   st.push(0);
   for(int i = 1; i < arr.length; i++){
       while(st.size() > 0 && arr[st.peek()] < arr[i]){
           res[st.pop()] = arr[i]; 
       }
       st.push(i);
   }
   return res;
 }

}
