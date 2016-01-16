package huawei;


import java.util.Set;
import java.util.TreeSet;

public final class Demo {
    /*****************************************************************************
     * Description : ʵ���������򣬼��Ƚ���A��������������н��������޳��ظ�������������õ�����������B��
     * Input       : array_A                 ����������������������������A
     * Return      : ����������������
     *****************************************************************************/
    public static int[] sort(int[] arr) {
        if (arr == null || arr.length < 1) {
            return null;
        }

        Set<Integer> set = new TreeSet<Integer>();
        for (int i : arr) {
            set.add(i);
        }

        int[] rs = new int[set.size()];
        int i = 0;
        for (int v : set) {
            rs[i] = v;
            i++;
        }

        return rs;
    }


}


