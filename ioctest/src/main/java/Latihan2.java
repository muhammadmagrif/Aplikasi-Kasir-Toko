import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Latihan2 {
	 @SuppressWarnings("unused")
	  public static void main(final String[] args) throws NoSuchAlgorithmException {
	    Random random = new Random();
	    
	    Scanner scan = new Scanner(System.in);
	    System.out.println("Masukkan banyak jumlah bilangan random yang ingin dikeluarkan : ");
	    int jumlah = scan.nextInt();

	    //1
	    IntStream randStream = random.ints(jumlah);
	    randStream.forEach(System.out::println);
	    
	    System.out.println("\n");

	    //2
	    DoubleStream doubleStream = random.doubles(jumlah, 0, 0.5);
	    doubleStream.forEach(System.out::println);
	    
	    System.out.println("\n");

	    //collect to list
	    List<Long> longs = random.longs(5)
	        .boxed()
	        .collect(Collectors.toList());

	    SecureRandom sRand = SecureRandom.getInstanceStrong();
	    randStream = random.ints(jumlah);
	    randStream.forEach(System.out::println);
	    
	    scan.close();
	  }
	}
