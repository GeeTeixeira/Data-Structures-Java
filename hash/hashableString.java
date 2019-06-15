package hashTable;

public class hashableString{ 
  public static int hashString(String s){
		int hash = 13;
		for (int i = 0; i < s.length(); ++i) {
			int c = s.charAt(i);
			hash = hash * 13 + c;
		}
		return hash;
	}
}
