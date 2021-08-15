import java.util.*;

public class StackProb3NGETRalternative {

    public static void main(String[] args) {

        int a[] = { 2, 5, 9, 3, 1, 12, 6, 8, 7 };
        int nge[] = solve(a);
        System.out.println();
        for (int item : nge) {
            System.out.print(item + " ");   
            
        }
        System.out.println();

    }
    
    public static int[] solve(int[] arr) {

        int nge[] = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        
        st.push(0); // putting the index only
        // trivial case

        for (int i = 1; i < arr.length; i++) {
            while (st.size() > 0 && arr[i] > arr[st.peek()]) {
                int pos = st.peek();
                nge[pos] = arr[i];
                st.pop();
            }
            st.push(i);
        }

        while (st.size() > 0) {
            int pos = st.peek();
            nge[pos] = -1;
            st.pop();
        }

        return nge;
    }

}
