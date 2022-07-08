import java.io.IOException;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Count {
	public static void main(String[] args) throws IOException {
	long count = Stream.of("how","to","do","in","java").count();	//5
	
	System.out.println(count);
	 
	long count2 = IntStream.of(1,2,3,4,5,6,7,8,9).count();   //9
	
	System.out.println(count2);
	
	long count3 = LongStream.of(1,2,3,4,5,6,7,8,9)
            .filter(i -> i%2 == 0)
            .count();
            //or
            //.collect(Collectors.counting())
	
	System.out.println(count3);
	}
}
