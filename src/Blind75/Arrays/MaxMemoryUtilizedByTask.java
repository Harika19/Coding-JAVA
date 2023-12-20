//Tasks with memory required to process are given which should be run in a processor.
//        Tasks : [1,4,5,2,3] (the numbers represent memory needed)
//        Type of tasks are given in another array
//        Task Type : [1,2,1,3,4]
//        Another input is given which is the max memory the processor can run at a time.
//        Max_memory : 6
//        Now only two tasks with same task type can run in parallel. Assume each tasks take 1 unit of time. Find out the time taken to complete all the tasks.
//        Sample output : 4 units. Because there are two tasks of type 1 and adding their memory is 6 which is eq to max_memory. So they ll run in parallel.
//        All other tasks are of different types and their memories are less than max_memory. So they ll each take 1 unit of time.
package Blind75.Arrays;

import java.util.HashMap;

public class MaxMemoryUtilizedByTask {
    public static int calculateTime(int[] tasks, int[] taskTypes, int maxMemory) {
        HashMap<Integer, Integer> memoryMap = new HashMap<>();

        for (int i = 0; i < tasks.length; i++) {
            memoryMap.put(taskTypes[i], memoryMap.getOrDefault(taskTypes[i], 0) + tasks[i]);
        }

        int totalTime = 0;

        for (int memory : memoryMap.values()) {
            if (memory <= maxMemory) {
                totalTime += 1;
            } else {
                totalTime += Math.ceil( memory / maxMemory);
            }
        }
        return totalTime;
    }

    public static void main(String[] args) {
        int[] tasks = {1, 4, 5, 2, 3};
        int[] taskTypes = {1, 2, 1, 3, 4};
        int maxMemory = 6;

        System.out.println(calculateTime(tasks, taskTypes, maxMemory));
    }
}
