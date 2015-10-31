package designPatterns;

/**
 * Created by Heon on 2015-10-31.
 */
public class singleton {

	private static singleton a;

	private singleton(){}

	public static singleton getInstance(){
		if(a == null) a = new singleton();
		return a;
	}

}
