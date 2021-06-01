package edu.miracosta.cs113.bfoltz.Homework3.test.edu.miracosta.cs113;

import java.util.Collections;
import java.util.LinkedList;

public class Polynomial {
    private LinkedList<Term> polynomial;

    public Polynomial() {
        polynomial = new LinkedList<Term>();
    }

    public Polynomial(Polynomial original) {
        polynomial = new LinkedList<Term>();
        for (Term t : original.polynomial) {
            polynomial.add(new Term(t.getCoefficient(), t.getExponent()));
        }
    }

    public LinkedList<Term> getPolynomial() {
        return polynomial;
    }


    public int getNumTerms() {
        return polynomial.size();
    }

    public void addTerm(Term term) {
        int i = 0;
        for (Term t : polynomial) {
            if (term.getExponent() == t.getExponent()) {
                if (t.getCoefficient() + term.getCoefficient() == 0) {
                    polynomial.remove(i);
                    return;
                }
                t.setCoefficient(t.getCoefficient() + term.getCoefficient());
                return;
            }
            i++;
        }
        polynomial.add(term);
        polynomial.sort(Collections.reverseOrder());
    }

    public Term getTerm(int i) {
        return polynomial.get(i);
    }

    public void clear() {
        polynomial.clear();
    }

    public void add(Polynomial other) {
        for (Term t : other.polynomial) {
            this.addTerm(t);
        }
    }

    @Override
    public String toString() {
        if (polynomial.size() == 0) {
            return "0";
        }

        String output = "";
        for (Term t : polynomial) {
            output += t.toString();
        }

        if (output.charAt(0) == '+') {
            output = output.substring(1);
        }

        return output;
    }
}
