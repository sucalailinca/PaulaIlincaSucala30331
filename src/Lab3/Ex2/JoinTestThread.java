package Lab3.Ex2;

class JoinTestThread extends Thread{

    Thread t;
    int number;
    static int sum = 0;



    JoinTestThread(String n, Thread t, int number){

        this.setName(n);

        this.t=t;
        this.number = number;

    }

    public void run() {

        System.out.println("Thread "+this.getName()+" has entered the run() method");

        try {

            if (t != null){
                t.join();
                sum += sumOfDividers(this.number);
                System.out.println("The sum of the dividers of a number greater than 20000(second thread) is " + sumOfDividers(this.number));
                System.out.println("Finaaaal sum is: " + sum);

            }
            else {
                System.out.println("The sum of the dividers of a number greater than 50000(first thread) is " + sumOfDividers(this.number));
                sum += sumOfDividers(this.number);
            }

            System.out.println("Thread "+this.getName()+" executing operation.");

            Thread.sleep(3000);

            System.out.println("Thread "+this.getName()+" has terminated operation.");

        }

        catch(Exception e){e.printStackTrace();}

    }
    public int sumOfDividers(int number){
        int sumOfDivisors = number + 1;
        for (int i = 2; i <= number/2; i++) {
            if( number % i == 0) {
                sumOfDivisors += i;
            }

        }return sumOfDivisors;
    }
}