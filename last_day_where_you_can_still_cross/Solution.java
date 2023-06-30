package last_day_where_you_can_still_cross;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {
	public int latestDayToCross(int row, int col, int[][] cells) {
		UnionFind uf = new UnionFind(row * col + 2);
		int[][] grid = new int[row][col];

		int ret = -1;
		for (int i = cells.length - 1; i >= 0; i--) {
			int r = cells[i][0] - 1;
			int c = cells[i][1] - 1;
			grid[r][c] = 1;
			int index1 = r * col + c + 1;
			for (int[] diff : new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } }) {
				int newr = r + diff[0];
				int newc = c + diff[1];
				int index2 = newr * col + newc + 1;
				if (0 <= newr && newr < row && 0 <= newc && newc < col && grid[newr][newc] == 1) {
					uf.union(index1, index2);
				}
			}

			if (r == 0) {
				uf.union(0, index1);
			}
			if (r == row - 1) {
				uf.union(row * col + 1, index1);
			}
			if (uf.same(0, row * col + 1)) {
				ret = i;
				break;
			}
		}

		return ret;
	}

	public class UnionFind {
		private int[] parent;
		private int[] size;
		private int groupCount;

		public UnionFind(int n) {
			this.parent = IntStream.range(0, n).toArray();
			this.size = new int[n];
			Arrays.fill(this.size, 1);
			this.groupCount = n;
		}

		public int find(int x) {
			if (parent[x] == x) {
				return x;
			}
			parent[x] = find(parent[x]);
			return parent[x];
		}

		public boolean same(int x, int y) {
			return find(x) == find(y);
		}

		public void union(int x, int y) {
			x = find(x);
			y = find(y);
			if (x == y) {
				return;
			}

			groupCount--;

			if (size[x] < size[y]) {
				parent[x] = y;
				size[y] += size[x];
			} else {
				parent[y] = x;
				size[x] += size[y];
			}

		}

		public int size(int x) {
			return size[find(x)];
		}

		public int groupCount() {
			return groupCount;
		}
	}

}
