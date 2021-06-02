package edu.miracosta.cs113.bfoltz.Homework7.src.edu.miracosta.cs113;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * MorseCodeTree : A BinaryTree, with Nodes of type Character to represent each letter of the English alphabet,
 * and a means of traversal to be used to decipher Morse code.
 *
 * @version 1.0
 */
public class MorseCodeTree extends BinaryTree<Character> {

    // TODO:
    // Build this class, which includes the parent BinaryTree implementation in addition to
    // the `translateFromMorseCode` and `readMorseCodeTree` methods. Documentation has been suggested for the former,
    // where said exceptional cases are to be handled according to the corresponding unit tests.

    File file = new File("src/edu/miracosta/cs113/bfoltz/Homework7/morse code.txt");

    public MorseCodeTree() {
        super(new Node<>());
        readMorseCodeTree();
    }

    public void readMorseCodeTree() {
        try {
            Scanner fileReader = new Scanner(file);

            String line, morseCode;
            String[] data;
            char letter;
            Node currentNode;

            while (fileReader.hasNextLine()) {
                currentNode = root;
                line = fileReader.nextLine();
                data = line.split(" ");
                letter = data[0].charAt(0);
                morseCode = data[1];

                //traverse the tree
                for (int i = 0; i < morseCode.length(); i++) {
                    if (morseCode.charAt(i) == '*') {
                        if (currentNode.left == null) {
                            //create new node if there is none there
                            currentNode.left = new Node<>();
                        }
                        //traverse to that new node
                        currentNode = currentNode.left;
                    } else if (morseCode.charAt(i) == '-') {
                        if (currentNode.right == null) {
                            //create new node if there is none there
                            currentNode.right = new Node<>();
                        }
                        //traverse to that node
                        currentNode = currentNode.right;
                    }
                }
                //input the letter in that node
                currentNode.data = letter;
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     * Non-recursive method for translating a String comprised of morse code values through traversals
     * in the MorseCodeTree.
     *
     * The given input is expected to contain morse code values, with '*' for dots and '-' for dashes, representing
     * only letters in the English alphabet.
     *
     * This method will also handle exceptional cases, namely if a given token's length exceeds that of the tree's
     * number of possible traversals, or if the given token contains a character that is neither '*' nor '-'.
     *
     * @param morseCode The given input representing letters in Morse code
     * @return a String representing the decoded values from morseCode
     */
    public String translateFromMorseCode(String morseCode) throws Exception {
        String[] words = morseCode.split(" ");
        Node currentNode;
        StringBuilder sb = new StringBuilder();

        //loops through the word array for every word in it
        for (String word : words) {
            //start from the top of the tree
            currentNode = root;

            //loop through ever character in the word
            for (int i = 0; i < word.length(); i++) {
                //check to see if it is a * or a -
                if (word.charAt(i) == '*') {
                    //if * traverse left
                    currentNode = currentNode.left;
                } else if (word.charAt(i) == '-') {
                    // if - traverse right
                    currentNode = currentNode.right;
                } else {
                    //if neither throw an exception
                    throw new Exception(word.charAt(i) + " is not a valid character, only '*', '-' or ' ' are allowed");
                }
            }
            //once done traversing, add the letter to the string builder
            sb.append(currentNode.data);
        }
        return sb.toString();
    }

} // End of class MorseCodeTree