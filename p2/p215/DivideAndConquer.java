package leetcode.p2.p215;

import java.util.Random;

/**
 * @author Chongjian Tang
 * This is my previous java homework code about how to find the Kth largest element in an array.
 */
public class DivideAndConquer {
    static element data = new element();

    public static void main(String[] args) {
        autoGetTestSet(18);

        element median = getWeightedMedian(data, 0.5);

        // 排序并打印所有元素与其权重
        element temp = data;
        temp.next = sorting(temp.next);
        double SUM;
        SUM = 0;
        while (temp.next != null) {
            temp = temp.next;
            SUM = SUM + temp.weight;
            System.out.printf("%d\t%.5f\n", temp.num, SUM);
        }


        System.out.printf("加权中位数元素: %d\n中位数权重: %.5f\n", median.num, median.weight);

        test(median);
    }


    static element getWeightedMedian(element set, double splitPoint) {
        element pointerToSet = set;
        element pivot = getMedian(set);

        element bigSet = new element();
        element pointerToBigSet = bigSet;
        element smallSet = new element();
        element pointerToSmallSet = smallSet;

        while (pointerToSet.next != null) {
            pointerToSet = pointerToSet.next;
            if (pointerToSet.num == pivot.num) {
                continue;
            }
            if (pointerToSet.num > pivot.num) {
                bigSet.num++;
                bigSet.weight += pointerToSet.weight;
                pointerToBigSet.next = new element(pointerToSet.num, pointerToSet.weight);
                pointerToBigSet = pointerToBigSet.next;
            } else {
                smallSet.num++;
                smallSet.weight += pointerToSet.weight;
                pointerToSmallSet.next = new element(pointerToSet.num, pointerToSet.weight);
                pointerToSmallSet = pointerToSmallSet.next;
            }
        }
        // 递归部分
        if (smallSet.weight <= splitPoint && bigSet.weight <= set.weight - splitPoint) {
            return pivot;
        } else if (smallSet.weight > splitPoint) {
            return getWeightedMedian(smallSet, splitPoint);
        } else {
            return getWeightedMedian(bigSet, splitPoint - smallSet.weight - pivot.weight);
        }
    }

    static element getMedian(element set) {
        if (set.num == 1) {
            return set.next;
        }
        int totalNumOnFive = (int) Math.ceil(set.num / 5.0);
        element[] partition = new element[totalNumOnFive];
        element p2partition;
        double weightSum = 0;
        element temp = set.next;
        for (int i = 0; i < totalNumOnFive; i++) {
            partition[i] = new element();
            p2partition = partition[i];

            // 把五个元素新生成新的list
            for (int j = 0; j < 5 && temp != null; j++) {
                p2partition.next = new element(temp.num, temp.weight);
                p2partition = p2partition.next;
                temp = temp.next;
            }

            partition[i] = partition[i].next;
        }

        for (int i = 0; i < totalNumOnFive; i++) {
            partition[i] = directlyGetMedian(partition[i]);
            weightSum += partition[i].weight;
        }
        element medianList = new element(totalNumOnFive, weightSum);
        element head = medianList;
        for (int j = 0; j < totalNumOnFive; j++) {
            medianList.next = new element(partition[j].num, partition[j].weight);
            medianList = medianList.next;
        }
        return getMedian(head);
    }

    /**
     * 生成随机测试集
     */
    static void autoGetTestSet(int n) {
        Random rand = new Random();
        int sum = 0;
        element temp;
        temp = data;
        temp.num = n;
        temp.weight = 0;
        int randNum;
        for (int i = 0; i < n; i++) {
            temp.next = new element();
            temp = temp.next;
            randNum = rand.nextInt(5 * n);
            // 确保元素互不相同
            while (isExist(randNum)) {
                randNum = rand.nextInt(5 * n);
            }
            temp.num = randNum;
            temp.weight = rand.nextInt(10 * n - 1) + 1;
            sum += temp.weight;
        }
        temp = data.next;
        while (temp != null) {
            temp.weight /= sum;
            temp = temp.next;
        }
        data.weight = 1.0;
    }

    static boolean isExist(int num) {
        element set = data;
        while (set.next != null) {
            set = set.next;
            if (set.num == num) {
                return true;
            }
        }
        return false;
    }

    /**
     * 对list按元素大小进行排序
     */
    static element sorting(element set) {
        element newSet = new element(set.num, set.weight);
        element temp;
        while (set.next != null) {
            set = set.next;
            temp = newSet;
            if (set.num < temp.num) {
                element insert = new element(set.num, set.weight);
                insert.next = temp;
                newSet = insert;
            } else {
                while (set.num > temp.num) {
                    if (temp.next == null) {
                        temp.next = new element(set.num, set.weight);
                        break;
                    } else if (set.num < temp.next.num) {
                        element insert = new element(set.num, set.weight);
                        insert.next = temp.next;
                        temp.next = insert;
                        break;
                    } else {
                        temp = temp.next;
                    }
                }
            }
        }
        return newSet;
    }

    /**
     * 在问题较小时，直接求解中位数
     */
    static element directlyGetMedian(element set) {
        set = sorting(set);
        element temp = set;
        int counter = 0;
        while (temp != null) {
            temp = temp.next;
            counter++;
        }
        temp = set;
        counter = (counter - 1) / 2;
        while (counter != 0) {
            temp = temp.next;
            counter--;
        }
        return temp;
    }

    /**
     * 测试函数，输出相关信息
     */
    static void test(element median) {
        double bigSum = 0;
        double smallSum = 0;
        element temp = data;
        while (temp.next != null) {
            temp = temp.next;
            if (temp.num == median.num) {
                continue;
            }
            if (temp.num > median.num) {
                bigSum += temp.weight;
            } else {
                smallSum += temp.weight;
            }
        }
        System.out.printf("小于中位数的权重和为: %.5f\n大于中位数的权重和为: %.5f", smallSum, bigSum);
    }
}


/**
 * 定义的list数据结构，存放了元素和其权重，list的表头（第一个element）存的是权重和与该链表的长度
 */
class element {
    int num;
    double weight;
    element next;

    element() {
        num = 0;
        weight = 0.0;
    }

    element(int num, double weight) {
        this.num = num;
        this.weight = weight;
    }
}

