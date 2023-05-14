import java.lang.reflect.Array;
import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		
		//int []i = {10,20};
		int[] arr = (int[])Array.newInstance(int.class,5);
		
		System.out.println(Arrays.toString(arr));
	}

}
