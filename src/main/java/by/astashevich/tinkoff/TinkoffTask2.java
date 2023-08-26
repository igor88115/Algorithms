package by.astashevich.tinkoff;

import java.util.Objects;
import java.util.Scanner;

/*
Старый термометр
Недавно Никита занялся наблюдениями за погодой. Для своей цели он использует термометр со шкалой, отметки которой проходят через каждый градус. К сожалению, подписи на этой шкале стерлись, поэтому единственное, что можно узнать по этому термометру — то, на сколько градусов изменилась температура относительно предыдущего дня.
Никита знает, что при отрицательной температуре вода замерзает. Это помогает ему определять, отрицательная температура на улице или нет.

Вам даны данные наблюдений за предыдущие n дней: на сколько градусов изменилась температура относительно предыдущего дня и была температура в день измерений не отрицательной или нет. Какая максимальная температура могла быть в последний день наблюдений?

Формат входных данных
В первой строке входных данных дано целое число n — количество наблюдений 1<= n <= 2 * 10^5

В следующих n строках задано описание каждого измерения: целое число di — то, на сколько изменилась температура относительно предыдущего измерения, и «-» или «0+» — была температура в момент наблюдения i отрицательной или нет (то есть была положительной или равной 0) -100 <= di <= 100

Формат выходных данных
В единственной строке выведите максимальное значение температуры, которое могло быть в последний день наблюдений, или "inf" (без кавычек), если температура могла быть сколь угодно большой.

 Примеры данных

Пример 1
4
3 0+
-5 -
2 0+
-1 0+   - Вывод: 0

Пример 2
5
0 -
8 -
4 0+
-3 0+
5 0+   - Вывод: 5

Пример 3
1
0 0+   - Вывод: inf

*/
public class TinkoffTask2 {

  public static final String COULD_BE_INFINITELY_HIGH_RESULT = "inf";

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int numberOfRecords = scanner.nextInt();

    int max = Integer.MAX_VALUE;
    Boolean previousIsNegative = null;

    for (int i = 0; i < numberOfRecords; i++) {
      int newValue = scanner.nextInt();
      boolean isNegative = Objects.equals(scanner.next(), "-");
      if (previousIsNegative == null) {      // initialization
        if (isNegative) {
          max = -1;
          previousIsNegative = true;
        } else
          previousIsNegative = false;
      } else {
        if (previousIsNegative && isNegative) {     // Both negative
          if (max != Integer.MAX_VALUE)
            max += newValue;
          if (max >= 0) {
            max = -1;
          }
        } else if (previousIsNegative && !isNegative) {   // From negative To Positive
          if (max != Integer.MAX_VALUE)
            max += newValue;
          if (max < 0) {
            max = 0;
          }
        } else if (!previousIsNegative && isNegative) {   // from positive To negative
          if (max != Integer.MAX_VALUE)
            max += newValue;
          if (max >= 0) {
            max = -1;
          }
        } else {                                            // both positive
          if (max != Integer.MAX_VALUE)
            max += newValue;
          if (max < 0) {
            max = 0;
          }
        }
        previousIsNegative = isNegative;
      }
    }
    System.out.println(max != Integer.MAX_VALUE ? max : COULD_BE_INFINITELY_HIGH_RESULT);

  }

}
