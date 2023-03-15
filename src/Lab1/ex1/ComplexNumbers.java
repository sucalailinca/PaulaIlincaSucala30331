package Lab1.ex1;

public class ComplexNumbers {
    int real, imaginary;

    public ComplexNumbers(int r, int img){
        this.real = r;
        this.imaginary = img;
    }

    public void printComplexNumber(){
        if (this.imaginary > 0) System.out.println(this.real + "+" + this.imaginary + "i");
        else System.out.println(this.real + "" + this.imaginary + "i");
    }

    public static ComplexNumbers add(ComplexNumbers n1, ComplexNumbers n2){
        ComplexNumbers sum = new ComplexNumbers(0,0);

        sum.real = n1.real + n2.real;
        sum.imaginary = n1.imaginary + n2.imaginary;

        return sum;
    }

    public static ComplexNumbers multiplication(ComplexNumbers n1, ComplexNumbers n2){
        ComplexNumbers product = new ComplexNumbers(1,1);

        product.real = n1.real * n2.real - n1.imaginary * n2.imaginary;
        product.imaginary = n1.real * n2.imaginary + n1.imaginary * n2.real;

        return product;
    }
}
