package vol11;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class P1174
{
	static int[] D = { 1, 0, -1, 0 };
	static int w, h, c;

	public static void main(String[] args)
	{
		try { System.setIn(new FileInputStream("inputs/1174.txt")); } catch (IOException e) { e.printStackTrace(); }

		Scanner sc = new Scanner(System.in);
		while (true)
		{
			h = sc.nextInt();
			w = sc.nextInt();
			c = sc.nextInt();
			if ((h|w|c)==0)break;

			int[] board = new int[w * h];
			for (int y = 0; y < h; y++)
			{
				for (int x = 0; x < w; x++)
				{
					board[y * w + x] = sc.nextInt();
				}
			}

			System.out.println(count(board, 5));
		}
	}

	static int count(int[] board, int t)
	{
		if (t == 0)
		{
			return countColor(board);
		}

		int max = 0;
		for (int i = 1; i <= 6; i++)
		{
			if (board[0] == i) continue;
			int[] cb = Arrays.copyOf(board, board.length);
			changeColor(cb, 0, 0, cb[0], i);
			max = Math.max(max, count(cb, t - 1));
		}
		return max;
	}

	static int countColor(int[] board)
	{
		return countColor(board, 0, 0);
	}

	static int countColor(int[] board, int x, int y)
	{
		int count = 0;
		if (0 <= x && x < w && 0 <= y && y < h && board[y * w + x] == c)
		{
			count++;
			board[y * w + x] = 0;
			for (int i = 0; i < 4; i++)
			{
				int x2 = x + D[i];
				int y2 = y + D[(i + 1) % 4];
				count += countColor(board, x2, y2);
			}
		}
		return count;
	}

	static void changeColor(int[] board, int x, int y, int c, int d)
	{
		if (0 <= x && x < w && 0 <= y && y < h && board[y * w + x] == c)
		{
			board[y * w + x] = d;
			for (int i = 0; i < 4; i++)
			{
				int x2 = x + D[i];
				int y2 = y + D[(i + 1) % 4];
				changeColor(board, x2, y2, c, d);
			}
		}
	}
}
