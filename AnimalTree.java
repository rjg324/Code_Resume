/*
 * Rose Genstein
 * visual studio code
 * 10/27/22
 * ALA 8
 * description:At the end of this ALA, students should demonstrate the following skills:
Implement the generic data structures for binary search tree and heap
Define additional methods in the binary search tree and heap class implementations
Instantiate the two generic data structures in a test program and fill them with data read from a file
Compare the performance of the operations (contains, add, and remove) on the two data structures
Determine and compare the properties, height and balance, of the two binary trees
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class AnimalTree{
    public static void main(String[] args){
      ArrayList<String> animalAL = new ArrayList<>();
         BST<String> animalBST = new BST<>();
        Heap<String> animalHeap = new Heap<>();
        System.out.println();
        System.out.println("Testing Add");
        readFile(animalAL,animalBST, animalHeap,"animals.txt");
        System.out.println();
        System.out.println("Testing contains");
testContains(animalAL,animalBST, animalHeap);
System.out.println();
System.out.println("Testing remove");
testRemove(animalAL,animalBST, animalHeap);
/*
 * when it comes to discussing the differneces between Add,Remove, and contains i looked at the print out informtation and how 
 * spread out the numbers and information is 
 * for add the data is relativly close together 
 * however for contains it is relal spread out numbers range from 6 to 483 
 * and when i take a look at remove they are relaly close together again
 * what i think this means is that when looking at what something contains it shows a wider variatey of information then when you look at just 
 * remove or add
 */

System.out.println("BST Height "+ animalBST.height());
System.out.println("Heap Height "+ animalHeap.height());

System.out.println("Is BST balanced " + animalBST.isBalanced());
System.out.println("Is Heap balanced " + animalHeap.isBalanced());

     animalBST.clear();
     animalHeap.clear();
     java.util.Collections.sort(animalAL);

for(int i=0; i<animalAL.size();i++){
    String animal = animalAL.get(i);
    animalBST.add(animal);
    animalHeap.add(animal);
}
    System.out.println("BST Height "+ animalBST.height());
    System.out.println("Heap Height "+ animalHeap.height());

    System.out.println("Is BST balanced " + animalBST.isBalanced());
    System.out.println("Is Heap balanced " + animalHeap.isBalanced());

    }

public static void testRemove(ArrayList<String> al, BST<String> bst, Heap<String> heap){
    int bstIter=0;
    int heapIter =0;
    for(int i =0; i<20;i++){
        int random = (int)(Math.random()*al.size());
        String animal = al.get(random);
        int bstCurr = bst.remove(animal);
        int heapCurr = heap.remove();
        bstIter+= bstCurr;
        heapIter+= heapCurr;
        System.out.printf("%-30s\t%-10d\t%-10d\n", animal,bstCurr, heapCurr);
        }
                  System.out.printf("%-30s\t%-10d\t%-10d\n", "Average",(bstIter/20), (heapIter/20));

    }
//discussion here

public static void testContains(ArrayList<String> al, BST<String> bst, Heap<String> heap){
    int bstIter=0;
    int heapIter =0;
    for(int i =0; i<20;i++){
        int random = (int)(Math.random()*al.size());
        String animal = al.get(random);
        int bstCurr = bst.contains(animal);
        int heapCurr = heap.contains(animal);
        bstIter+= bstCurr;
        heapIter+= heapCurr;
        System.out.printf("%-30s\t%-10d\t%-10d\n", animal,bstCurr, heapCurr);
        }
                  System.out.printf("%-30s\t%-10d\t%-10d\n", "Average",(bstIter/20), (heapIter/20));

    }


    public static void readFile(ArrayList<String> al, BST<String> bst, Heap<String> heap,String filename){
   File file = new File(filename);
try{
    Scanner read = new Scanner(file);
    int bstIter = 0;
    int heapIter = 0;
    int index = 0;
    while(read.hasNext()){
        String animal = read.nextLine();
        al.add(animal);
        int bstCurr = bst.add(animal);
        int heapCurr = heap.add(animal);
        if(index %24==0){
            bstIter += bstCurr;
            heapIter += heapCurr;
            System.out.printf("%-30s\t%-10d\t%-10d\n", animal,bstCurr, heapCurr);
        }
        index++;

    }
          System.out.printf("%-30s\t%-10d\t%-10d\n", "Average",(bstIter/21), (heapIter/21));
        read.close();
}catch(FileNotFoundException e){
    System.out.println("File not found");
    System.exit(0);
        }
    }
}
