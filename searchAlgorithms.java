package searchAlgorithms;
import linkedList.*;
public class searchAlgorithms<T extends Comparable<T>> {
	
	/**
	 * Sequentially searches for a target in an array type of T
	 * @param target
	 * @param array
	 * @return
	 */
	public boolean arraySequentialSearch(T target, T[] array) {
		for(int i = 0;i<array.length;i++) {
			if(target.equals(array[i])) return true;
		}
		return false;
	}
	/**
	 * Sequentially searches for a target in a linked list 
	 * @param target
	 * @param nodeList
	 * @return
	 */
	public boolean linkedListSequentialSearch(T target, linkedList nodeList) {
		for(;nodeList != null;nodeList = nodeList.getNext()) {
			if(target.equals(nodeList.getData())) return true;
		}
		return false;
	}
	/**
	 * Use binary search on an array iteratively
	 * @param target
	 * @param array
	 * @return
	 */
	public boolean arrayBinarySearch(T target,T[] array) {
		for(int l = 0, r = array.length-1, mid = 0;l<=r;) {
			mid = (l+r)/2;
			if(target.compareTo(array[mid]) == 0) return true;
			if(target.compareTo(array[mid]) < 0) r = mid-1;
			if(target.compareTo(array[mid]) > 0) l = mid+1;
		}
		return false;
	}
	/**
	 * Recursive binary search currently not working
	 * @param target
	 * @param array
	 * @param l
	 * @param r
	 * @return boolean
	 */
	public boolean arrayBinaryRecursive(T target, T[] array,int l, int r) {
		int mid = (l+r)/2;
		if(target.equals(array[mid])) return true;
		if(l>=r) return false;
		if(target.compareTo(array[mid]) < 0) arrayBinaryRecursive(target,array,l,mid-1);
		if(target.compareTo(array[mid]) > 0) arrayBinaryRecursive(target,array,mid+1,r);
		return false;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr = {"A","AB","ABC","ABCD","ABCDE","ABCDEF"};
		searchAlgorithms search = new searchAlgorithms();
		System.out.println(search.arrayBinaryRecursive("ABCD",arr,0,arr.length-1));

	}

}
