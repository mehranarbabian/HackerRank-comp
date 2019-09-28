package Non_Divisible_Subset;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Non_Divisible_Subset {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int k=scanner.nextInt();
        int [] input_set=new int[n];
        List<Integer> subset=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        for (int i=0;i<n;++i)
            input_set[i]=scanner.nextInt();

temp.add(input_set[0]);
        for (int a=0;a<get_size_of_temp(temp);++a) {
            subset.add(temp.get(0));
            temp.remove(0);
            for (int i = 1; i < input_set.length; ++i) {
                int counter = 0;
                for (int j = 0; j < get_size_of_subset(subset); ++j)
                    if ((input_set[i] + subset.get(j)) % k != 0 && input_set[i] != subset.get(j))
                        ++counter;

                if (counter == get_size_of_subset(subset))
                    subset.add(input_set[i]);
                else temp.add(input_set[i]);
            }
        }
        System.out.println(subset.size());

    }
    public static int get_size_of_subset(List<Integer> subset)
    {
        return subset.size();
    }
    public static int get_size_of_temp(List<Integer> temp)
    {
        return temp.size();
    }
}
