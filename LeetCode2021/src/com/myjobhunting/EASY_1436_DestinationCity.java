package com.myjobhunting;
// https://leetcode.com/problems/destination-city/

import java.util.*;

/*
You are given the array paths, where paths[i] = [cityAi, cityBi]
means there exists a direct path going from cityAi to cityBi.
Return the destination city, that is, the city without any path outgoing to another city.

It is guaranteed that the graph of paths forms a line without any loop,
therefore, there will be exactly one destination city.

Example 1:
Input: paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
Output: "Sao Paulo"
Explanation: Starting at "London" city you will reach "Sao Paulo" city which is the destination city.
Your trip consist of: "London" -> "New York" -> "Lima" -> "Sao Paulo".

Example 2:
Input: paths = [["B","C"],["D","B"],["C","A"]]
Output: "A"
Explanation: All possible trips are:
"D" -> "B" -> "C" -> "A".
"B" -> "C" -> "A".
"C" -> "A".
"A".
Clearly the destination city is "A".

Example 3:
Input: paths = [["A","Z"]]
Output: "Z"

Constraints:

1 <= paths.length <= 100
paths[i].length == 2
1 <= cityAi.length, cityBi.length <= 10
cityAi != cityBi
All strings consist of lowercase and uppercase English letters and the space character.
 */
public class EASY_1436_DestinationCity {

    // same as the others
    public String destCity(List<List<String>> paths) {
        Set<String> set = new HashSet<>();
        for(List<String> path: paths){
            set.add(path.get(0));
        }
        for(List<String> path: paths){
            if(!set.contains(path.get(1))) return path.get(1);
        }
        return "";
    }

    /*
    Runtime: 3 ms, faster than 72.40% of Java online submissions for Destination City.
    Memory Usage: 44.2 MB, less than 14.37% of Java online submissions for Destination City.
     */
    public String destCity1(List<List<String>> paths) {
        Set<String> set= new HashSet<>();
        for (List<String> path: paths) set.add(path.get(1));
        for (List<String> path: paths) set.remove(path.get(0));
        return set.iterator().next();
    }
    // initial solution
    /*
    Runtime: 3 ms, faster than 72.40% of Java online submissions for Destination City.
    Memory Usage: 44.6 MB, less than 5.03% of Java online submissions for Destination City.
     */
    public String destCity0(List<List<String>> paths) {
        Set<String> orig = new HashSet<>();
        Set<String> dest = new HashSet<>();
        for(List<String> path : paths)
        {
            orig.add(path.get(0));
            dest.add(path.get(1));
        }
        for(String city : dest)
        {
            if(!orig.contains(city))
                return city;
        }
        return "";
    }

}
