package com.myjobhunting;

// https://leetcode.com/problems/goal-parser-interpretation/

import java.util.HashMap;
import java.util.Map;

/*
You own a Goal Parser that can interpret a string command.
The command consists of an alphabet of "G", "()" and/or "(al)" in some order.
The Goal Parser will interpret "G" as the string "G", "()" as the string "o", and "(al)" as the string "al".
The interpreted strings are then concatenated in the original order.

Given the string command, return the Goal Parser's interpretation of command.

Example 1:
Input: command = "G()(al)"
Output: "Goal"
Explanation: The Goal Parser interprets the command as follows:
G -> G
() -> o
(al) -> al
The final concatenated result is "Goal".

Example 2:
Input: command = "G()()()()(al)"
Output: "Gooooal"

Example 3:
Input: command = "(al)G(al)()()G"
Output: "alGalooG"

Constraints:
1 <= command.length <= 100
command consists of "G", "()", and/or "(al)" in some order.
 */

public class EASY_1678_GoalParserInterpretation {

    /*
    Runtime: 1 ms, faster than 84.83% of Java online submissions for Goal Parser Interpretation.
    Memory Usage: 41.6 MB, less than 62.07% of Java online submissions for Goal Parser Interpretation.
     */
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'G') {
                sb.append('G');
            } else if (i + 1 < command.length() && command.charAt(i + 1) == ')') {
                sb.append('o');
                i++;
            } else {
                sb.append("al");
                i = i + 3;
            }
        }
        return sb.toString();
    }
    // 2 ms
    public String interpret1(String command) {
        return command.replace("()","o").replace("(al)","al");
    }

    // regex
    public String interpretRegex(String command) {
        return command.replaceAll("\\(\\)", "o").replaceAll("\\(al\\)", "al");
    }

    /*
    Runtime: 2 ms, faster than 32.89% of Java online submissions for Goal Parser Interpretation.
    Memory Usage: 42 MB, less than 46.44% of Java online submissions for Goal Parser Interpretation.
     */
    public String interpret0(String command) {
        Map<String, String> map = new HashMap<>();
        map.put("()","o");
        map.put("(al)","al");
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i< command.length(); i++)
        {
            char curr = command.charAt(i);
            if(curr =='(' )
            {
                if(i+1 == command.length())
                    sb.append(curr);
                else if(map.containsKey(command.substring(i,i+2)))
                {
                    sb.append(map.get(command.substring(i,i+2)));
                    i += 1;
                }
                else if(map.containsKey(command.substring(i,i+4)))
                {
                    sb.append(map.get(command.substring(i,i+4)));
                    i += 3;
                }
            }
            else
                sb.append(curr);
        }
        return sb.toString();
    }
}
