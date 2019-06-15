package hashTable;

public class hashTable<K,V> {
	static class Entry<K,V>{
		int hash;
		K key;
		V value;
		Entry<K,V> next;
	}
	static final int MAXIMUM_CAPACITY = 1<<30;
	static final int DEFAULT_CAPACITY = 16;
	static float DEFAULT_THRESHOLD = 0.75f;
	
	Entry<K,V>[] table;
	int size;
	float threshold;
	
	static int getCapacity(int cap) {
		int n = cap-1;
		n |= n>>>1;
		n |= n >>> 2;
		n |= n >>> 4;
		n |= n >>> 8;
		n |= n >>> 16;
		return n < 0 ? 1 : n > MAXIMUM_CAPACITY ? MAXIMUM_CAPACITY: n + 1; 
	}
	hashTable(int capacity, float threshold){
		if(capacity < 0 ) {
			throw new IllegalArgumentException("Illegal capacity:" + capacity);
		}
		else if(capacity > MAXIMUM_CAPACITY) capacity = MAXIMUM_CAPACITY;
		else capacity = getCapacity(capacity);
		if(threshold < 0 || Float.isNaN(threshold)) throw new IllegalArgumentException("Illegal load factor threshold: "+threshold);
		this.threshold = threshold;
		table = (Entry<K,V>[]) new Entry[capacity];
	}
	hashTable(int capacity) {
		this(capacity,DEFAULT_THRESHOLD);
	}
	hashTable(){
		this(DEFAULT_CAPACITY, DEFAULT_THRESHOLD);
	}
	int getIndex(int hash) {
		return hash & (table.length-1);
	}
	public V get (K  key) {
		int hash = key.hashCode();
		int index = getIndex(hash);
		Entry<K,V> e = table[index];
		while (e != null) {
			if(e.hash == hash && key.equals(e.key)) {
				return e.value;
			}
			e = e.next;
		}
		return null;
	}
	public V put(K key, V value) {
		int hash = key.hashCode();
		int index = getIndex(hash);
		for(Entry<K,V> entry = table[index];entry != null ; entry = entry.next) {
			if(entry.hash == hash && key.equals(entry.key)) {
				V old = entry.value;
				entry.value = value;
				return old;
			}
		}
		Entry<K,V> entry = new Entry<K,V>();
		entry.hash = hash;
		entry.key = key;
		entry.value = value;
		entry.next = table[index];
		table[index] = entry;
		size++;
		if((float)size/ table.length>threshold) {
			resize();
		}
		return null;
	}
	void resize() {
		Entry<K,V>[] old = table;
		table = (Entry<K,V>[]) new Entry [old.length*2];
		
		for(int i = 0; i < old.length; i++) {
			Entry<K,V> e = old[i];
			while (e != null) {
				Entry<K,V> next = e.next;
				int idx = getIndex(e.hash);
				e.next = table[idx];
				table[idx] = e;
				e = next;
			}
		}
	}
	void print() {
		System.out.println("\n---\n[Size = " + size + ", Table = " 
				+ table.length + ", load = " + (float)size / table.length +  "]");
		for (int i = 0; i < table.length; ++i) {
			System.out.println(i + ":");
			for (Entry<K,V> e = table[i]; e != null; e = e.next) {
				System.out.println(" - " + e.key + " [" + e.hash + "]: " + e.value);
			}
		}
	}

	public static void main(String[] args) {
		hashTable<String,Integer> hash = new hashTable<>(1, 0.3f);
		hash.put("hello", 1);
		hash.put("goodbye", 2);
		hash.put("apple", 10);
		hash.put("pear", 11);
		hash.put("apples", 13);
		hash.put("chocolate", 9);
		hash.print();
		
		hash.put("vanilla", 8);
		hash.print();

		hash.put("coffee", 10);
		hash.put("oranges", 10);
		hash.print();
	}

}
