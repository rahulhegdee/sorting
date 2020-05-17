public class QuickSort{
    public static void quickSort(int[] arr){
        partition(arr, 0, arr.length-1);
    }
    public static void partition(int[] arr, int start, int end){
        display(arr);
        if(start >= end){//if the partition size is 1, then return
            return;
        }
        //we are going to start with the last value in the array and find its position, then partition two sections of the array 
        int i = start-1;//this pointer will be used to swap larger with smaller values
        int j = start;//this pointer will be used to compare array values to the last array value
        while(j < end){//continue comparing values until we reach the last value of the array
            if(arr[j] < arr[end]){//if the value at j is smaller than our last value
                i++;//move i up one position
                int temp = arr[i];//and swap the values at i and j
                arr[i] = arr[j];
                arr[j] = temp; 
             }
             j++;//move j to point at the next value in the array
        }
        int endTemp = arr[end];//swap the value at the end to its sorted position in the array (one spot after the current i position)
        arr[end] = arr[i+1];
        arr[i+1] = endTemp;
        partition(arr,start,i);//call partition again with the left and right side of our finalized position in the array
        partition(arr,i+2,end);
    }
    public static void display(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        int[] arrOne = {2,5,1,7,2,19,10,11,15,3,1};
        quickSort(arrOne);
        display(arrOne);
    }
}