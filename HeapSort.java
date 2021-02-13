public class HeapSort{
    //Start at the bottom of the heap and call heapify from right to left at that level
    //Go up to the next level and do the same
    //Once we do this for the first node in the array, the heap will be created
    public static void maxHeap(int[] arr){
        for(int i = arr.length - 1; i >= 0; i--){ //from the rightmost bottommost value all the way to the first node
            maxHeapify(arr, i, arr.length); //make sure the value is larger than its children 
        }
    }

    //bubbles value at index down if a child value is greater
    //Continues this bubbling down for the same value until it either:
    //reaches the bottom of the heap or is larger than both it's children
    public static void maxHeapify(int[] arr, int index, int end){//end is +1 the actual end (ex: arr.length)
        while((index*2)+1 < end){//while left child of heap is before the end
            int left = (index*2)+1;
            int right = left+1;
            int highest = index;
            if(arr[left] > arr[highest]){ //check if left is a greater value than the current index
                highest = left;
            }
            if(right < end && arr[right] > arr[highest]){//check if right is within bounds and if it is a greater value than the highest value so far
                highest = right;
            }
            
            if(highest == index){break;} //if highest value is the current index, it is in the right spot
            int temp = arr[index]; //otherwise, swap with the highest of either right or left
            arr[index] = arr[highest];
            arr[highest] = temp;
            index = highest; //check if the same value needs to be swapped further down
        }
    }

    //forms max heap out of unsorted array and then fully sorts array
    public static void heapSort(int[] arr){
        maxHeap(arr);//sort array into a max heap
        for(int i = arr.length - 1; i > 0; i--){ //sorts the last to first index (once everything else is sorted, index 0 will be too)
            int temp = arr[0]; //swap the max element with the last element in the heap
            arr[0] = arr[i];
            arr[i] = temp;
            maxHeapify(arr, 0, i); //put the swapped last heap element back into its proper place in heap, ignoring the max values already sorted
        }
    }

    //prints array elements
    public static void printArr(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");
    }

    public static void main(String[] args){
        int[] arr1 = {21, 14, 4, 7, 19, 34, 1,2,3,33,23,6,13,1,1,4,33,14,13,13,13,61,4,9};
        printArr(arr1);
        maxHeap(arr1);
        printArr(arr1);
        heapSort(arr1);
        printArr(arr1);
    }
}
