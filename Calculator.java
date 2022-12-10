import java.util.Scanner;
import  java.lang.NumberFormatException;
public class Calculator {
    public static void main(String[] args) throws ScannerExcept {
        //Пользовательский ввод
        System.out.println("Здравствуйте. Это калькулятор для расчета арабских и римских цифр");
        System.out.println("Формат математической операции - два операнда в одной системе счисления и один оператор (+, -, /, *). Удачи");
        Scanner scanner = new Scanner(System.in);
        String stringInput = scanner.nextLine();
        String[] expression = stringInput.split(" ");

        // Проверка на ошибки
        if (expression.length < 3){
            throw new ScannerExcept ("Cтрока не является математической операцией");
        }
        // Вводим массив доступных операций
        String [] arifm = {"+","-","/","*"};
        // Проверка знака операции в выражении
        int indexarifm = -1;
        for (int i = 0; i < arifm.length; i ++) {
            indexarifm = expression[1].indexOf(arifm[i]);
            if (indexarifm != -1){
                break;
            }
        }
        // Проверка на ошибки
        if (indexarifm == -1 || expression.length > 3){
            throw new ScannerExcept ("Формат математической операции не удовлетворяет заданию - два операнда в одной системе счисления и один оператор (+, -, /, *)");
        }
        //Создаем проверку римских чисел
        String [] roma = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        int [] numbers = {1,2,3,4,5,6,7,8,9,10};
        //Проходим по вводу и ищем римские числа
        int intdexROMA = -1;
        int intdexROMA2 = -1;
        // Расчет
        try {
            for (int q = 0; q < roma.length; q++) {
                if (expression[0].equals(roma[q])) {
                    intdexROMA = q;
                }
            }
            for (int y = 0; y < roma.length; y++) {
                if (expression[2].equals(roma[y])) {
                    intdexROMA2 = y;
                }
            }
            if (intdexROMA == -1 && intdexROMA2 == -1) {
                // Проверка от 1 до 10
                //Перевод строковых данных в числа
                int numberFirst = Integer.parseInt(expression[0]);
                int numberSecond = Integer.parseInt(expression[2]);
                if (0 < numberFirst && numberFirst< 11) {
                    if(0< numberSecond && numberSecond < 11){
                        // Операции
                        switch (expression[1]) {
                            case "+":
                                System.out.println(numberFirst + numberSecond);
                                break;
                            case "-":
                                System.out.println(numberFirst - numberSecond);
                                break;
                            case "/":
                                System.out.println(numberFirst / numberSecond);
                                break;
                            case "*":
                                System.out.println(numberFirst * numberSecond);
                                break;
                        }
                    }
                } else {
                    System.out.println("Числа должны быть от 1 до 10");
                    }
            // Расчет Римских чисел
            }else if (intdexROMA != -1 && intdexROMA2 != -1) {
                //Перевод Римских в Арабские
                String [] rimDes = {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"};
                int [] numbersDes = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
                int numberFirstR = numbers[intdexROMA];
                int numberSecondR = numbers[intdexROMA2];
                // Операции
                switch (expression[1]) {
                    case "+":
                        int sloshenie = numberFirstR + numberSecondR;
                        if (sloshenie < 11) {
                            for (int s = 0; s < numbers.length; s++) {
                                if (numbers[s] == sloshenie) {
                                    System.out.println(roma[s]);
                                }
                            }
                        }else {
                            int indexNumbersDes_1 = (sloshenie / 10) * 10;
                            int indexNumbersDes_2 = sloshenie % 10;
                            for (int s = 0; s < numbersDes.length; s++) {
                                if (numbersDes[s] == indexNumbersDes_1) {
                                            indexNumbersDes_1 = s;
                                }
                            }
                            if (indexNumbersDes_2 != 0) {
                                for (int wer = 0; wer < numbers.length; wer++) {
                                    if (numbers[wer] == indexNumbersDes_2) {
                                        indexNumbersDes_2 = wer;
                                    }

                                }
                                        System.out.println(rimDes[indexNumbersDes_1] + roma[indexNumbersDes_2]);
                                    }else {System.out.println(rimDes[indexNumbersDes_1]);}
                                }
                        break;
                    case "-":
                        int minus = numberFirstR - numberSecondR;
                            if (minus < 0){
                                throw new ScannerExcept ("В римской системе нет отрицательных чисел");
                            }
                            for (int s = 0; s < numbers.length; s++) {
                                if (numbers[s] == minus) {
                                    System.out.println(roma[s]);
                                } else if (minus == 0) {
                                    System.out.println(0);
                                }
                            }
                        break;
                    case "/":
                        int delenie = numberFirstR / numberSecondR;
                            for (int s = 0; s < numbers.length; s++) {
                                if (numbers[s] == delenie) {
                                    System.out.println(roma[s]);
                                }
                            }
                        break;
                    case "*":
                        int umnoshenie = numberFirstR * numberSecondR;
                        if (umnoshenie < 11) {
                            for (int s = 0; s < numbers.length; s++) {
                                if (numbers[s] == umnoshenie) {
                                    System.out.println(roma[s]);
                                }
                            }
                                }else {
                                    int indexNumbersDes_1 = (umnoshenie / 10) * 10;
                                    int indexNumbersDes_2 =umnoshenie % 10;
                                    for (int s = 0; s < numbersDes.length; s++) {
                                        if (numbersDes[s] == indexNumbersDes_1) {
                                            indexNumbersDes_1 = s;
                                        }
                                    }
                                    if (indexNumbersDes_2 != 0) {
                                        for (int wer = 0; wer < numbers.length; wer++) {
                                            if (numbers[wer] == indexNumbersDes_2) {
                                                indexNumbersDes_2 = wer;
                                            }

                                        }
                                        System.out.println(rimDes[indexNumbersDes_1] + roma[indexNumbersDes_2]);
                                    }else {System.out.println(rimDes[indexNumbersDes_1]);}
                                }
                        break;
                        }
            }else if (intdexROMA == -1 && intdexROMA2 != -1) {
                int control = Integer.parseInt(expression[0]);
                for (int i = 0; i < numbers.length; i ++){
                    if(control == numbers[i]){
                        throw new ScannerExcept("Используются одновременно разные системы счисления");
                    }
                }
            }else if (intdexROMA != -1 && intdexROMA2 == -1) {
                int control = Integer.parseInt(expression[2]);
                for (int i = 0; i < numbers.length; i ++){
                    if(control == numbers[i]){
                        throw new ScannerExcept("Используются одновременно разные системы счисления");
                    }
                }
            }
        }catch (NumberFormatException e) {
            System.out.println("Используйте только целые числа");
        }
    }
}
