package com.virjid.app.util;

public class ArrayUtil {
	/**
     * 对整型数组进行排序，排序方式为升序排序
     * 需要注意的是，该排序直接对传入数组进行操作，而不会返回一个新的数组对象
     * 
     * @param array 需要进行排序的整型数组
     */
    public static void sort(int[] array) {
    	boolean flag = true;
    	while (flag) {
    		flag = false;
    		for (int i=1; i<array.length; i++)
        		for (int j=0; j<array.length-1; j++)
        			if (array[j]>array[j+1]) {swap(array, j, j+1);flag = true;} 
    	}
    }
    
    private static void swap(int[] array, int i, int j) {
		int t = array[i];
		array[i] = array[j];
		array[j] = t;
	}
    
    /**
     * 判断一个整型数组中，是否任意两个元素都相等
     * 
     * @param array
     * @return 若所有元素都相等则返回true，否则返回false
     */
    public static boolean isAllEquals(int[] array) {
    	for (int i=0; i<array.length-1; i++)
    		if (array[i]!=array[i+1]) return false;
    	return true;
    }
    
    /**
     * 判断一个整型数组中，是否存在相等的元素
     * 
     * @param array
     * @return 若存在相等的元素则返回true，否则返回false
     */
    public static boolean hasEquals(int[] array) {
    	for (int i=0; i<array.length-1; i++)
    		if (array[i]==array[i+1]) return true;
    	return false;
    }
    
    /**
     * 判断一个整型数组中，各元素是否连续，即array[n+1]=array[n]+1
     * 需要注意该方法只有传入有序且为升序的整型数组才能返回正确的结果
     * 
     * @param array
     * @param isOrder array是否有序且为升序，如果传入false，则array会先被进行一次排序操作
     * @return 判断结果
     */
    public static boolean isSerial(int[] array, boolean isOrder) {
    	if (!isOrder) sort(array);
    	for (int i=0; i<array.length-1; i++)
    		if (array[i]!=array[i+1]-1) return false;
		return true;
	}
    
    public static int[] subArray(int[] arr, int begin, int num) {
    	int[] sub = new int[num];
    	int subIndex = 0;
    	for(int i=begin; i<num+begin; i++) sub[subIndex++]=arr[i];
    	return sub;
    }
}
