package Non_Divisible_Subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Non_Divisible_Subset {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int k=scanner.nextInt();
        int [] input_set=new int[n];
        List<Integer> list_of_numbers_for_start_creating_subset=new ArrayList<>();
        List<Integer> list_of_results=new ArrayList<>();

        for (int i=0;i<n;++i)
            input_set[i]=scanner.nextInt();

list_of_numbers_for_start_creating_subset.add(input_set[0]);
        for (int a = 0; a<3; ++a) {
            List<Integer> subset=new ArrayList<>();
            if (list_of_numbers_for_start_creating_subset.size()>0) {
                subset.add(list_of_numbers_for_start_creating_subset.get(0));
                list_of_numbers_for_start_creating_subset.remove(0);
            }
            for (int i = 1; i < input_set.length; ++i) {
                int counter = 0;
                for (int j = 0; j < get_size_of_input(subset); ++j)
                    if ((input_set[i] + subset.get(j)) % k != 0 && input_set[i] != subset.get(j))
                        ++counter;

                if (counter == get_size_of_input(subset))
                    subset.add(input_set[i]);
                else list_of_numbers_for_start_creating_subset.add(input_set[i]);
            }
list_of_results.add(subset.size());
        }

        int max=list_of_results.get(0);
        if (list_of_results.size()>1)
            for (Integer list_of_result : list_of_results) {
                if (list_of_result>max)
                    max=list_of_result;

            }
        System.out.println(max);
    }
    public static int get_size_of_input(List<Integer> input)
    {
        return input.size();
    }

}
