import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static String changeNumber;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String inNumber;
        do {
            System.out.println("Введите номер телефона: ");
            inNumber = scanner.nextLine();

        } while (phoneNumber(inNumber));
        System.out.println("Введённый номер: " + changeNumber);
    }

    public static boolean phoneNumber(String inNumber) {
        boolean cheak = true;
        changeNumber = null;
        Pattern pattern = Pattern.compile("[^0-9]");
        Matcher matcher = pattern.matcher(inNumber);
        changeNumber = matcher.replaceAll("");
        if (changeNumber.length() == 10) {
            if (changeNumber.charAt(0) == '9') {
                changeNumber = '7' + changeNumber;
                cheak = false;
            }
        }
        if (changeNumber.length() == 11) {
            if (changeNumber.charAt(0) == '7' | changeNumber.charAt(0) == '8'){
                changeNumber = '7' + changeNumber.substring(1);
                cheak = false;
            }
        }
        return cheak;
    }
}
