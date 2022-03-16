package org.rosuda.REngine;

/**
 * @author Administrator
 * @since 2022-03-16
 */
public class Complex {
    private double real;
    private double imaginary;

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public boolean isNA() {
        return REXPDouble.isNA(real) || REXPDouble.isNA(imaginary);
    }

    @Override
    public String toString() {
        return real + "+" + imaginary + "i";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Complex) {
            Complex c = (Complex) obj;
            return c.real == real && c.imaginary == imaginary;
        }
        return false;
    }
}
