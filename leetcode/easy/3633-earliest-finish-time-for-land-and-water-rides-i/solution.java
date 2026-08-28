class Solution {
    public int earliestFinishTime(
        int[] landStartTime,
        int[] landDuration,
        int[] waterStartTime,
        int[] waterDuration
    ) {

        int answer = Integer.MAX_VALUE;

        // Land ride first, then water ride
        for (int i = 0; i < landStartTime.length; i++) {

            int landFinish =
                landStartTime[i] + landDuration[i];

            for (int j = 0; j < waterStartTime.length; j++) {

                // Water can start after land finishes
                int waterStart =
                    Math.max(landFinish, waterStartTime[j]);

                int finish =
                    waterStart + waterDuration[j];

                answer = Math.min(answer, finish);
            }
        }

        // Water ride first, then land ride
        for (int i = 0; i < waterStartTime.length; i++) {

            int waterFinish =
                waterStartTime[i] + waterDuration[i];

            for (int j = 0; j < landStartTime.length; j++) {

                // Land can start after water finishes
                int landStart =
                    Math.max(waterFinish, landStartTime[j]);

                int finish =
                    landStart + landDuration[j];

                answer = Math.min(answer, finish);
            }
        }

        return answer;
    }
}