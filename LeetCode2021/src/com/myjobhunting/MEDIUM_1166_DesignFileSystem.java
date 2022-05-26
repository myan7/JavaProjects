package com.myjobhunting;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/design-file-system/
/*
You are asked to design a file system that allows you to create new paths and associate them with different values.

The format of a path is one or more concatenated strings of the form: / followed by one or more lowercase English letters.
For example, "/leetcode" and "/leetcode/problems" are valid paths
while an empty string "" and "/" are not.

Implement the FileSystem class:

bool createPath(string path, int value)
Creates a new path and associates a value to it if possible and returns true.
Returns false if the path already exists or its parent path doesn't exist.

int get(string path) Returns the value associated with path or returns -1 if the path doesn't exist.


Example 1:

Input:
["FileSystem","createPath","get"]
[[],["/a",1],["/a"]]
Output:
[null,true,1]
Explanation:
FileSystem fileSystem = new FileSystem();
fileSystem.createPath("/a", 1); // return true
fileSystem.get("/a"); // return 1

Example 2:
Input:
["FileSystem","createPath","createPath","get","createPath","get"]
[[],["/leet",1],["/leet/code",2],["/leet/code"],["/c/d",1],["/c"]]
Output:
[null,true,true,2,false,-1]
Explanation:
FileSystem fileSystem = new FileSystem();

fileSystem.createPath("/leet", 1); // return true
fileSystem.createPath("/leet/code", 2); // return true
fileSystem.get("/leet/code"); // return 2
fileSystem.createPath("/c/d", 1); // return false because the parent path "/c" doesn't exist.
fileSystem.get("/c"); // return -1 because this path doesn't exist.


Constraints:

The number of calls to the two functions is less than or equal to 10^4 in total.
2 <= path.length <= 100
1 <= value <= 10^9
 */
public class MEDIUM_1166_DesignFileSystem {

    /*
    Runtime: 86 ms, faster than 92.48% of Java online submissions for Design File System.
    Memory Usage: 50.7 MB, less than 96.24% of Java online submissions for Design File System.
     */
    class FileSystem {

        HashMap<String, Integer> paths;

        public FileSystem() {
            this.paths = new HashMap<String, Integer>();
        }

        public boolean createPath(String path, int value) {

            // Step-1: basic path validations
            if (path.isEmpty() || (path.length() == 1 && path.equals("/")) || this.paths.containsKey(path)) {
                return false;
            }

            int delimIndex = path.lastIndexOf("/");
            String parent = path.substring(0, delimIndex);

            // Step-2: if the parent doesn't exist. Note that "/" is a valid parent.
            if (parent.length() > 1 && !this.paths.containsKey(parent)) {
                return false;
            }

            // Step-3: add this new path and return true.
            this.paths.put(path, value);
            return true;
        }

        public int get(String path) {
            return this.paths.getOrDefault(path, -1);
        }
    }


    /*
    Runtime: 103 ms, faster than 80.62% of Java online submissions for Design File System.
    Memory Usage: 50.7 MB, less than 96.24% of Java online submissions for Design File System.
     */
    class FileSystem0 {

        Map<String, Integer> files;

        public FileSystem0() {
            files = new HashMap<>();
        }

        public boolean createPath(String path, int value) {
            String[] paths = path.split("/");
            if(paths.length == 2)
            {
                if(get(path) != -1)
                    return false;
                else
                    files.put(path,value);
                return true;
            }

            StringBuilder tmp = new StringBuilder();
            for(int i = 1; i < paths.length-1; i++)
            {
                tmp.append("/").append(paths[i]);
                if(get(tmp.toString()) == -1)
                    return false;
            }
            if(get(path) != -1)
                return false;
            files.put(path,value);
            return true;
        }

        public int get(String path) {
            return files.getOrDefault(path,-1);
        }
    }

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */
}
