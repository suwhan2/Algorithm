import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    static int N, Q, I;
    static char C;
    static Deque<Integer>[] DQ = new Deque[2];
    static int Now_Page = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        Q = scanner.nextInt();
        DQ[0] = new ArrayDeque<>();
        DQ[1] = new ArrayDeque<>();

        while (Q-- > 0) {
            C = scanner.next().charAt(0);
            if (C == 'B') {
                if (!DQ[0].isEmpty()) {
                    DQ[1].addFirst(Now_Page);
                    Now_Page = DQ[0].removeLast();
                }
            } else if (C == 'F') {
                if (!DQ[1].isEmpty()) {
                    DQ[0].addLast(Now_Page);
                    Now_Page = DQ[1].removeFirst();
                }
            } else if (C == 'A') {
                I = scanner.nextInt();
                if (Now_Page != -1) {
                    DQ[1].clear();
                    DQ[0].addLast(Now_Page);
                }
                Now_Page = I;
            } else if (C == 'C') {
                Deque<Integer> New = new ArrayDeque<>();
                while (!DQ[0].isEmpty()) {
                    if (New.isEmpty() || !New.getLast().equals(DQ[0].getFirst())) {
                        New.addLast(DQ[0].removeFirst());
                    } else {
                        DQ[0].removeFirst();
                    }
                }
                DQ[0] = New;
            }
        }

        find_Answer();
    }

    static void find_Answer() {
        System.out.println(Now_Page);
        if (DQ[0].isEmpty()) {
            System.out.println("-1");
        } else {
            while (!DQ[0].isEmpty()) {
                System.out.print(DQ[0].removeLast() + " ");
            }
            System.out.println();
        }
        if (DQ[1].isEmpty()) {
            System.out.println("-1");
        } else {
            while (!DQ[1].isEmpty()) {
                System.out.print(DQ[1].removeFirst() + " ");
            }
            System.out.println();
        }
    }
}
