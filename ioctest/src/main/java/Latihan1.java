import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Latihan1 {
	 public static void main(String[] args) throws IOException {

	        // Array can also be a source of a Stream
	        /*Stream<String> streamOfArray = Stream.of("a", "b", "c");
	        streamOfArray.forEach(System.out::println);

	        System.out.println("\n");
	        
	        // creating from existing array or of a part of an array:
	        String[] arr = new String[] { "a", "b", "c" };
	        Stream<String> streamOfArrayFull = Arrays.stream(arr);
	        streamOfArrayFull.forEach(System.out::println);

	        System.out.println("\n");
	        
	        Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);
	        streamOfArrayPart.forEach(System.out::println);
	        
	        System.out.println("\n");
	        
	        Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7,8,9);
	        stream.forEach(p -> System.out.println(p));
	        
	        System.out.println("\n");
	        
	        Stream<Integer> stream2 = Stream.of( new Integer[]{1,2,3,4,5,6,7,8,9} );
	        stream2.forEach(p -> System.out.println(p));
	        
	        System.out.println("\n");
	        
	        List<Integer> list = new ArrayList<Integer>();

	        for(int i = 1; i< 10; i++){
	              list.add(i);
	        }

	        Stream<Integer> stream3 = list.stream();
	        stream3.forEach(p -> System.out.println(p));
	        
	        System.out.println("\n");
	        
	        Stream<Integer> randomNumbers = Stream
	        	      .generate(() -> (new Random()).nextInt(100));

	        	randomNumbers.limit(20).forEach(System.out::println);
	        	
	        System.out.println("\n");
	        	
	        IntStream stream4 = "12345_abcdefg".chars();
	       	stream4.forEach(p -> System.out.println(p));

	      	//OR

	       	Stream<String> stream5 = Stream.of("A$B$C".split("\\$"));
	       	stream5.forEach(p -> System.out.println(p));
	       	
	       	System.out.println("\n");
	       	*/
		 
		 List<String> memberNames = new ArrayList<>();
		 memberNames.add("Amitabh");
		 memberNames.add("Shekhar");
		 memberNames.add("Aman");
		 memberNames.add("Rahul");
		 memberNames.add("Shahrukh");
		 memberNames.add("Salman");
		 memberNames.add("Yana");
		 memberNames.add("Lokesh");
		 
		 memberNames.stream().filter((s) -> s.startsWith("A"))
         .forEach(System.out::println);
		 
		 System.out.println();
		 
		 memberNames.stream().filter((s) -> s.startsWith("A"))
         .map(String::toUpperCase)
         .forEach(System.out::println);
		 
		 System.out.println();
		 
		 memberNames.stream().sorted()
         .map(String::toUpperCase)
         .forEach(System.out::println);
		 
		 System.out.println();
		 
		 memberNames.forEach(System.out::println);
		 
		 System.out.println();
		 
		 List<String> memNamesInUppercase = memberNames.stream().sorted()
                 .map(String::toUpperCase)
                 .collect(Collectors.toList());

		 System.out.print(memNamesInUppercase);
		 
		 System.out.println("\n");
		 
		 boolean matchedResult = memberNames.stream()
			        .anyMatch((s) -> s.startsWith("A"));
			 
			System.out.println(matchedResult);     //true
			 
			matchedResult = memberNames.stream()
			        .allMatch((s) -> s.startsWith("A"));
			 
			System.out.println(matchedResult);     //false
			 
			matchedResult = memberNames.stream()
			        .noneMatch((s) -> s.startsWith("A"));
			 
			System.out.println(matchedResult);     //false
			
			System.out.println();
			
			long totalMatched = memberNames.stream()
				    .filter((s) -> s.startsWith("A"))
				    .count();
				 
			System.out.println(totalMatched);
				
			System.out.println();
			
			Optional<String> reduced = memberNames.stream()
			        .reduce((s1,s2) -> s1 + "#" + s2);
				 
			reduced.ifPresent(System.out::println);
			
			System.out.println();
			
			boolean matched = memberNames.stream()
			        .anyMatch((s) -> s.startsWith("S"));
			 
			System.out.println(matched);    //true
			
			System.out.println();

			String firstMatchedName = memberNames.stream()
		            .filter((s) -> s.startsWith("A"))
		            .findFirst()
		                        .get();
		 
			System.out.println(firstMatchedName);    //Lokesh
			
			System.out.println();
			
			List<Integer> list = new ArrayList<Integer>();
			for(int i = 1; i< 10; i++){
			 list.add(i);
			}

			//Here creating a parallel stream
			Stream<Integer> stream = list.parallelStream();  

			Integer[] evenNumbersArr = stream.filter(i -> i%2 == 0).toArray(Integer[]::new);
			System.out.print(evenNumbersArr);
			
			System.out.println("\n");
			
			List<Integer> list2 = Arrays.asList(2, 4, 1, 3, 7, 5, 9, 6, 8);
			 
			Comparator<Integer> maxComparator = new Comparator<Integer>() {
			   
			  @Override
			  public int compare(Integer n1, Integer n2) {
			    return n1.compareTo(n2);
			  }
			};

			Optional<Integer> maxNumber = list2.stream()
			      .max(maxComparator);

			System.out.println(maxNumber.get());
	 }
}
