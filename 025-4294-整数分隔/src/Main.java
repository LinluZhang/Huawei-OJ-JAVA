import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Author: ������
 * Date: 2016-01-17 21:28
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Main {

    // ���ⷽ����ʹ������������Ǯ�ķ�����
    public static void main(String[] args) {

        //Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            int n = scanner.nextInt();


            System.out.println(intDivide(n));
        }

        scanner.close();
    }

    // �����м�����ֻ����һ�ξͿ���
    private static int[] INT_DIVIDE = new int[1000 * 1000 + 1];
    private static int intDivide(int n) {

        // ��Ŀ��Ҫ������ݷ�Χ
        if (n < 1 || n > 1000000) {
            return -1;
        }

        // ���в�����n��2����������
        List<Integer> list = new ArrayList<Integer>();
        int power2 = 1;

        do {
            list.add(power2);
            power2 <<= 1;
        } while (power2 <= n);


        return intDivide(n, list, list.size() - 1);
    }

    private static int intDivide(int n, List<Integer> list, int idx) {

        if (n == 1 || n == 0 || idx == 0) {
            return 1;
        }

        if (n < 0 || idx < 0) {
            return 0;
        }

        // ���֮ǰ�Ѿ�������˾Ͳ����ټ�����
        if (INT_DIVIDE[n] != 0) {
            return INT_DIVIDE[n];
        }

        int rs = intDivide(n - list.get(idx), list, idx) % 1000000000;
        rs = (rs + intDivide(n, list, idx - 1) % 1000000000) % 1000000000;

        // ������
        INT_DIVIDE[n] = rs;
        return rs;
    }


}
