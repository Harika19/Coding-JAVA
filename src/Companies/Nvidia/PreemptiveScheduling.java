package Companies.Nvidia;

import java.util.*;
import java.util.stream.Collectors;

public class PreemptiveScheduling {

    public static List<Integer> getTotalExecutionTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<int[]> stack = new Stack<>();
        int prevTimestamp = 0;

        for (String log : logs) {
            String[] parts = log.split(":");
            int functionId = Integer.parseInt(parts[0]);
            String action = parts[1];
            int timestamp = Integer.parseInt(parts[2]);

            if ("start".equals(action)) {
                if (!stack.isEmpty()) {
                    int peekFunctionId = stack.peek()[0];
                    int prevTimeStampForPeekFunction = result[peekFunctionId];
                    result[peekFunctionId] = prevTimeStampForPeekFunction + (timestamp - prevTimestamp);
                }
                stack.push(new int[]{functionId, timestamp});
                prevTimestamp = timestamp;
            } else { // action.equals("end")
                result[functionId] += timestamp - prevTimestamp + 1;
                stack.pop();
                prevTimestamp = timestamp + 1;
            }
        }

        return Arrays.stream(result).boxed().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        int n = 3;
        String[] logs = {"0:start:0",
                "2:start:4",
                "2:end:5",
                "1:start:7",
                "1:end:10",
                "0:end:11"};
        List<Integer> result = getTotalExecutionTime(n, List.of(logs));

        System.out.println(result);
//        List<Integer> result1 = getTotalExecutionTime(2, List.of(new String[]{"0:start:0", "1:start:3", "1:end:6", "0:end:10"}));
//        System.out.println(result1);
//
//        System.out.println(getTotalExecutionTime(3, List.of(new String[]{"0:start:0", "1:start:3", "1:end:6", "2:start:8", "2:end:10", "0:end:12"})));
    }
}
