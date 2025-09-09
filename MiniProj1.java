import java.util.Scanner;

class PasswordStrengthChecker {
    int length;
    int count = 0;
    String password;
    int criteria = 5;
    boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;

    public PasswordStrengthChecker(String password) {
        this.password = password;
        length = password.length();
    }

    String checker() {
        if (length < 6) {
            return "Weak Strength add more length for better security";
        } else {
            count++;

            for (int i = 0; i < length; i++) {
                char passChar = password.charAt(i);
                if (passChar>='A' && passChar<='Z') {
                    count++;
                    hasUpper = true;
                    break;
                }
            }
            for (int i = 0; i < length; i++) {
                char passChar = password.charAt(i);
                if (passChar>='a' && passChar<='z') {
                    count++;
                    hasLower = true;
                    break;
                }
            }
            for (int i = 0; i < length; i++) {
                char passChar = password.charAt(i);
                if (passChar>='0' && passChar<='9') {
                    count++;
                    hasDigit = true;
                    break;
                }
            }
            for (int i = 0; i < length; i++) {
                char passChar = password.charAt(i);
                if (!(Character.isLetterOrDigit(passChar))) {
                    count++;
                    hasSpecial = true;
                    break;
                }
            }
        }
        if (count >= criteria) {
            return "Strong Strength";
        } else {
            StringBuilder feedback = new StringBuilder("Medium strength, your password is missing: ");

            if (!hasUpper) {
                feedback.append("upper character, ");
            }
            if (!hasLower) {
                feedback.append("lower character, ");
            }
            if (!hasDigit) {
                feedback.append("digit, ");
            }
            if (!hasSpecial) {
                feedback.append("special character, ");
            }

            feedback.setLength(feedback.length() - 2);
            return new String(feedback);
        }
    }
}

public class MiniProj1 {
    public static void main(String... args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the password: ");
        String pass = scan.nextLine();

        PasswordStrengthChecker psc = new PasswordStrengthChecker(pass);
        String res = psc.checker();
        System.out.println("Password Strength: " + res);
        scan.close();
    }
}