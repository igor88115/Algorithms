package by.astashevich.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


//*Your program should get two parameters from command line:
//
//- string of size N^2, that describes square matrix of characters N*N;
//
//- string that describes given word.
//
//The first string is converting to matrix using the following rule. String "QWEASDZXC" forms the matrix:
//
//['Q','W','E',
//
// 'A','S','D',
//
// 'Z','X','C']
//

// Q L G N
// A E K I
// R L R J
// G E A E
//
//
//Your program should print to the console the sequence of cells those build the given word.
//
//Every next character of word can be placed just in the neighbor cell: on the top, on the bottom, on the left or on the right from the cell with previous character.
//
//E.g. if it is given matrix "QLGNAEKIRLRNGEAE" and word "KING", then sequence of cells will be [1,2]->[1,3]->[0,3]->[0,2]


// probably needs refactoring
public class FindFirstRouteInMatrix {

  public static void main(String[] args) {
    List<Coordinate> coordinates = getRoute("QLGNAEKIRLRNGEAE", "KING");
    coordinates.forEach(System.out::println);
  }

  //  transforms a string into a matrix and delegates work to another method that accepts matrix of characters.
  static List<Coordinate> getRoute(String matrixString, String searchable) {
    int matrixPower = (int) Math.round(Math.sqrt(matrixString.length()));
    char[][] matrix = new char[matrixPower][matrixPower];
    int i = 0;
    for (int row = 0; row < matrix.length; row++) {
      for (int column = 0; column < matrix[row].length; column++) {
        matrix[row][column] = matrixString.charAt(i++);
      }
    }
    return getRoute(matrix, searchable);
  }


  //  finds the first element, and other elements can be found with recursion.
  public static List<Coordinate> getRoute(char[][] matrix, String searchable) {

    for (int row = 0; row < matrix.length; row++) {
      for (int column = 0; column < matrix[row].length; column++) {
        if (matrix[row][column] == searchable.charAt(0)) {
          Coordinate firstCoordinate = new Coordinate(row, column, matrix[row][column]);
          if (searchable.length() > 1) {
            List<Coordinate> foundCoordinates = findWay(matrix, row, column, searchable, 1);
            if (!foundCoordinates.isEmpty()) {
              List<Coordinate> coordinates = new ArrayList<>(searchable.length());
              coordinates.add(firstCoordinate);
              coordinates.addAll(foundCoordinates);
              return coordinates;
            }
          } else {
            return Collections.singletonList(firstCoordinate);
          }
        }
      }
    }
    return Collections.emptyList();
  }

  private static List<Coordinate> findWay(char[][] matrix, int row, int column, String searchable, int index) {
    char searchableChar = searchable.toCharArray()[index];
    boolean isFinalCharacter = searchable.length() == index + 1;
    ArrayList<Coordinate> coordinates = new ArrayList<>();

    boolean isUpperValue = matrix.length - 1 > row && searchableChar == matrix[row + 1][column];
    boolean isLowerValue = row > 0 && searchableChar == matrix[row - 1][column];
    boolean isRightValue = matrix[0].length - 1 > column && searchableChar == matrix[row][column + 1];
    boolean isLeftValue = column > 0 && searchableChar == matrix[row][column - 1];

    if (isFinalCharacter) {
      if (isUpperValue) {
        return Collections.singletonList(new Coordinate(row + 1, column, matrix[row + 1][column]));
      }
      if (isLowerValue) {
        return Collections.singletonList(new Coordinate(row - 1, column, matrix[row - 1][column]));
      }
      if (isRightValue) {
        return Collections.singletonList(new Coordinate(row, column + 1, matrix[row][column + 1]));
      }
      if (isLeftValue) {
        return Collections.singletonList(new Coordinate(row, column - 1, matrix[row][column - 1]));
      }
    } else {

      if (isUpperValue) {
        List<Coordinate> results = findWay(matrix, row + 1, column, searchable, index + 1);
        if (results.size() == searchable.length() - index - 1) {
          coordinates.add(new Coordinate(row + 1, column, matrix[row + 1][column]));
          coordinates.addAll(findWay(matrix, row + 1, column, searchable, index + 1));
          return coordinates;
        }
      }

      if (isRightValue) {
        List<Coordinate> results = findWay(matrix, row, column + 1, searchable, index + 1);
        if (results.size() == searchable.length() - index - 1) {
          coordinates.add(new Coordinate(row, column + 1, matrix[row][column + 1]));
          coordinates.addAll(findWay(matrix, row, column + 1, searchable, index + 1));
          return coordinates;
        }
      }

      if (isLowerValue) {
        List<Coordinate> results = findWay(matrix, row - 1, column, searchable, index + 1);
        if (results.size() == searchable.length() - index - 1) {
          coordinates.add(new Coordinate(row - 1, column, matrix[row - 1][column]));
          coordinates.addAll(findWay(matrix, row - 1, column, searchable, index + 1));
          return coordinates;
        }
      }

      if (isLeftValue) {
        List<Coordinate> results = findWay(matrix, row, column - 1, searchable, index + 1);
        if (results.size() == searchable.length() - index - 1) {
          coordinates.add(new Coordinate(row, column - 1, matrix[row][column - 1]));
          coordinates.addAll(findWay(matrix, row, column - 1, searchable, index + 1));
          return coordinates;
        }
      }
    }
    return Collections.emptyList();
  }

}

class Coordinate {
  int x;
  int y;
  char value;

  public Coordinate(int x, int y, char value) {
    this.x = x;
    this.y = y;
    this.value = value;
  }

  @Override
  public String toString() {
    return "Coordinate{" +
        "x=" + x +
        ", y=" + y +
        ", value=" + value +
        '}';
  }

}
