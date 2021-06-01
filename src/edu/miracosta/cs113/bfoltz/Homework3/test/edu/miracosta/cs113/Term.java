package edu.miracosta.cs113.bfoltz.Homework3.test.edu.miracosta.cs113;

import java.util.Objects;

public class Term implements Comparable{
    private int coefficient;
    private int exponent;

    public Term() {
        this.coefficient = 1;
        this.exponent = 1;
    }

    public Term(Term original) {
        this.coefficient = original.coefficient;
        this.exponent = original.exponent;
    }

    public Term(String t) {
        if (t.equals("")) {
            this.coefficient = 0;
            this.exponent = 0;
        }  else if (t.contains("x")) {
            String[] term = t.split("x");
            if (term[0].equals("+")) {
                coefficient = 1;
            } else if (term[0].equals("-")) {
                coefficient = -1;
            } else {
                coefficient = Integer.parseInt(term[0]);
            }

            int x = t.indexOf("x");

            if (term.length > 1) {
                exponent = Integer.parseInt(term[1].substring(1));
            } else if (x != -1){
                exponent = 1;
            } else {
                exponent = 0;
            }

        } else {
            coefficient = Integer.parseInt(t);
        }
    }

    public Term(int coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }



    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public int getExponent() {
        return exponent;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

    public void setAll(int coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }

    @Override
    public Object clone() {
        return new Term(coefficient, exponent);
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Term) {
            Term other = (Term) o;

            return exponent - other.exponent;

        }
        return -1;
    }

    @Override
    public String toString() {
        String term = "";
        if (coefficient == 0) {
            return "";
        }

        if (coefficient < 0) {
            if (coefficient == -1) {
                term += "-";
            } else {
                term += coefficient;
            }
        } else if (coefficient > 1) {
            term += "+" + coefficient;
        } else if (coefficient == 1) {
            term += "+";
        }

        if (exponent == 0) {
            return term;
        }
        else if (exponent == 1) {
            term += "x";
        } else {
            term += "x^" + exponent;
        }

        return term;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Term term = (Term) o;
        return coefficient == term.coefficient && exponent == term.exponent;
    }

}
