package vol10;

import java.util.Scanner;

public class P1078
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		while (true)
		{
			String s = sc.nextLine();
			if (s.equals("#")) break;

			String[] cs = s.split("\\|");
			boolean sat = false;
			for (String c : cs)
			{
				if (isSat(c))
				{
					sat = true;
					break;
				}
			}
			System.out.println(sat ? "yes" : "no");
		}
	}

	static boolean isSat(String c)
	{
		String[] ls = c.substring(1, c.length() - 1).split("&");
		return !isContradist(ls[0], ls[1]) && !isContradist(ls[1], ls[2]) && !isContradist(ls[0], ls[2]);
	}

	static boolean isContradist(String l1, String l2)
	{
		int v1 = l1.charAt(l1.length() - 1);
		if (l1.charAt(0) == '~') v1 = -v1;
		int v2 = l2.charAt(l2.length() - 1);
		if (l2.charAt(0) == '~') v2 = -v2;
		return v1 + v2 == 0;
	}
}
/*
(B&B&f)|(~d&~i&i)|(~v&i&~V)|(~g&~e&o)|(~f&d&~v)|(d&~i&o)|(g&i&~B)|(~i&f&d)|(e&~i&~V)|(~v&f&~d)
(S&X&~X)
#
*/
