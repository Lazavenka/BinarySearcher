import java.util.Arrays;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
//        int[] array = {1, 3, 5, 6, 8, 9, 10, 22, 44, 55, 66, 77, 110};
//        int key = 110;
//        int indexOfKey = BinarySearcher.search(array, key, 0, array.length - 1);
//        System.out.printf("Index of key \"%d\" is %d\n", key, indexOfKey);

        Scanner in = new Scanner(System.in);
        System.out.println("The program performs a binary search in Ints array.");
        int[] array = new int[0];
        int keyIndex;
        while (true) {
            System.out.print(
                    """
                            Choose menu:
                            0. Exit
                            1. Input array
                            2. Generate random array
                            3. Search index of key
                            -->>>>>>\s""");
            int choice = getPositiveNumberFromConsole(in, "Select menu item: ", 3);
            if (choice == 0)
                break;
            switch (choice) {
                case 1 -> {
                    array = getArrayFromConsole(in);
                    System.out.println(Arrays.toString(array));
                }
                case 2 -> {
                    array = new RandomSortedArray(getPositiveNumberFromConsole(in, "Input size"),
                            getPositiveNumberFromConsole(in, "Input border of random numbers")).getArray();
                    System.out.println("Generated array: " + Arrays.toString(array));

                }

                case 3 -> {
                    int key = getPositiveNumberFromConsole(in, "Input key:");
                    keyIndex = BinarySearcher.search(array, key, 0, array.length - 1);
                    System.out.printf("Index of key \"%d\" is %d\n", key, keyIndex);
                }
                default -> throw new IllegalStateException("Unexpected value: " + choice);
            }
        }

    }

    private static int[] getArrayFromConsole(Scanner in) {
        int[] array = new int[getPositiveNumberFromConsole(in, "Input array size (>0)")];
        for (int i = 0; i < array.length; i++) {
            array[i] = getPositiveNumberFromConsole(in, "Input " + i + " number -> ");
        }
        Arrays.sort(array);
        return array;
    }

    private static int getPositiveNumberFromConsole(Scanner in, String comment) {
        int number;
        do {
            System.out.println(comment);
            while (!in.hasNextInt()) {
                System.out.println("Incorrect input!");
                in.next();
            }
            number = in.nextInt();
        } while (number <= 0);
        return number;
    }

    private static int getPositiveNumberFromConsole(Scanner in, String comment, int border) {
        int number;
        do {
            System.out.println(comment);
            while (!in.hasNextInt()) {
                System.out.println("Incorrect input!");
                in.next();
            }
            number = in.nextInt();
        } while (number < 0 || number > border);
        return number;
    }
}
