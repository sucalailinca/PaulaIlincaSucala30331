package Lab1.ex1;

public class Main {
    public static void main(String[] args) {
        ComplexNumbers n1 = new ComplexNumbers(2,5);
        ComplexNumbers n2 = new ComplexNumbers(4,-1);

        ComplexNumbers sum = ComplexNumbers.add(n1,n2);
        sum.printComplexNumber();

        ComplexNumbers product = ComplexNumbers.multiplication(n1,n2);
        product.printComplexNumber();
    }
}
