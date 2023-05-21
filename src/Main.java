import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //vstup uživatele
        Scanner scanner = new Scanner(System.in);

        System.out.println("Zadejte číslo: ");

        String numberS = scanner.next();
        int number = 0;

        if (isNumeric(numberS)) {
            number = Integer.parseInt(numberS);
        } else {
            System.out.println("Zadejte prosím číslo");
            System.exit(0);
        }

        System.out.println("Zadejte v jaké je číslo soustavě: ");

        String firstBaseS = scanner.next();
        int firstBase = 0;

        if (isNumeric(firstBaseS)) {
            firstBase = Integer.parseInt(numberS);
        } else {
            System.out.println("Zadejte prosím číslo");
            System.exit(0);
        }

        System.out.println("Zadejte do jaké soustavy chcete číslo převést: ");

        String finalBaseS = scanner.next();
        int finalBase = 0;

        if (isNumeric(finalBaseS)) {
            finalBase = Integer.parseInt(finalBaseS);
        } else {
            System.out.println("Zadejte prosím číslo");
            System.exit(0);
        }

        //konverze čísla do pole
        int[] num = numberToArr(number);

        System.out.println(convert(num, firstBase, finalBase));
    }

    public static int convert(int[] num, int firstBase, int finalBase) {
        //konverze ze zadané soustavy do desítkové soustavy

        int deciamlNum = 0;

        for (int i = 0; i < num.length-1; i++) {
            deciamlNum += num[i];
            deciamlNum *= firstBase;
        }
        deciamlNum += num[num.length-1];

        if (finalBase == 10) {
            //číslo mělo být převedeno jen do desítkové soustavy
            return deciamlNum;
        }

        //z desítkové soustavy převedu na zvolenou soustavu
        String s = "";

        while(deciamlNum != 0) {
            s += deciamlNum % finalBase;
            deciamlNum /= finalBase;
        }

        int result = Integer.parseInt(s);

        //obracení stringu

        String converted = "";

        while(result != 0) {
            converted += result%10;
            result /= 10;
        }

        return Integer.parseInt(converted);
    }

    public static int[] numberToArr(int x) {
        int[] num = new int[Integer.toString(x).length()];

        for (int i = num.length-1; i >= 0; i--) {
            num[i] = x % 10;
            x /= 10;
        }

        return num;
    }

    public static boolean isNumeric(String s) {
        //kontroluje vstup uživatele
        try {
            Integer.parseInt(s);
            return  true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}