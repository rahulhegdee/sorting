public class MergeSort {
    public static void mergeSort(int[] a){
        sort(a,0,a.length-1);
    }
    private static void sort(int[] a, int start, int end){
        int[] temp = new int[a.length];
        int mid = (start+end)/2;//find the middle point of the array
        if(start < end){//basically if start and end arent pointing to the same thing
            sort(a, 0, mid);//split the array into a first half(recursively goes down until 2 spots are left and then goes back up)
            sort(a,mid+1,end);//and a second half(recursively goes down until 2 spots are left and then goes back up)
            merge(a,start,mid,end,temp);//and merge the two halfs
        }

    }
    private static void merge(int[] a, int s, int m, int e, int[] temp){
        int a1 = s;//points to first element in array 1
        int a2 = m+1;//points to first element in array 2
        int t = s;//points to first spot in the temp array
        while(a1 <= m && a2 <= e){//while the array 1 & 2 pointers are still in their side of the array
            if(a[a1]<=a[a2]){//if the array one pointer value is less than the array two pointer value
                temp[t] = a[a1];//add that element to temp
                t++;//point to the next temp array spot
                a1++;//point to the next array one spot
            }
            else{//same as the other thing but for if array 2 pointer is less than array one
                temp[t] = a[a2];
                t++;
                a2++;
            }
        }
        while(a1 <= m){//if there are still elements left in array one to add
            temp[t] = a[a1];//add that element to temp
            t++;//point to the next temp array spot
            a1++;//point to the next array one spot
        }
        while(a2 <= e){//if there are still elements left in array two to add
            temp[t] = a[a2];//add that element to temp
            t++;//point to the next temp array spot
            a2++;//point to the next array two spot
        }
        for(int i = s; i <= e; i++){//redo the values in the array with the new sorted values in temp
            a[i] = temp[i];
        }
    }
    public static void display(int[] a){
        for(int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }
    public static void main(String[] args){
        int[] arrOne = {2,5,1,7,2,19,10,11,15,3,1};
        mergeSort(arrOne);
        display(arrOne);

    }
}