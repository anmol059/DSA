package pepCodingSorting;

import java.io.*;
import java.util.*;

public class DateSort {

  public static void sortDates(String[] arr) {
    // write your code here
    countSort(arr, 1000000, 100, 32);
    countSort(arr, 10000, 100, 13);
    countSort(arr, 1, 10000, 2501);
  }

  public static void countSort(String[] arr,int div, int mod, int range) {
    // write your code here
    int freq[] = new int[range];
    for(int i = 0; i < arr.length; i++){
        int val = Integer.parseInt(arr[i]) / div % mod;
        freq[val]++;
    }
    
    // converting the freq array to prefix sum freq array
    for(int i = 1; i < freq.length; i++){
        freq[i] += freq[i - 1];
    }
    
    String ans[] = new String[arr.length];
    for(int i = arr.length - 1; i >= 0; i--){
        int val = Integer.parseInt(arr[i]) / div % mod;
        int index = freq[val] - 1;
        ans[index] = arr[i];
        freq[val]--;
    }
    
    for(int i = 0; i < arr.length; i++){
        arr[i] = ans[i];
    }
  }

  public static void print(String[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    String[] arr = new String[n];
    for (int i = 0; i < n; i++) {
      String str = scn.next();
      arr[i] = str;
    }
    sortDates(arr);
    print(arr);
  }

}
