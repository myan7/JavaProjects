package com.myjobhunting;

// https://leetcode.com/problems/logger-rate-limiter/

import java.util.HashMap;

/*
Design a logger system that receives a stream of messages along with their timestamps.
Each unique message should only be printed at most every 10 seconds
(i.e. a message printed at timestamp t will prevent other identical messages from being printed until timestamp t + 10).

All messages will come in chronological order.
Several messages may arrive at the same timestamp.

Implement the Logger class:
Logger() Initializes the logger object.
bool shouldPrintMessage(int timestamp, string message)
Returns true if the message should be printed in the given timestamp, otherwise returns false.

Example 1:
Input
["Logger", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage"]
[[], [1, "foo"], [2, "bar"], [3, "foo"], [8, "bar"], [10, "foo"], [11, "foo"]]
Output
[null, true, true, false, false, false, true]

Explanation
Logger logger = new Logger();
logger.shouldPrintMessage(1, "foo");  // return true, next allowed timestamp for "foo" is 1 + 10 = 11
logger.shouldPrintMessage(2, "bar");  // return true, next allowed timestamp for "bar" is 2 + 10 = 12
logger.shouldPrintMessage(3, "foo");  // 3 < 11, return false
logger.shouldPrintMessage(8, "bar");  // 8 < 12, return false
logger.shouldPrintMessage(10, "foo"); // 10 < 11, return false
logger.shouldPrintMessage(11, "foo"); // 11 >= 11, return true, next allowed timestamp for "foo" is 11 + 10 = 21


Constraints:
0 <= timestamp <= 10^9
Every timestamp will be passed in non-decreasing order (chronological order).
1 <= message.length <= 30
At most 104 calls will be made to shouldPrintMessage.
 */
public class EASY_359_LoggerRateLimiter {

    /*
    Runtime: 44 ms, faster than 72.76% of Java online submissions for Logger Rate Limiter.
    Memory Usage: 65.7 MB, less than 38.53% of Java online submissions for Logger Rate Limiter.
     */

    class Logger {

        public HashMap<String, Integer> msgMap;
        public Logger() {
            msgMap = new HashMap<>();
        }

        public boolean shouldPrintMessage(int timestamp, String message) {

            if(!this.msgMap.containsKey(message))
            {
                this.msgMap.put(message, timestamp);
                return true;
            }
            else
            {
                if(timestamp - this.msgMap.get(message) >=10)
                {
                    this.msgMap.put(message,timestamp);
                    return true;
                }
                else
                    return false;
            }
        }
    }
    /*
    Runtime: 75 ms, faster than 11.70% of Java online submissions for Logger Rate Limiter.
    Memory Usage: 66.2 MB, less than 16.66% of Java online submissions for Logger Rate Limiter.
     */

    class Message
    {
        int timeStamp;
        String message;
        public Message(){};
        public Message(int timeStamp, String message)
        {
            this.timeStamp = timeStamp;
            this.message = message;
        }
    }

    public HashMap<String, Message> map;
    public EASY_359_LoggerRateLimiter() {
        map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {

        if(map.containsKey(message))
        {
            if(timestamp < map.get(message).timeStamp)
                return false;
            else
            {
                Message tmp = new Message(timestamp+10,message);
                map.put(message,tmp);
                return true;
            }
        }
        else {
            Message tmp = new Message(timestamp+10, message);
            map.put(message, tmp);
            return true;
        }
    }

    public static void main(String[] args)
    {
        EASY_359_LoggerRateLimiter solution = new EASY_359_LoggerRateLimiter();
        System.out.println(solution.shouldPrintMessage(1,"foo"));
        solution.shouldPrintMessage(1,"foo");
        solution.shouldPrintMessage(2,"bar");
        solution.shouldPrintMessage(3,"foo");
        solution.shouldPrintMessage(8,"bar");
        solution.shouldPrintMessage(10,"foo");
        System.out.println(solution.shouldPrintMessage(10,"foo"));
        System.out.println(solution.shouldPrintMessage(11,"foo"));
    }

}
