package mypack;

import java.util.ArrayList;
import java.util.List;
public class MyHashMap<K,V>{

	//This class will contain key and value pair for every element.
	class  Container{
		K key;
		V value;
		public void insert(K k, V v){
			this.key=k;
			this.value=v;
		}
	}
	
	private Container c;
	//recordList is a list of type Container, for ith index it will give value of key and pair.
	private List<Container> recordList;

	//Default Constructor to define the recordList.
	public MyHashMap(){
		
		this.recordList=new ArrayList<Container>();
	}

	//put method will add a key and its value in recordList and will also check for duplicate keys.
	public void put(K k, V v){
		this.c=new Container();
		c.insert(k, v);
		int i;
		//It will check for the same key before adding
		for(i=0; i<recordList.size(); i++){
			Container c1=recordList.get(i);
			if(c1.key.equals(k)){
				//This will remove the existing key, value pair
				recordList.remove(i);
				break;
			}
		}
		//To add the new key, value at index i
		recordList.add(i,c);
	}

	//This method will return the value for the given key.
	public V get(K k) {
		for (int i = 0; i < this.recordList.size(); i++) {
			Container con = recordList.get(i);
			if(con.key.equals(k)){
				return con.value;
			}

		}
		return null;
	}

	//This method will delete key, value pair if given key exists and returns true else it will return false
	public boolean remove(K k){
		for (int i = 0; i < this.recordList.size(); i++) {
			Container con = recordList.get(i);
			if(con.key.equals(k)){
				//remove the existing String
				recordList.remove(i);
				return true;
			}

		}
		return false;
	}

	//This method will empty the hashMap array
	public void clear(){
		for (int i = this.recordList.size() - 1; i >= 0; i--) {
			Container con = recordList.get(i);
			recordList.remove(i);
		}
	}

	//This method will return the number of different keys in the recordList
	public int size(){
		return recordList.size();
	}

	//This method displays all the keys and their respective values.
	public void display(){
		for(int i=0;i<this.recordList.size();i++){
			Container con = recordList.get(i);
			System.out.print(con.key + " -> " + con.value);
			if(i!=this.recordList.size()-1)
				System.out.print(",  ");
		}
		System.out.println();
	}

	//This method return Key at the given index.
	//If index is out of range then it will also handle that case.
	public K getKey(int index){
		if(recordList.size()==0)
			return null;
		index=index%(this.recordList.size());
		Container con = recordList.get(index);
		return con.key;
	}

	//This method return Value at the given index.
	//If index is out of range then it will also handle that case.
	public V getValue(int index){
		if(recordList.size()==0)
			return null;
		index=index%(this.recordList.size());
		Container con = recordList.get(index);
		return con.value;
	}
}