/**
 * Created by YuebinYang on 2017/3/27.
 */
public class _134GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        if (gas == null || cost == null || gas.length ==0 || cost.length == 0 ) return -1;
        int negative = 0;
        int sum  = 0;
        int res = 0;
        for (int i = 0; i < gas.length; i++){
            sum += gas[i] - cost[i];
            if (sum < 0){
                negative += sum;
                sum = 0;
                res = i + 1;
            }
        }
        return negative + sum >= 0 ? res : -1;
    }
    
    public static void main(String[] args){
        _134GasStation A =new _134GasStation();
        int []gas = {6,3,7,2};
        int []cost = {7,4,3,4};
        System.out.println(A.canCompleteCircuit(gas, cost));
    }
}

//question:
    //There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
    //
    //        You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
    //
    //        Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
    //
    //        Note:
    //        The solution is guaranteed to be unique.