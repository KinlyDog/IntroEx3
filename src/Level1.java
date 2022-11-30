public class Level1 {
    public static int ConquestCampaign(int n, int m, int l, int[] battalion) {
        int battlefieldDay = 1;

        if (n * m == l) return battlefieldDay;

        int[][] battle = new int[n][m];
        for (int i = 0; i < l * 2 - 1; i += 2) {
            int x = battalion[i] - 1;
            int y = battalion[i + 1] - 1;

            battle[x][y] = battlefieldDay;
        }

        boolean battleIsOver = true;
        int battlefieldWidth = battle.length;
        int battlefieldLength = battle[0].length;

        while (battleIsOver) {
            battleIsOver = false;
            battlefieldDay++;

            for (int i = 0; i < battlefieldWidth; i++) {
                for (int j = 0; j < battlefieldLength; j++) {
                    if (battle[i][j] == battlefieldDay - 1) {
                        if (i > 0 && battle[i - 1][j] == 0) battle[i - 1][j] = battlefieldDay;
                        if (j > 0 && battle[i][j - 1] == 0) battle[i][j - 1] = battlefieldDay;
                        if (j < battlefieldLength - 1 && battle[i][j + 1] == 0) battle[i][j + 1] = battlefieldDay;
                        if (i < battlefieldWidth - 1 && battle[i + 1][j] == 0) battle[i + 1][j] = battlefieldDay;
                    }
                }
            }

            for (int i = 0; i < battlefieldWidth; i++) {
                for (int j = 0; j < battlefieldLength; j++) {
                    if (battle[i][j] == 0) battleIsOver = true;
                }
            }
        }

        return battlefieldDay;
    }
}
