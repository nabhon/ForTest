public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,3,6,9,23,26,34,44,67};
        System.out.println(binarySearch(arr,44));
    }
    
    public static boolean binarySearch(int[] arr,int key){
        int first = 0;
        int last = arr.length-1;
        int middle;
        for ( middle = (first+last)/2 ; first <= last ; middle = (first+last)/2) {
            if (arr[middle]==key){
                return true;
            } else if (arr[middle]>key) {
                last = middle-1;
            } else if (arr[middle]<key) {
                first = middle+1;
            }
        }
        return false;
    }
    
}
