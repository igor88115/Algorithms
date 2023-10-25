package by.astashevich.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.


    Example 1:

    Input: s = "()"
    Output: true
    Example 2:

    Input: s = "()[]{}"
    Output: true
    Example 3:

    Input: s = "(]"
    Output: false


    Constraints:

    1 <= s.length <= 104
    s consists of parentheses only '()[]{}'.
 */
public class ValidParentheses {

  private static final Map<Character, Character> OPEN_CLOSE_BRACKETS =
      Map.of('[', ']',
          '{', '}',
          '(', ')');

  public boolean isValid(String s) {
    Deque<Character> usedCharacters = new LinkedList<>() {
    };

    for (char ch : s.toCharArray()) {
      if (isOpeningBracket(ch)) {
        usedCharacters.push(ch);
      } else if (usedCharacters.isEmpty() || !areOfOneKind(usedCharacters.pop(), ch)){
        return false;
      }
    }
    return usedCharacters.isEmpty();
  }

  public boolean isOpeningBracket(char character) {
    return OPEN_CLOSE_BRACKETS.containsKey(character);
  }

  public boolean areOfOneKind(char opening, char closing) {
    return OPEN_CLOSE_BRACKETS.get(opening) == closing;
  }

}
