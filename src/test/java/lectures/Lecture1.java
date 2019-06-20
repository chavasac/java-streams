package lectures;

import beans.Person;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;


public class Lecture1 {

  @Test
  public void imperativeApproach() throws IOException {
    List<Person> people = MockData.getPeople();
    // 1. Find people aged less or equal 18
    // 2. Then change implementation to find first 10 people

    List<Person> teenAgers = new ArrayList<>();
    for (Person person : people) {
      if (null != person && person.getAge() <= 18) {
        teenAgers.add(person);
      }
    }

    int i = 0;
    while (i < 10) {
      System.out.println(teenAgers.get(i).getFirstName());
      i++;
    }

  }

  @Test
  public void declarativeApproachUsingStreams() throws Exception {
    ImmutableList<Person> people = MockData.getPeople();

    people.stream()
        .filter(person -> person.getAge() <= 18)
        .limit(10)
        .collect(Collectors.toList()).forEach(person -> System.out.println(person.getFirstName()));

  }
}
