/**
 *
 */
package jp.rey1229.verification;

import java.time.chrono.JapaneseChronology;
import java.time.chrono.JapaneseDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * 西暦から和暦変換テスト
 * (JavaSE8)
 * @author rey1229
 *
 */
public class AdCalToJPCal {

	/**
	 * 西暦から和暦変換テスト
	 * (JavaSE8)
	 * @param args コマンドライン引数
	 */
	public static void main(String[] args) {
		List<int[]> adList = new ArrayList<int[]>();
		// CHECKSTYLE:OFF
		//グレゴリウス暦導入前
		adList.add(new int[]{1868, 1, 1});
		adList.add(new int[]{1868, 1, 1});
		adList.add(new int[]{1868, 1, 25});
		adList.add(new int[]{1868, 10, 22});
		adList.add(new int[]{1868, 10, 23});
		adList.add(new int[]{1872, 12, 31});
		//グレゴリウス暦導入
		adList.add(new int[]{1873, 1, 1});
		//明治→大正
		adList.add(new int[]{1912, 1, 1});
		adList.add(new int[]{1912, 7, 29});
		adList.add(new int[]{1912, 7, 30});
		//大正→昭和
		adList.add(new int[]{1926, 1, 1});
		adList.add(new int[]{1926, 12, 24});
		adList.add(new int[]{1926, 12, 25});
		//昭和→平成
		adList.add(new int[]{1989, 1, 1});
		adList.add(new int[]{1989, 1, 7});
		adList.add(new int[]{1989, 1, 8});
		// CHECKSTYLE:ON


		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("Gy年M月d日")
		        .withChronology(JapaneseChronology.INSTANCE);
		for (int[] iArr : adList) {
			try {
				JapaneseDate jd = JapaneseDate.of(iArr[0], iArr[1], iArr[2]);
				System.out.println("西暦" + iArr[0] + "年" + iArr[1] + "月" + iArr[2] + "日 → " + jd.format(formatter));
			} catch (RuntimeException re) {
				System.out.println("RuntimeException：西暦" + iArr[0] + "年" + iArr[1] + "月" + iArr[2] + "日  （" + re.toString() + ")");
			} catch (Exception e) {
				System.out.println("Exception：西暦" + iArr[0] + "年" + iArr[1] + "月" + iArr[2] + "日  （" + e.toString() + ")");
			}

		}

	}

}
