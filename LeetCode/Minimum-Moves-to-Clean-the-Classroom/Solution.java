1class Solution {
2    static final int[] dx = { 0, 1, 0, -1 };
3    static final int[] dy = { 1, 0, -1, 0 };
4    public int minMoves(String[] classroom, int energy) {
5        int m = classroom.length;
6        int n = classroom[0].length();
7        int[][] id = new int[m][n];
8        int sx = 0,
9            sy = 0,
10            cnt = 0;
11        for (int i = 0; i < m; i++) {
12            for (int j = 0; j < n; j++) {
13                char c = classroom[i].charAt(j);
14                if (c == 'S') {
15                    sx = i;
16                    sy = j;
17                } else if (c == 'L') {
18                    id[i][j] = 1 << cnt;
19                    cnt++;
20                }
21            }
22        }
23        int full = 1 << cnt;
24        int[][][] bestEnergy = new int[m][n][full];
25        for (int i = 0; i < m; i++) {
26            for (int j = 0; j < n; j++) {
27                Arrays.fill(bestEnergy[i][j], -1);
28            }
29        }
30
31        bestEnergy[sx][sy][0] = energy;
32
33        class Info {
34
35            int x, y, mask, e, steps;
36
37            Info(int x, int y, int mask, int e, int steps) {
38                this.x = x;
39                this.y = y;
40                this.mask = mask;
41                this.e = e;
42                this.steps = steps;
43            }
44        }
45        Deque<Info> q = new ArrayDeque<>();
46        q.addLast(new Info(sx, sy, 0, energy, 0));
47        while (!q.isEmpty()) {
48            Info t = q.removeFirst();
49            if (t.mask == full - 1) {
50                return t.steps;
51            }
52            if (t.e == 0) {
53                continue;
54            }
55            for (int d = 0; d < 4; d++) {
56                int nx = t.x + dx[d];
57                int ny = t.y + dy[d];
58                if (
59                    nx < 0 ||
60                    nx >= m ||
61                    ny < 0 ||
62                    ny >= n ||
63                    classroom[nx].charAt(ny) == 'X'
64                ) {
65                    continue;
66                }
67                int ne = classroom[nx].charAt(ny) == 'R' ? energy : t.e - 1;
68                int nmask = t.mask | id[nx][ny];
69                if (ne > bestEnergy[nx][ny][nmask]) {
70                    bestEnergy[nx][ny][nmask] = ne;
71                    q.addLast(new Info(nx, ny, nmask, ne, t.steps + 1));
72                }
73            }
74        }
75        return -1;
76    }
77}