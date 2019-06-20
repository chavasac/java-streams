package lectures;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture11 {

  @Test
  public void joiningStrings() throws Exception {
    List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");

    String result = "";

    for (String name : names) {
      result += name + ", ";
    }

    System.out.println(result.substring(0, result.length() - 2));
  }

  @Test
  public void joiningStringsWithStream() throws Exception {
    List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");

    String result = names.stream()
        .collect(Collectors.joining(","));

    System.out.println(result);


  }
}
