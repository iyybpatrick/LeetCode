import java.util.*;

public class AcquireRelease {
    public int detect(String[] inputs) {
        Set<Integer> set = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < inputs.length; i++) {
           String[] ss = inputs[i].split(" ");
            String status = ss[0];
            int id = Integer.parseInt(ss[1]);
            if (status.equals("ACQUIRE")) {
                if (set.contains(id)) {
                    return i + 1;
                } else {
                    set.add(id);
                    stack.push(id);
                }
            } else {
                if (stack.isEmpty() || stack.pop() != id) {
                    return i + 1;
                } else {
                    set.remove(id);
                             }
            }
        }
        if (stack.isEmpty()) {
            return 0;
        } else {
            return 1 + inputs.length;
        }
    }

    public static void main(String[] args) {
        AcquireRelease ob = new AcquireRelease();

        String[] inputs1 = new String[]{"ACQUIRE 364", "ACQUIRE 84", "RELEASE 84", "RELEASE 364"};
        int res1 = ob.detect(inputs1);
        System.out.println("Expected output: 0");
        System.out.println("My output: " + res1);
        System.out.println();
        int dis = 2;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(10, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
        String abc = "hello";




        String[] inputs2 = new String[]{"ACQUIRE 364", "ACQUIRE 84", "RELEASE 364", "RELEASE 84"};
        int res2 = ob.detect(inputs2);
        System.out.println("Expected output: 3");
        System.out.println("My output: " + res2);
        System.out.println();

        String[] inputs3 = new String[]{"ACQUIRE 123", "ACQUIRE 364", "ACQUIRE 84", "RELEASE 84", "RELEASE 364", "ACQUIRE 456"};
        int res3 = ob.detect(inputs3);
        System.out.println("Expected output: 7");
        System.out.println("My output: " + res3);
        System.out.println();

        String[] inputs4 = new String[]{"ACQUIRE 123", "ACQUIRE 364", "ACQUIRE 84", "RELEASE 84",
                "RELEASE 364", "ACQUIRE 789", "RELEASE 456", "RELEASE 123"};
        int res4 = ob.detect(inputs4);
        System.out.println("Expected output: 7");
        System.out.println("My output: " + res4);
        System.out.println();

        String[] inputs5 = new String[]{"ACQUIRE 364", "ACQUIRE 84", "ACQUIRE 364", "RELEASE 364"};
        int res5 = ob.detect(inputs5);
        System.out.println("Expected output: 3");
        System.out.println("My output: " + res5);
        System.out.println();
    }
}
