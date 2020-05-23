public class BucketSort {
    public static Node insertionSort(Node start){
        if(start == null || start.getNext() == null){//if start is null or the only node then it is sorted
            return start;
        }
        Node curr = start;//our current linked list pointer 
        Node sorted = new Node(start.getData());//our new sorted linked list that we will be adding to
        while(curr.getNext() != null){//for every node in our bucket
            curr = curr.getNext();//go to the next node
            Node sortedCurr = sorted;//pointer to iterate through our sorted linked list
            Node sortedParent = sorted;//pointer to hold the parent of sortedCurr
            boolean complete = false;//used to determine if we added the node into our sorted linked list
            while(sortedCurr != null){
                if(curr.getData() < sorted.getData()){//if our current node has value less than the start of our sorted linked list
                    Node newNode = new Node(sorted.getData());//replace the start of sorted linked list with the current data
                    newNode.setNext(sorted.getNext());//and set the current node's next to the previous start of the sorted linked list 
                    sorted.setData(curr.getData());
                    sorted.setNext(newNode);
                    complete = true;//we have added to our sorted linked list so this is true
                    break;//we dont need to go through this loop anymore
                }
                else if(curr.getData() < sortedCurr.getData()){//if our current node has value less than our current sorted linked list node
                    Node newNode = new Node(curr.getData());//add our current data to that point
                    newNode.setNext(sortedParent.getNext());//with the sorted linked list node set to next
                    sortedParent.setNext(newNode);
                    complete = true;//we have added to our sorted linked list so this is true
                    break;//we dont need to go through this loop anymore
                }
                sortedParent = sortedCurr;//increment both sortedCurr and sortedParent to the next node in the sorted linked list
                sortedCurr = sortedCurr.getNext();
            }
            if(complete == false){//if we went through all the elements in the sorted linked list and our current data is greater than all those values
                Node newNode = new Node(curr.getData());//add it as a new node to the end of the sorted linked list   
                sortedParent.setNext(newNode);
            }
        }
        return sorted;//return our new complete sorted linked list 
    }
    public static void bucketSort(int[] arr){
        if(arr.length <= 1){//if the array is empty or has only one value, it is sorted
            return;
        }
        //create new array of 10 where each array spot acts as a bucket 
        Node[] bucket = new Node[10];
        int max = arr[0];
        for(int i = 0; i < arr.length; i++){//find the maximum value in the array
            if(arr[i] > max){//if current value is greater than previous max
                max = arr[i]; //set that to the new max value
            }
        }

        int divisor;//create the divisor which determines which value goes in which bucket
        if((max+1)%10 == 0){//if the max value + 1 is evenly divided by 10
            divisor = (max+1)/10; //set our divisor to that value
            //(+ 1, because we want to make sure each number is divided into a value from 0 - 9)
        }
        else{//otherwise round our number up to the next whole number
            divisor = ((max+1)/10) + 1;
        }

        for(int j = 0; j < arr.length; j++){//for each element in the array
            int index = arr[j]/divisor;//find its index in bucket
            Node newNode = new Node(arr[j]);
            if(bucket[index] == null){//if there are no elements already in that bucket, add the element to that point
                bucket[index] = newNode;
            }
            else{//otherwise find the next spot to add the element at the index
                Node curr = bucket[index];
                while(curr.getNext() != null){
                    curr = curr.getNext();
                }
                curr.setNext(newNode);
            }
        }

        int sortArrPtr = 0;//points to the next empty spot in the array
        for(int k = 0; k < 10; k++){//for each bucket
            Node sortNode = insertionSort(bucket[k]);//insertion sort the items in the bucket
            Node now = sortNode;
            while(now != null){//for the sorted elements in the bucket
                arr[sortArrPtr++] = now.getData();//add each element and then increment the array pointer
                now = now.getNext();
            }
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
        bucketSort(arrOne);
        display(arrOne);
    }
}