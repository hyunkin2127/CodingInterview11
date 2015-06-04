package collectionTest;
import java.util.*;

public class TestHashMap<K,V> extends HashMap<K, V> {
	// count기능을 추가하기 위해 HashMap을 상속받아서 put 메서드를 Override함
	public V put(K key, V value){
		//만약 seperateChain 을 구현한다면 여기서 해야함
		if(super.containsKey(key))	((Cnt)super.get(key)).cnt++; // get(key)는 해당 value의 주소값을 반환한다. 
		else	super.put(key, value);
		return null;

//		containsKey()를 사용하지 않을경우 : hashmap.put()이 이미 map 내부에 해당 key값이 존재할경우 oldvalue를 반환함
//		이를 활용해서 값을 변경할 수 있음 
//		V oldValue = super.put(key, value);
//		if(oldValue != null){
//			Cnt na = ((Cnt)super.get(key));
//			na.cnt = ((Cnt)oldValue).cnt +1;
//			System.out.println(key +" : "+ na.cnt);
//		}
//		return null;
	}
	
	public <T> void makeHashMap(T[] arr){
		TestHashMap<T, Cnt> hm = new TestHashMap<T, Cnt>(); // hashcode() 리턴값이 int 형이므로 굳이 generic을 쓸필요는 없음
//	TestHashMap<Integer, Counter> hm = new TestHashMap<Integer, Counter>(); 
		for(T i : arr){
			hm.put((T)new Integer(i.hashCode()), new Cnt()); // 같은 key값이 들어오더라도 counter객체를 새로생성하므로 cnt값이 유지되지않음
//		hm.put(i.hashCode(), new Cnt()); // hascode() 리턴값이 int 형이므로 굳이 generic을 쓸필요는 없음
		}
		
		Set<Map.Entry<T, Cnt>> m = hm.entrySet();
		for(Map.Entry<T, Cnt> i : m){
			System.out.println(i.getKey() + " " + i.getValue().cnt);
		}
	}
	
 class Cnt {
	 int cnt;
	 
	 public Cnt(){
		 this.cnt=1;
	 }
 }

}
