public class Level1 {
    public static int ConquestCampaign(int n, int m, int l, int[] battalion) {
        int day = 1;

        if (n * m == l) return day;

        int[][] battle = new int[n][m];
        for (int i = 0; i < l * 2 - 1; i += 2) {
            int x = battalion[i] - 1;
            int y = battalion[i + 1] - 1;

            battle[x][y] = day;
        }


        boolean flag = true;
        int xlen = battle.length;
        int ylen = battle[0].length;

        while (flag) {
            flag = false;
            day++;

            for (int i = 0; i < xlen; i++) {
                for (int j = 0; j < ylen; j++) {
                    if (battle[i][j] == day - 1) {
                        if (i > 0        && battle[i - 1][j] == 0) battle[i - 1][j] = day;
                        if (j > 0        && battle[i][j - 1] == 0) battle[i][j - 1] = day;
                        if (j < ylen - 1 && battle[i][j + 1] == 0) battle[i][j + 1] = day;
                        if (i < xlen - 1 && battle[i + 1][j] == 0) battle[i + 1][j] = day;
                    }
                }
            }

            for (int i = 0; i < xlen; i++) {
                for (int j = 0; j < ylen; j++) {
                    if (battle[i][j] == 0) flag = true;
                }
            }
        }

        return day;
    }
}
