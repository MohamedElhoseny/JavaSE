package Problem_Solving;

import java.util.ArrayList;

public class printRepeating
{
    private static Object[] getRepeating(int[] arr) //O(n2)
    {
        ArrayList<Integer> repeated = new ArrayList<>();

        for (int i = 0; i < arr.length; i++)
        {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j])
                    repeated.add(arr[i]);
            }
        }
        return repeated.toArray();
    }

    private static void printRepeating(int arr[])   //O(n)
    {
        int count[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {

            if (count[arr[i]] == 1)
                System.out.println(arr[i]);
            else
                count[arr[i]]++;
        }
    }

    public static void main(String[] args)
    {
        int arr[] = {1,5,3,6,4,1,5,2};

        printRepeating(arr);

        Object[] repeated = getRepeating(arr);
        for (Object obj: repeated) {
            System.out.println((int)obj);
        }
    }
}
