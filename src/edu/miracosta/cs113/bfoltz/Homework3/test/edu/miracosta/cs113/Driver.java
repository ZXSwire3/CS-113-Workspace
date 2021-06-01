package edu.miracosta.cs113.bfoltz.Homework3.test.edu.miracosta.cs113;

import java.util.Locale;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        int choice;
        Scanner keyboard = new Scanner(System.in);
        Polynomial first = new Polynomial();
        Polynomial second = new Polynomial();
        String[] terms;
        Term actualTerms;

        System.out.println("Welcome to the Polynomial Driver");
        do {
            System.out.print("\n\n" +
                    "What would you like to do?\n" +
                    "1) Edit 1st Polynomial\n" +
                    "2) Edit 2nd Polynomial\n" +
                    "3) Add 1st and 2nd Polynomial together\n" +
                    "4) Exit\n" +
                    ">");
            choice = keyboard.nextInt();

                if (choice == 1) {
                    do {
                        System.out.print("Editing 1st polynomial: " + first + "\n" +
                                "What would you like to do?\n" +
                                "1) Create a whole new polynomial\n" +
                                "2) Add terms to the existing polynomial\n" +
                                "3) Clear the polynomial\n" +
                                "4) Return\n" +
                                ">");
                        choice = keyboard.nextInt();
                        if (choice == 1) {
                            System.out.print("\nPlease input the polynomial that you would like to use\n" +
                                    "Type in the polynomial in the following format: '+x^4 -4x^3 +2'\n" +
                                    ">");
                            keyboard.nextLine();
                            String polynomialString = keyboard.nextLine();
                            terms = polynomialString.split(" ");

                            if (terms.length > 0) {
                                for (int i = 0; i < terms.length; i++) {
                                    actualTerms = new Term(terms[i]);
                                    first.addTerm(actualTerms);
                                }
                            }
                        } else if (choice == 2) {
                            System.out.print("\nEnter the term you would like to add to '" + first + "'\n" +
                                    "Type in the polynomial in the following format: '-4x^3'\n" +
                                    ">");
                            keyboard.nextLine();
                            String termString = keyboard.nextLine();
                            actualTerms = new Term(termString);

                            first.addTerm(actualTerms);
                        } else if (choice == 3) {
                            System.out.print("Are you sure you want to clear this polynomial? (Y or N)\n" +
                                    ">");
                            keyboard.nextLine();
                            if (keyboard.nextLine().toLowerCase().equals("y")) {
                                first.clear();
                                if (first.getNumTerms() == 0) {
                                    System.out.println("1st polynomial has been successfully cleared");
                                }
                            } else {
                                System.out.println("1st polynomial has not been cleared");
                                break;
                            }
                        } else {
                            choice = 0;
                            break;
                        }
                    } while (true);
                } else if (choice == 2) {
                    do {
                        System.out.print("Editing 2nd polynomial: " + second + "\n" +
                                "What would you like to do?\n" +
                                "1) Create a whole new polynomial\n" +
                                "2) Add terms to the existing polynomial\n" +
                                "3) Clear the polynomial\n" +
                                "4) Return\n" +
                                ">");
                        choice = keyboard.nextInt();
                        if (choice == 1) {
                            System.out.print("\nPlease input the polynomial that you would like to use\n" +
                                    "Type in the polynomial in the following format: '+x^4 -4x^3 +2'\n" +
                                    ">");
                            keyboard.nextLine();
                            String polynomialString = keyboard.nextLine();
                            terms = polynomialString.split(" ");

                            if (terms.length > 0) {
                                for (int i = 0; i < terms.length; i++) {
                                    actualTerms = new Term(terms[i]);
                                    second.addTerm(actualTerms);
                                }
                            }
                        } else if (choice == 2) {
                            System.out.print("\nEnter the term you would like to add to '" + second + "'\n" +
                                    "Type in the polynomial in the following format: '-4x^3'\n" +
                                    ">");
                            keyboard.nextLine();
                            String termString = keyboard.nextLine();
                            actualTerms = new Term(termString);

                            second.addTerm(actualTerms);
                        } else if (choice == 3) {
                            System.out.print("Are you sure you want to clear this polynomial? (Y or N)\n" +
                                    ">");
                            keyboard.nextLine();
                            if (keyboard.nextLine().toLowerCase().equals("y")) {
                                second.clear();
                                if (second.getNumTerms() == 0) {
                                    System.out.println("2nd polynomial has been successfully cleared");
                                }
                            } else {
                                System.out.println("2nd polynomial has not been cleared");
                                break;
                            }
                        } else {
                            choice = 0;
                            break;
                        }
                    } while (true);
                } else if (choice == 3) {
                    Polynomial temp = new Polynomial(first);
                    temp.add(second);
                    System.out.println("1st Polynomial + 2nd Polynomial = " + temp);
                }
        } while (choice != 4);
    }
}