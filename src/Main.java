import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите 1-е число: ");
        int num1 = scanner.nextInt();

        System.out.print("Введите 2-е число: ");
        int num2 = scanner.nextInt();

        System.out.print("Выберите метод умножения (1, 2, 3): ");
        int methodChoice = scanner.nextInt();

        Integer result = null;

        switch (methodChoice) { // Выбираем метод умножения
            case 1:
                result = multiplyUsingLoop(num1, num2);
                break;
            case 2:
                result = multiplyUsingRecursion(num1, num2);
                break;
            case 3:
                result = multiplyUsingArray(num1, num2);
                break;
            default:
                // Если выбран метод, которого нет, присваиваем null
                break;
        }

        if (result != null) {
            System.out.println(result);
        } else {
            System.out.println("Такого способа нет");
        }
    }

    // Умножение с использованием цикла
    public static int multiplyUsingLoop(int num1, int num2) {
        int product = 0;
        if (num2 > 0) {
            for (int i = 0; i < num2; i++) {
                product += num1; // Если num2 > 0, плюсуем num1 num2 раз
            }
        } else {
            for (int i = 0; i < -num2; i++) {
                product += -num1; // Если num2 < 0, меняем знаки у num1 и num2
            }
        }
        return product;
    }

    // Умножение с помощью рекурсии
    public static int multiplyUsingRecursion(int num1, int num2) {
        if (num2 == 0) return 0; // Если num2 == 0, возвращаем 0
        if (num2 > 0) {
            return num1 + multiplyUsingRecursion(num1, num2 - 1); // Если num2 > 0, рекурсией плюсуем num1 num2 раз
        } else {
            return -num1 + multiplyUsingRecursion(num1, num2 + 1); // Если num2 < 0, то меняем знаки
        }
    }

    // Умножение с помощью массива
    public static int multiplyUsingArray(int num1, int num2) {
        int[] array;
        if (num2 > 0) {
            array = new int[num2]; // Создаем массив размера num2
            for (int i = 0; i < num2; i++) {
                array[i] = num1; // Заполняем массив элементами num1
            }
        } else if (num1 < 0 && num2 < 0) {
            array = new int[-num1]; // Меняем знаки для отрицательных чисел
            for (int i = 0; i < -num1; i++) {
                array[i] = -num2;
            }
        } else {
            array = new int[num1]; // Создаем массив размера num1 с элементами num2
            for (int i = 0; i < num1; i++) {
                array[i] = num2;
            }
        }

        int product = 0;
        for (int value : array) {
            product += value; // Через цикл суммируем элементы
        }
        return product;
    }
}
