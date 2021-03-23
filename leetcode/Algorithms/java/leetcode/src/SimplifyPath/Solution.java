package SimplifyPath;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return null;
        }
        if (path.length() == 1) {
            return path;
        }


        String[] strArrys = path.split("/+");
        StringBuilder sb = new StringBuilder();
        //Stack<String> stack = new Stack<>();
        Deque<String> deque = new LinkedList<>();
        for (String s : strArrys) {
            if (s.isBlank() || s.equals(".")) {
                continue;
            }

            if (s.equals("..")) {
                if (!deque.isEmpty()) {
                    deque.removeLast();
                }
                continue;
            }

            deque.add(s);
        }
        if (deque.isEmpty()) {
            return "/";
        }

        while (!deque.isEmpty()) {
            sb.append("/");
            sb.append(deque.removeFirst());
        }
        //sb.insert(0, '/');

        return sb.toString();
    }

/*    @Test
    public void test() {
        String str = simplifyPath("/b//a");
        System.out.println(str.length);
        for (String s : str) {
            if (!s.isBlank()) {
                System.out.println(s);
            }

        }
    }*/
}
