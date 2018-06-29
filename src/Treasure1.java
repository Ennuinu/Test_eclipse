import java.util.Random;
import java.util.Scanner;

public class Treasure1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rnd = new Random();
		//配置物を決める(宝を数値の1、罠を数値の２で表現する)
		final int TREASURE = 1;				//宝：TREASUREという別名をあてておく
		final int TRAP = 2;					//罠：TRAPという別名をあてておく

		//配列準備：配列名map、要素数1個
		int[] map = {5,10};				//配列名と保存するデータを同時に決定。要素数も決まる
		System.out.println("0: 小さいマップ 1: 大きいマップ");
		System.out.print("マップを選んでください");
		int mapNum = sc.nextInt();		//配列の名前と要素数の決定
		//配列準備：配列名area、要素数はmap[0]の値（この例では5）を使う
		int[] area = new int[map[mapNum]];			//配列の名前と要素数の決定
		//宝物を埋める位置を決定する
		int num1 = rnd.nextInt(5);
		int num2 = rnd.nextInt(5);
		int num3 = rnd.nextInt(5);
		area[num1] = TRAP;						//罠を設置
		area[num2] = TRAP;
		area[num3] = TREASURE;					//宝を設置
		int searchPos = -1;						//探索初期位置
		boolean findFlag = false;				//宝物を見つけたかどうかの判定用

		//宝物が見つかるまで繰り返す
		while(!findFlag) {
			System.out.println("探索可能範囲(0～" + (area.length -1) + ")");
			System.out.print("探すエリア番号を入力してください>");
			searchPos = sc.nextInt();			//探索エリア番号の入力

			//探索したエリア番号に宝物があるかチェック
			if(area[searchPos] == TREASURE) {
				System.out.println("宝物を発見！");
				findFlag = true;
			} else if(area[searchPos] == TRAP)  {
				System.out.println("罠に掛かった！");
				sc.close();
			} else {
				System.out.println("何も見つかりませんでした。\n");
			}
		}
		sc.close();								//入力ストリームを閉じる
	}

}
