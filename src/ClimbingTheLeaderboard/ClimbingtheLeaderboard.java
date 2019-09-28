package ClimbingTheLeaderboard;

import java.util.Scanner;

public class ClimbingtheLeaderboard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] otherPlayerScore = new int[n];
        for (int i = 0; i < otherPlayerScore.length; ++i)
            otherPlayerScore[i] = scanner.nextInt();
        int m = scanner.nextInt();
        int[] aliceScores = new int[m];
        for (int i = 0; i < aliceScores.length; ++i) {

            aliceScores[i] = scanner.nextInt();


        }
        int []denseRanks=createDenseRank(otherPlayerScore);
        for (int i = 0; i < aliceScores.length; ++i) {
            int aliceIndexScore = findAliceIndexScoreByBinarySearch(otherPlayerScore, aliceScores[i], 0, otherPlayerScore.length - 1);
findAliceRank(denseRanks,aliceIndexScore);
        }


    }
static int findAliceIndexScoreByBinarySearch(int []otherPlayerScore,int aliceScore,int left,int right)
{


    int mid=(left+right)/2;
    int aliceIndex=mid;
if (mid>=0 && Math.abs(left-right)>1) {
if (otherPlayerScore[mid] <aliceScore && otherPlayerScore[mid-1]>aliceScore)
    return mid;
     else if (otherPlayerScore[mid] > aliceScore)
     return findAliceIndexScoreByBinarySearch(otherPlayerScore, aliceScore, mid+1 , right);
    else if (otherPlayerScore[mid] < aliceScore)
        return findAliceIndexScoreByBinarySearch(otherPlayerScore, aliceScore, left, mid-1 );
}


if (otherPlayerScore[aliceIndex]>aliceScore)
    ++aliceIndex;

return aliceIndex;
}
static int[] createDenseRank(int []otherPlayerScore)
{
    int rank=1;
    int []denseRanks=new int[otherPlayerScore.length];
    denseRanks[0]=rank;
    for (int i=0;i<otherPlayerScore.length-1;++i)
    {
        if (otherPlayerScore[i]>otherPlayerScore[i+1])
            denseRanks[i+1]=++rank;
        else
            denseRanks[i+1]=rank;
    }
    return denseRanks;
}
static void findAliceRank(int []densRank,int aliceIndex)
{
    if (aliceIndex>densRank.length-1) {
        System.out.println(densRank[densRank.length - 1] + 1);
    }
    else if (aliceIndex==0)
        System.out.println(1);
   else if (densRank[aliceIndex]==densRank[aliceIndex-1])
        System.out.println(densRank[aliceIndex-1]);
    else
        System.out.println(densRank[aliceIndex]);

}
}





