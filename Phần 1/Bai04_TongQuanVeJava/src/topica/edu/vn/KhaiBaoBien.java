package topica.edu.vn;

public class KhaiBaoBien {
	public static void main(String[] args) {
		int x,y;
		
		// sysou + Ctrl + Space
		System.out.println("Min của Int = "+Integer.MIN_VALUE);
		System.out.println("Max của int = "+Integer.MAX_VALUE);
		
		/*	Toán tử 1 ngôi
		 *  Postfix và prefix
		 *  Postfix (hậu tố): ++ hoặc -- nằm đằng sau biến
		 *  Prefix (tiền tố): ++ hoặc -- nằm đằng trước biến
		 */
		
		/*	int x=5, y=7;
		 * 	int z = x++ + ++y - 8;
		 * 
		 * Quy tắc để hiểu các biểu thức phức tạp này
		 * Bước 1: Ưu tiên xử lý cho prefix trước
		 * Bước 2: Xử lý các phép toán còn lại
		 * Bước 3: Gán giá trị cho vế trái dấu bằng trước
		 * Bước 4: Sau đó mới làm postfix
		 * 
		 * z = x++ + ++y - 8;
		 * Bước 1: ++y làm trước -> y=8
		 * Bước 2: 5+8-8 = 5
		 * Bước 3: z=5
		 * Bước 4: x++ -> x=6
		 * Kết quả cuỗi cùng là: x=6, y=8, z=5
		 */
	}
}

