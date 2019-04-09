package LinkedList_A1;

public class LinkedListPlayground {

  public static void main(String[] args) { 
    /*
     here you can instantiate your LinkedList and play around with it to check
     correctness. We've graciously also provided you a bit of extra test data for debugging.
     It doesn't matter what you have in here. We will not grade it. This is for your use in testing
     your implementation.
      */
    test1();
    test2();

  }
  
  public static void test1(){
    // example test case
    LinkedListImpl L= new LinkedListImpl();
    System.out.println("Test Case 1:");
    //Should Print "Test Case 1:"
    System.out.println(L.isEmpty());
    //Should Print "true"
    printList(L);
    //Should Print "sentinel"
    L.clear();
    System.out.println(L.isEmpty());
    //Should Print "true"
    printList(L);
    //Should Print "sentinel"
    System.out.println(L.sentinel.toString());
    //Should Print "data: 0.0  hasNext:false  hasPrev:false"
    L.insert(3.3,0);
    System.out.println(L.isEmpty());
    //Should Print "false"
    printList(L);
    //Should Print "sentinel --> 3.3"
    System.out.println(L.sentinel.next.toString());
    //Should Print "data: 3.3  hasNext:true  hasPrev:true"
    L.insert(3.4, 0);
    L.insert(3.5, 0);
    L.insert(3.67, 1);
    L.insert(3.357, 0);
    L.insert(3.333, 4);
    System.out.println(L.size());
    //Should Print "6"
    printList(L);
    //Should Print "sentinel --> 3.357 --> 3.5 --> 3.67 --> 3.4 --> 3.333 --> 3.3"
    L.remove(3);
    System.out.println(L.size());
    //Should Print "5"
    printList(L);
    //Should Print "sentinel --> 3.357 --> 3.5 --> 3.67 --> 3.333 --> 3.3"
    L.clear();
    L.insert(3.4, 0);
    L.insert(3.5, 0);
    L.insert(3.67, 1);
    L.insert(3.357, 0);
    L.insert(3.333, 3);
    L.remove(0);
    System.out.println(L.size());
    //Should Print "4"
    printList(L);
    //Should Print "sentinel --> 3.5 --> 3.67 --> 3.333 --> 3.4"
  }

  public static void test2(){
    // example test cases
    LinkedListImpl L= new LinkedListImpl();
    System.out.println("Test Case 2:");
    L.insert(3.4,0);
    L.insert(3.5,1);
    L.insert(3.67,2);
    L.remove(0);
    System.out.println(L.size());
    printList(L);
  }
  
  public static void printList(LinkedListImpl L){ 
    //note that this is a good example of how to iterate through your linked list
    // since we know how many elements are in the list we can use a for loop
    // and not worry about checking the next field to see if we hit the end sentinel
    Node curr=L.sentinel.next; // the first data node in the list is the one after sentinel. 
    System.out.print("sentinel");
    for(int i=0; i<L.size(); i++) { 
      System.out.print(" --> " + curr.data);
      curr=curr.next;
    }
    System.out.println();
  }
}