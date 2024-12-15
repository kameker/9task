package ru.vsu.cs.course1;

import java.util.List;

public class ninth {
    public static int process(List<Integer> list) {
        int count = 0;
        int countMin = list.size() + 1;
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if ((list.get(j) - list.get(i)) % (j - i) != 0) continue;
                int r = (list.get(j) - list.get(i)) / (j - i);
                for (int m = 0; m < list.size(); m++) {
                    if (!(list.get(m) == list.get(i) - i * r + m * r)) {
                        count++;
                    }
                }
                if (count < countMin) countMin = count;
                count = 0;
            }
        }
        return countMin;
    }
}
