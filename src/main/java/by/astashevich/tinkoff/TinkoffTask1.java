package by.astashevich.tinkoff;

import java.util.Scanner;

/*
  Цифровой шифр
 Коля с Димой обмениваются зашифрованными сообщениями.Исходящее сообщение состоит только из десятичных цифр.При передаче сообщения через интернет некоторые цифры могут стираться,поэтому сообщение,которое получает собеседник,помимо цифр может содержать символ «?» (вопросительный знак).
 Чтобы никто не мог вмешаться в переписку друзей,они шифруют сообщения специальным образом.Для этого они вставляют некоторую перестановку последовательности цифр от 0до 9в произвольное место сообщения.
 Коля получил очередное сообщение и просит вас помочь узнать,мог ли это сообщение отправить его друг Дима?

 Формат входных данных
 В единственной строке входных данных дана строка из десятичных цифр и вопросительных знаков.Длина строки не превышает   2*10^5

 Формат выходных данных
 Выведите одно слово"YES"(без кавычек),если такое сообщение мог отправить Дима,или"NO"(без кавычек),если это не так.

 Примеры данных

 Пример 1
 1234??7890   -  YES

 Пример 2
 11223344550?2?4?6?80?6677889900   -  YES

 Пример 3
 0?2?4?6?802?   -  NO

 */
public class TinkoffTask1 {

    public static final String TRUE_RESULT = "YES";
    public static final String FALSE_RESULT = "NO";
    private static final char MISSING_VALUE = '?';
    private static final char EMPTY_VALUE = '\u0000';

    public static void main(String[] args) {
        char[] entrance = getInputArrayFromConsole();
        boolean isPossibleLine = isPossibleLine(entrance);
        System.out.println(isPossibleLine ? TRUE_RESULT : FALSE_RESULT);
    }

    public static char[] getInputArrayFromConsole() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next().toCharArray();
    }

    public static boolean isPossibleLine(char[] entranceSequence) {
        char[] array = new char[10];
        boolean isPossible = false;
        mainloop:
        for (int i = 0; i < entranceSequence.length; i++) {
            char currentChar = entranceSequence[i];
            if (currentChar == MISSING_VALUE) {
                for (int j = 0; j < 10; j++) {
                    if (array[j] == EMPTY_VALUE) {
                        array[j] = currentChar;
                        if (j == 9) {
                            isPossible = true;
                            break mainloop;
                        }
                        break;
                    }
                }
            } else {
                for (int j = 0; j < 10; j++) {
                    if (array[j] == EMPTY_VALUE) {
                        array[j] = currentChar;
                        if (j == 9) {
                            isPossible = true;
                            break mainloop;
                        }
                        break;
                    }
                    if (array[j] == currentChar) {
                        array = reorderArray(array, j);
                        break;
                    }
                }
            }
        }
        return isPossible;
    }


    public static char[] reorderArray(char[] oldArray, int positionToReorder) {
        char[] newArray = new char[10];
        int currentPosition = 0;
        for (int i = positionToReorder; i < 9; i++) {
            char currentValueToInsert = oldArray[i];
            if (currentValueToInsert == EMPTY_VALUE) {
                break;
            }
            newArray[currentPosition] = currentValueToInsert;
            currentPosition += 1;
        }
        return newArray;
    }

}
