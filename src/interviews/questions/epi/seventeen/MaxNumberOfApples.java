package interviews.questions.epi.seventeen;

import base.InterviewQuestion;

public class MaxNumberOfApples implements InterviewQuestion {
    @Override
    public void evaluate() {
        int[][] appleGrid = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                appleGrid[i][j] = j + 1;
            }
        }

        System.out.println(getMaxNumberOfApples(appleGrid));
    }

    private int getMaxNumberOfApples(int[][] appleGrid) {
        int numRows = appleGrid.length;
        int numColumns = appleGrid[0].length;

        int[][] applesCollected = new int[numRows][numColumns];
        int max_value = 0;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                int rowToCompare = Math.max(0, i - 1);
                int columnToCompare = Math.max(0, j - 1);
                applesCollected[i][j] = Math.max(applesCollected[rowToCompare][j], applesCollected[i][columnToCompare]) + appleGrid[i][j];
                max_value = Math.max(max_value, applesCollected[i][j]);
            }
        }

        return max_value;
    }
}
