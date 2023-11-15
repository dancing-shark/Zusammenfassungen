import java.util.Arrays;
// import java.lang.<name> // Wrapper-Klasse

public class Main {
    public static void main(String[] args) {

    }




    // Werte
    public static int wertOktal = 031;
    public static int wertDezimal = 25;
    public static int wertHexadezimal = 0x19;
    public static int wertBinär = 0b11001;
    public static int wertZahl = 1_000_00;



    public static void datentypen() {
        boolean value = false; // true
        // default: false

        byte x1 = 0;
        byte x2 = Byte.MAX_VALUE; //  127
        byte x3 = Byte.MIN_VALUE; // -128
        // default: 0

        short s1 = 0;
        short s2 = Short.MAX_VALUE; // 32_767
        short s3 = Short.MIN_VALUE; //-32_768
        // default: 0

        int i1 = 0;
        int i2 = Integer.MAX_VALUE; // 2_147_483_647
        int i3 = Integer.MIN_VALUE; //-2_147_483_648
        // default: 0

        long l1 = 0L;
        long l2 = Long.MAX_VALUE; // 2^63 -1
        long l3 = Long.MIN_VALUE; //-2^63
        // default: 0

        float f1 = 0f;
        float f2 = Float.MAX_VALUE;
        float f3 = Float.MIN_VALUE; //
        // default: 0.0

        double d1 = 0d;
        double d2 = Double.MAX_VALUE;
        double d3 = Double.MIN_VALUE; //
        // default: 0.0

        char c1 = 'P';
        char c2 = Character.MAX_VALUE;
        char c3 = Character.MIN_VALUE;
        // default: \u0000


        String str = "Hallo";
    }

    // Zweierpotenz
    public static boolean isPower2(int nr) { //TODO: not Tested
        return (nr > 0) && ((nr & (nr - 1)) == 0);

    }

    //Overflow behandlung
    public static void test() {
        int a = 0;
        while (true) {
            if (a > Integer.MAX_VALUE - 1) {
                break;
            }
            a++;
        }
    }



    // Vielfaches von X
    public static boolean isMultiple(int nr) { //TODO: not Tested
        return nr % 7 == 0; // Vielfaches von 7

    }

    // Primzahl
    public static boolean isPrime(int nr) { //TODO: not Tested
        if (nr < 2) {
            return false;
        }
        for (int i = 2; i*i <= nr; i++) {
            if (nr % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Quersumme
    public static int getSumDigit(int nr) { //TODO: not Tested
        int result = 0;
        while (nr > 0) {
            result += nr % 10;
            nr /= 10;
        }
        return result;
    }
    // Anzahl an Stellen
    public static int getNumberOfDigits(int nr) { //TODO: not Tested
        int result = 0;
        while (nr > 0) {
            nr /= 10;
            result++;
        }
        return result;
    }

    // Fakultät
    public static long getFac(long nr) { //TODO: not Tested
        if (nr < 0 || nr > 20) return -1; // keine Negativen Zahlen, 20 ist die größt mögliche Zahl

        long result = 1;
        for (long i = 1; i <= nr; i++) {
            result *= i;
        }
        return result;
    }

    public static void basicsMethods(){ //TODO: not Tested
        int nr = 0;
        System.out.println(Integer.toString(nr));   // toString
        String str1 = "Hallo".toLowerCase();         // toLowerCase
        String str2 = "Hallo".toUpperCase();         // toUpperCase
        char char1 = "Hallo".charAt(0);              // charAt(int index)
        String str3 = "Hallo".replace("l", "p");    // replace(char oldChar, char newChar)
        boolean str4 = "Hallo".contains("allo");    // contains(CharSquence sequence)
    }

    public static void basicsMethodsForArrays(){
        int[] array = new int[]{1,2,3,4,5};
        int len = array.length;
        int[] arrayClone = array.clone();
        Arrays.sort(array);
        int x = Arrays.binarySearch(array, 2);

    }

    // Label
    public static void labelExampel(){ // TODO: Test
        A: while (true){
            innerLoop:
            for (int i = 0; i<=3; i++){ // Achtung endlosschleife

                if (3 == i) {
                    break A;
                } else {
                    break innerLoop;
                }
            }
        }
    }

    // Quelle: https://bitbucket.ase.in.tum.de/projects/PGDP2324W03H01/repos/pgdp2324w03h01-solution/browse/src/pgdp/arrayfun/ArrayFunctions.java
    public static int[] zipMany(int[][] arrays){
        int maxLength = 0;
        int sumOfLengths = 0;
        for(int i = 0; i < arrays.length; i++) {
            sumOfLengths += arrays[i].length;
            if(arrays[i].length > maxLength) {
                maxLength = arrays[i].length;
            }
        }

        int[] zippedArray = new int[sumOfLengths];
        int nextPosition = 0;
        for(int j = 0; j < maxLength; j++) {
            for(int i = 0; i < arrays.length; i++) {
                if(j < arrays[i].length) {
                    zippedArray[nextPosition] = arrays[i][j];
                    nextPosition++;
                }
            }
        }

        return zippedArray;
    }

    // Quelle: https://bitbucket.ase.in.tum.de/projects/PGDP2324W03H01/repos/pgdp2324w03h01-solution/browse/src/pgdp/arrayfun/ArrayFunctions.java
    public static int[] filter(int[] array,int min,int max){
        int firstUnusedPosition = 0;
        int[] out = new int[array.length];
        for (int j = 0; j < array.length; j++){
            if(array[j] >= min && array[j] <= max) {
                out[firstUnusedPosition] = array[j];
                firstUnusedPosition++;
            }
        }

        return Arrays.copyOf(out,firstUnusedPosition);
    }

    // Quelle: https://bitbucket.ase.in.tum.de/projects/PGDP2324W03H01/repos/pgdp2324w03h01-solution/browse/src/pgdp/arrayfun/ArrayFunctions.java
    public static void rotate(int[] array, int amount) {
        int length = array.length;

        if(length == 0) {
            return;
        }

        // Get rotation amount into range [0, array.length - 1]
        amount = amount % length;
        if(amount < 0) {
            amount += length;
        }

        // Rotate into new array
        int[] rotated = new int[length];
        for(int i = 0; i < length; i++) {
            rotated[(i + amount) % length] = array[i];
        }

        // Copy from this new array back into old one
        for(int i = 0; i < length; i++) {
            array[i] = rotated[i];
        }
    }

    // Quelle: https://bitbucket.ase.in.tum.de/projects/PGDP2324W03H01/repos/pgdp2324w03h01-solution/browse/src/pgdp/arrayfun/ArrayFunctions.java

    public static int[][] quantities(int[] array) {
        int[][] quantitiesArray = new int[array.length][2];
        int nextPosition = 0;

        for(int i = 0; i < array.length; i++) {
            boolean isInQuantitiesArray = false;
            for(int j = 0; j < nextPosition; j++) {
                if(quantitiesArray[j][0] == array[i]) {
                    quantitiesArray[j][1]++;
                    isInQuantitiesArray = true;
                    break;
                }
            }

            if(!isInQuantitiesArray) {
                quantitiesArray[nextPosition] = new int[] { array[i], 1 };
                nextPosition++;
            }
        }

        // Cut of unnecessary parts
        int[][] reducedQuantitiesArray = new int[nextPosition][2];
        for(int i = 0; i < nextPosition; i++) {
            reducedQuantitiesArray[i] = quantitiesArray[i];
        }

        return reducedQuantitiesArray;
    }


    // Einzeilige ifs "?"
    public static int ifExample(int a, int b) {
        return (a<b) ? a:b+1;
    }

    public static void printArray(int[] a) {
        System.out.println(Arrays.toString(a));
        int[][] nr = {{2},{2}};
        System.out.println(Arrays.deepToString(nr));

    }

    public static void arrayExample(){
        int[] testArray1 = new int[]{1,3,5,7,9};
        int[][] testArray3 = new int[][]{new int[]{1,2,3,5}, new int[]{11,22,33,44,55}, new int[]{111,222,333,555}};
        int[][] testArray4 = new int[testArray3.length][2];
        int[][] testArray5 = new int[][]{
                {2,4},
                {4,5,6}
        };
        int[][] testArray6 = {{3,5},{4}};
    }

    // Invertiert ein Array
    public static void invert(int[] a) {
        int left = 0;
        int right = a.length - 1;

        while (left < right) {
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            left++;
            right--;
        }
    }

    // Find Min/Max of Array

    // Quelle: https://bitbucket.ase.in.tum.de/projects/PGDP2324W03P01/repos/pgdp2324w03p01-solution/browse/src/pgdp/array/Array.java
    public static void minandmaxOfArray(int[] a){
        if (a.length == 0) {
            return;
        }

        int min = a[0];
        int max = a[0];

        for (int i = 0; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
            if (a[i] > max) {
                max = a[i];
            }
        }

        System.out.println("Minimum = " + min + ", Maximum = " + max);
    }


    // Palindorm
    public static void isPalindrom(){

    }

    // RemoveDuplicates
    public static void removeDuplicates(){

    }

    // calulateAverage

    // countOccurrences

    //power

    //gcd

    //fibonacci
    public static void fibonacci(long nr) {
        int nr1 = 0, nr2 = 1;
        for (int i = 1; i < nr; i++) {
            System.out.print(nr1+" ");
            int temp = nr1+nr2;
            nr1 = nr2;
            nr2 = temp;
        }
    }

    //sqrt

    //max/min

    //Bubble Sort

    // Binary Search


    public static void printfExample(String text) {
        int nr = 20;
        System.out.printf("Text: %s, Number: %d\n", text, nr);
    }


    // searchArray with "Arrays"
    public static void searchArray(){
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int elementToFind = 5;
        int index = Arrays.binarySearch(array, elementToFind);

        if (index >= 0) {
            System.out.println("Element gefunden an Index " + index);
        } else {
            System.out.println("Element nicht gefunden");
        }
    }


    public static void testLiveTemplates(){



    }

    public static void mathExample() {
        Math.max(5,10); // größere Zahl
        Math.min(5,10); // kleiner Zahl
        Math.sqrt(64); // Wurzel
        Math.abs(-4.7); // positve Zahl
        Math.random(); // random number between [0.0 and 1.0[
        int nr = (int)(Math.random() * 101);  // 0 to 100
    }

    public static int vargsExample(int... elements){
        // vargsExample(1,2,3);
        int sum = 0;
        for (int i = 0; i < elements.length; i++) {
            sum = sum + elements[i];
        }
        return sum;
    }

    public static int daysInMonthSwitch(int month) {
        int days;
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            days = 30;
        } else if (month == 2) {
            days = 28;
        } else {
            days = 31;
        }
        return days;
    }
    public static int daysInMonthSwitch1(int month) {
        return switch (month) {
            case 4, 6, 9, 11 -> 30;
            case 2 -> 28;
            default -> 31;
        };
    }



    /*
    Questions:


     */

    // IDE: Shortcut
    /*
        * Strg W: expand to bigger area
        * Strg C: with pointer in one row, copys the hole row
        * Strg F: search
        * Strg R: replace
        * Strg Z:
        * Umschalt F6: Rename refactoring
        * Alt Enter: Improve code with context actions: Strg Q preview
        * Local History -> File -> Local Histroy -> Show History
        * Strg Alt L: Code Reformat
        * Strg Umschalt (Pfeil nach oben/unten): Move statements up and down
        * Strg Umschalt Enter: complit corrent Statment
        * Shift: move block right
        * Shift Umschalt: move block left
        * Strg umschalten I: preview;
        *
        *
        * sout: System.out.println();
        * soutv: System.out.println(); mit letzer Variable
        * main: main Funktion
        * fori: for Loop
        *
        * Personal:
        * Strg Y: Run code
     */

    /*
        * W01P01: Done
     */


    //egte case
    /*

     */
}