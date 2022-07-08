import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Min {
	public static void main(String[] args) throws IOException {
		List<Integer> list = Arrays.asList(2, 4, 1, 3, 7, 5, 9, 6, 8);

		Optional<Integer> minNumber = list.stream()
		            .min((i, j) -> i.compareTo(j));

		System.out.println(minNumber.get());
	}
}
