import java.util.*;

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int originalColor = image[sr][sc];

        if (originalColor == color) {
            return image;
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});

        image[sr][sc] = color;

        int[] row = {-1, 1, 0, 0};
        int[] col = {0, 0, -1, 1};

        while (!q.isEmpty()) {

            int[] current = q.poll();

            int r = current[0];
            int c = current[1];

            for (int i = 0; i < 4; i++) {

                int nr = r + row[i];
                int nc = c + col[i];

                if (nr >= 0 && nc >= 0 &&
                    nr < image.length && nc < image[0].length &&
                    image[nr][nc] == originalColor) {

                    image[nr][nc] = color;
                    q.add(new int[]{nr, nc});
                }
            }
        }

        return image;
    }
}