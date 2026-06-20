class SegmentTree {
    int[] tree;
    int n;

    SegmentTree(int[] arr) {
        n = arr.length;
        tree = new int[4 * n];
        build(arr, 0, 0, n - 1);
    }

    void build(int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;

            build(arr, 2 * node + 1, start, mid);
            build(arr, 2 * node + 2, mid + 1, end);

            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }

    int query(int node, int start, int end, int l, int r) {

        if (r < start || end < l)
            return 0;

        if (l <= start && end <= r)
            return tree[node];

        int mid = (start + end) / 2;

        return query(2 * node + 1, start, mid, l, r)
                + query(2 * node + 2, mid + 1, end, l, r);
    }

    void update(int node, int start, int end, int idx, int value) {

        if (start == end) {
            tree[node] = value;
            return;
        }

        int mid = (start + end) / 2;

        if (idx <= mid)
            update(2 * node + 1, start, mid, idx, value);
        else
            update(2 * node + 2, mid + 1, end, idx, value);

        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }
}

public class SmartEnergySegmentTree {

    public static void main(String[] args) {

        int[] usage = {18, 5, 14, 9, 7, 11, 6, 10};

        SegmentTree st = new SegmentTree(usage);

        int q1 = st.query(0, 0, 7, 1, 5);
        System.out.println("Q1: sum(1,5) = " + q1);

        int q2 = st.query(0, 0, 7, 0, 7);
        System.out.println("Q2: sum(0,7) = " + q2);

        st.update(0, 0, 7, 2, 20);

        System.out.println("Updated index 2 from 14 to 20");

        int q3 = st.query(0, 0, 7, 1, 5);
        System.out.println("Q3: sum(1,5) = " + q3);
    }
}