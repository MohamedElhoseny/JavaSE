package Problem_Solving;

public class Largest_sum_SubArray
{

    //Using Kadane's Algorithm

    private static int getLargestSum(int arr[])
    {
        int maxCurrent = arr[0], maxGlobal = arr[0];

        for (int i = 1; i < arr.length - 1; i++)
        {
            maxCurrent = Math.max(arr[i], maxCurrent + arr[i]);

            if (maxCurrent > maxGlobal)
                maxGlobal = maxCurrent;
        }

        return maxGlobal;
    }


    public static void main(String[] args)
    {
        int arr[] = {1, -3, 2, 1, -1};

        System.out.println(getLargestSum(arr));
    }
}
