class Delivery {
    int over;
    int ball;

    Delivery(int over, int ball) {
        this.over = over;
        this.ball = ball;
    }

    public String toString() {
        return "(" + over + "," + ball + ")";
    }
}

public class CricketCountingSort {

    static void countingSortBall(Delivery arr[]) {
        int max = 6;

        int count[] = new int[max + 1];
        Delivery output[] = new Delivery[arr.length];

        for (Delivery d : arr)
            count[d.ball]++;

        for (int i = 1; i <= max; i++)
            count[i] += count[i - 1];

        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i].ball] - 1] = arr[i];
            count[arr[i].ball]--;
        }

        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    static void countingSortOver(Delivery arr[]) {
        int max = 3;

        int count[] = new int[max + 1];
        Delivery output[] = new Delivery[arr.length];

        for (Delivery d : arr)
            count[d.over]++;

        for (int i = 1; i <= max; i++)
            count[i] += count[i - 1];

        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i].over] - 1] = arr[i];
            count[arr[i].over]--;
        }

        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    public static void main(String[] args) {

        Delivery arr[] = {
            new Delivery(2,4),
            new Delivery(1,1),
            new Delivery(3,6),
            new Delivery(1,5),
            new Delivery(2,2),
            new Delivery(3,1),
            new Delivery(1,3),
            new Delivery(2,6),
            new Delivery(3,4),
            new Delivery(1,2)
        };

        System.out.println("Unsorted Deliveries:");
        for (Delivery d : arr)
            System.out.print(d + " ");

        countingSortBall(arr);
        countingSortOver(arr);

        System.out.println("\n\nSorted Deliveries:");
        for (Delivery d : arr)
            System.out.print(d + " ");
    }
}