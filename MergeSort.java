public class MergeSort {
    public static void mergeSort(int[] arr){
        sort(arr,0,arr.length-1);
    }
    private static void sort(int[] arr, int start, int end){
        int[] temp = new int[arr.length];
        int mid = (start+end)/2;//find the middle point of the array
        if(start < end){//basically if start and end arent pointing to the same thing
            sort(arr, 0, mid);//split the array into a first half(recursively goes down until 2 spots are left and then goes back up)
            sort(arr,mid+1,end);//and a second half(recursively goes down until 2 spots are left and then goes back up)
            merge(arr,start,mid,end,temp);//and merge the two halfs
        }

    }
    private static void merge(int[] arr, int start, int mid, int end, int[] temp){
        int a1 = start;//points to first element in array 1
        int a2 = mid+1;//points to first element in array 2
        int t = start;//points to first spot in the temp array
        while(a1 <= mid && a2 <= end){//while the array 1 & 2 pointers are still in their side of the array
            if(arr[a1]<=arr[a2]){//if the array one pointer value is less than the array two pointer value
                temp[t] = arr[a1];//add that element to temp
                t++;//point to the next temp array spot
                a1++;//point to the next array one spot
            }
            else{//same as the other thing but for if array 2 pointer is less than array one
                temp[t] = arr[a2];
                t++;
                a2++;
            }
        }
        while(a1 <= mid){//if there are still elements left in array one to add
            temp[t] = arr[a1];//add that element to temp
            t++;//point to the next temp array spot
            a1++;//point to the next array one spot
        }
        while(a2 <= end){//if there are still elements left in array two to add
            temp[t] = arr[a2];//add that element to temp
            t++;//point to the next temp array spot
            a2++;//point to the next array two spot
        }
        for(int i = start; i <= end; i++){//redo the values in the array with the new sorted values in temp
            arr[i] = temp[i];
        }
    }
    public static void display(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        int[] arrOne = {2,5,1,7,2,19,10,11,15,3,1};
        mergeSort(arrOne);
        display(arrOne);

    }
}