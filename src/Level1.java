public class Level1 {
    public static int ConquestCampaign(int n, int m, int l, int[] battalion) {
        int day = 1;
        int x;
        int y;
        boolean flag = true;

        int[][] battle = new int[n][m];
        int xlen = battle.length - 1;
        int ylen = battle[0].length - 1;

        // Start point, day 1
        for (int i = 0; i < l * 2 - 1; i += 2) {
            x = battalion[i] - 1;
            y = battalion[i + 1] - 1;

            battle[x][y] = 1;
        }

        while (flag) {
            flag = false;
            day++;
            int dayz = day - 1;

            for (int i = 0; i < battle.length; i++) {
                for (int j = 0; j < battle[i].length; j++) {
                    if (battle[i][j] == dayz) {
                        if (i > 0 && battle[i - 1][j] == 0)    battle[i - 1][j] = day;
                        if (j > 0 && battle[i][j - 1] == 0)    battle[i][j - 1] = day;
                        if (j < ylen && battle[i][j + 1] == 0) battle[i][j + 1] = day;
                        if (i < xlen && battle[i + 1][j] == 0) battle[i + 1][j] = day;
                    }
                }
            }

            for (int i = 0; i < battle.length; i++) {
                for (int j = 0; j < battle[0].length; j++) {
                    if (battle[i][j] == 0) flag = true;
                }
            }

        }

        return day;
    }

    public static void main(String[] args) {
        int[] ar = new int[] {2, 2, 3, 4};

        System.out.println(ConquestCampaign(3, 4, 2, ar));
    }
}