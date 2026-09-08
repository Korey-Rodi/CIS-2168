import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

// Your class. Notice how it has no generics.
// This is because we use generics when we have no idea what kind of data we are getting
// Here we know we are getting two pieces of data:  a string and a line number
public class IndexTree {

	// This is your root 
	// again, your root does not use generics because you know your nodes
	// hold strings, an int, and a list of integers
	private IndexNode root;
	
	// Make your constructor
	// It doesn't need to do anything
	public IndexTree(){
		this.root = null;
	}
	
	// complete the methods below
	
	// this is your wrapper method
	// it takes in two pieces of data rather than one
	// call your recursive add method
	public void add(String word, int lineNumber){
		this.root = add(this.root, word,lineNumber);
	}
	
	
	
	// your recursive method for add
	// Think about how this is slightly different the the regular add method
	// When you add the word to the index, if it already exists, 
	// you want to  add it to the IndexNode that already exists
	// otherwise make a new indexNode
	private IndexNode add(IndexNode root, String word, int lineNumber){
		if(root == null){
            return new IndexNode(word, lineNumber);
        }
        int comparison = word.compareTo(root.word);
        if(comparison == 0){
			// update line number
			root.list.add(lineNumber);
			// update occourences
			root.occurences++;
            return root;
        }
        if(comparison < 0){
			// Go to the left
			root.left = add(root.left,word,lineNumber);
			// Call the add function again
            return root;
        } else {
			// Go the right
			root.right = add(root.right,word,lineNumber);
			// Call the add function again
            return root;
        }
    }
	
	
	
	
	// returns true if the word is in the index
	public boolean contains(String word){
        return contains(this.root, word);
    }

    private boolean contains(IndexNode root, String word){
        if(root == null){
            return false;
        }
        int comparison = word.compareTo(root.word);
        if(comparison == 0){
            return true;
        } else if(comparison < 0){
            return contains(root.left, word);
        } else {
            return contains(root.right, word);
        }
    }
			
	
	// call your recursive method
	// use book as guide
	public void delete(String word){
		this.root = delete(this.root, word);
	}
	
	// your recursive case
	// remove the word and all the entries for the word
	// This should be no different than the regular technique.
	private IndexNode delete(IndexNode root, String word){
		if(root == null){
            return null;
        }
        int comparison = word.compareTo(root.word);
        if(comparison < 0){
            root.left = delete(root.left, word);
            return root;
        } else if(comparison > 0){
            root.right = delete(root.right,word);
            return root;
        } else {
            if(root.left == null && root.right == null){ // Removing leaf
                return null;
            } else if(root.left != null && root.right == null){
                return root.left;
            } else if(root.left == null && root.right != null){
                return root.right;
            } else {
                IndexNode current = root.left;
                while(current.right != null){
                    current = current.right;
                }
                root.word = current.word;
                root.left = delete(root.left, root.word);
                return root;
			}
		}
	}
	
	
	// prints all the words in the index in inorder order
	// To successfully print it out
	// this should print out each word followed by the number of occurrences and the list of all occurrences
	// each word and its data gets its own line
	//public void printIndex(){
		// Go all the way down the left tree and print all of the children nodes
		// Print the root
		// Go all the way down the right tree and print all of the children nodes

		// Code via Geeks for geeks
	// 	IndexNode current = root;
	// 	Stack<IndexNode> stack = new Stack<>();
	// 	while(current != null || !stack.isEmpty()){
	// 		while(current != null){
	// 			stack.push(current);
	// 			current = current.left;
	// 		}
	// 		current = stack.pop();
	// 		System.out.println(current);
	// 		current = current.right;
	// 	}
	// }
	// prints all the words in the index in inorder order
	// To successfully print it out
	// this should print out each word followed by the number of occurrences and the list of all occurrences
	// each word and its data gets its own line
	public void printIndex(){
		// Calls from the tree root
		printIndex(this.root);
	}

	private void printIndex(IndexNode root){
		// This uses a stack from the Java Runtime
		if(root != null){
			printIndex(root.left);
			System.out.println(root);
			printIndex(root.right);
		}
	}

	public void printIndexOof(){
		// Calls from the tree root
		ArrayList<IndexNode> list =new ArrayList<>();
		printIndexOof(this.root,list);
		list.sort( new Comparator<IndexNode>() {

			public int compare(IndexNode o1, IndexNode o2) {
				return o1.word.compareTo(o2.word);
			}
			
		});

	}

	public void printIndexOof(IndexNode root, ArrayList<IndexNode> list) {

		if(root != null){
			printIndexOof(root.left, list);
			list.add(root);
			printIndexOof(root.right, list);
		}
	}
	
	public static void main(String[] args)throws FileNotFoundException{
		IndexTree index = new IndexTree();
		int lineNumber = 1;
		String fileName = "/Users/koreyrodi/Desktop/Programming/CIS 2168/Lab 7/pg100.txt";
		Scanner scanner = new Scanner(new File(fileName));
		while(scanner.hasNextLine()){
			String line = scanner.nextLine();
			Scanner lineScanner = new Scanner(line);
				while(lineScanner.hasNext()){
					String word = lineScanner.next().toLowerCase().trim();
					word = word.replaceAll("[^a-z]", "");
					index.add(word,lineNumber);	
			}
			lineNumber++;
		}
		// print out the index
		System.out.println("Index before word removed");
		System.out.println("=========================");
		//index.printIndex();
		System.out.println(index.contains("zounds")); // has to be lowercase
		// test removing a word from the index
		index.delete("zounds"); // has to be lowercase
		System.out.println(index.contains("zounds")); // has to be lowercase
		System.out.println("Index after word removed");
		System.out.println("=========================");
		index.printIndex();
	}
}
