package CoinChange;

import java.util.Scanner;

public class Coins {

	public static void main(String[] args) {
		
		int size = 0, n = 0;
		int d[];
		
		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		n = scan.nextInt();
		size = scan.nextInt();
		d = new int[size];
		
		for(int i = 0; i < size; i++) {
			d[i] = scan2.nextInt();
		}
		
		Coin coinCls = new Coin();
		int res = coinCls.changes(d, n);
		System.out.println("거슬러 줄 화폐의 최소: " + res);

	}

}

class Coin {
	static final int INF = 100000;
	
	//d: 화폐 단위, n: 거스름돈 양, M: 거슬러준 화폐의 개수를 담는 배열
	public int changes(int d[], int n) {
		int M[] = new int[n + 1];
		M[0] = 0;
		
		for(int j = 1; j <= n; j++) {
			int minimum = INF;
			
			for(int i = 0; i < d.length; i++) {
				if(j >= d[i]) {
					minimum = Math.min(minimum, 1 + M[j - d[i]]);
				}
			}
			M[j] = minimum;
		}
		return M[n];
	}
}
