
public class _168ExcelSheetColumnTitle {

	public String convertToTitle(int n) {
		
        StringBuilder res = new StringBuilder();
        while (n != 0){
        	n--;
        	res.insert(0, (char)('A' + n % 26 ));
        	n /= 26;
        }
        return res.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 78;
		_168ExcelSheetColumnTitle A =new _168ExcelSheetColumnTitle();
		System.out.println(A.convertToTitle(n));
	}

}
