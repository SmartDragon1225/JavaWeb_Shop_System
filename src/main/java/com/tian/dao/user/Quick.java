package com.tian.dao.user;

import java.util.Arrays;

public class Quick {
    public static void main(String[] args) {
        int arr[] = {-9,0,3,2,2,8,7,6};
        System.out.println("排序前："+Arrays.toString(arr));
        quick(arr,0,arr.length-1);
        System.out.println("排序后"+Arrays.toString(arr));
    }

    public static void quick(int arr[],int left,int right){
        int l = left;int r = right;int q = arr[(left+right)/2];
        while (l<r){
            while (arr[l]<q){
                l++;
            }
            while (arr[r]>q){
                r--;
            }
            if(l>=r){
                break;
            }
            int t = arr[l];arr[l] = arr[r];arr[r] = t;
            if(q==arr[l]){
                r--;
            }
            if(q==arr[r]){
                l++;
            }
        }
        if(l==r){
            l++;r--;
        }
        if(l<right){
            quick(arr,l,right);
        }
        if(r > left){
            quick(arr,left,r);
        }
    }
}
