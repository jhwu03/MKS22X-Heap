public class MyHeap{
     // /We discussed these 2 methods already:
     // - size  is the number of elements in the data array.
     // - push the element at index i downward into the correct position. This will swap with the larger of the child nodes provided thatchild is larger. This stops when a leaf is reached, or neither child is larger. [ should be O(logn) ]
     // - precondition: index is between 0 and size-1 inclusive
     // - precondition: size is between 0 and data.length-1 inclusive.
private static void pushDown(int[]data,int size,int index){
       boolean status = false;
       while(!status){
       child1 = (index * 2) + 1;
       child2 = (index * 2) + 2;
       if(child1 >= size && child2 >= size ) status = true;
       if(child1 < size && child2 < size){
         int max = 0;
         if(data[child1] > data[child2]){
           max = Math.max(data[child1],data[index]);
         }else{
           max = Math.max(data[child2],data[index]);
         }
         if(max != data[index]){
           if(max == data[child1]){
             data[child1] = data[index];
             data[index] = max;
             index = child1;
           }else{
             data[child2] = data[index];
             data[index] = max;
             index = child2;
           }
         }else status = true;
       }else if(child1 < size){
         int max = 0;
         max = Math.max(data[child1],data[index]);
         if(max != data[index]){
           data[child1] = data[index];
           data[index] = max;
           index = child1;
         }else status = done;
       }
     }
   }

//  /**A method that pushes an element at a given index upward
// *@param int[] data
// *@param int index
// - push the element at index i up into the correct position. This will swap it with the parent node until the parent node is larger or the root is reached. [ should be O(logn) ]
// - precondition: index is between 0 and data.length-1 inclusive.
// */
 private static void pushUp(int[]data, int index){
   boolean status = false;
   while(!status){
     if(index == 0) done = true;
     else{
       int parent;
       if(index % 2 == 0) parent = (index / 2) - 1;
       else parent = index / 2;
       if(parent >= 0){
         int temp = data[index];
         if(data[index] >= data[parent]){
           data[index] = data[parent];
           data[parent] = temp;
           index = parent;
         }else status= true;
       }else status = true;
     }
   }
 }


  public static void heapify(int[] data){
    //- convert the array into a valid heap. [ should be O(n) ]
    for (int i = data.length-1;i >= 0;i--) {
      pushDown(data,data.length,i);
    }
  }

  public static void heapsort(int[] data){
    //- sort the array [ should be O(nlogn) ] :
    // converting it into a heap
    // removing the largest value n-1 times (remove places at end of the sub-array).
    heapify(data);
    int size = data.length - 1; 
    for(int i = 0; i <= data.length - 2; i++){
      int temp = data[0];
      data[0] = data[size];
      data[size] = temp;
      pushDown(data, size, 0);
      size--;
    }
  }





}
