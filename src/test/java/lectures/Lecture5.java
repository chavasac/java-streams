package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import mockdata.MockData;
import org.junit.Test;

public class Lecture5 {

  @Test
  public void understandingFilter() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();

    List<Car> selectedCars = cars.stream()
        .filter(car -> car.getPrice() < 10000)
        .collect(Collectors.toList());

    selectedCars.forEach(System.out::println);

    System.out.println(selectedCars.size());
  }

  @Test
  public void ourFirstMapping() throws Exception {
    // transform from one data type to another
    List<Person> people = MockData.getPeople();

    List<PersonDTO> dtos = people.stream()
        .map(person -> {
          PersonDTO dto = new PersonDTO(person.getId(), person.getFirstName(), person.getAge());
          return dto;
        })
        .collect(Collectors.toList());

    dtos.forEach(System.out::println);

    assertThat(dtos).hasSize(1000);
  }

  @Test
  public void averageCarPrice() throws Exception {
    // calculate average of car prices

    ImmutableList<Car> cars = MockData.getCars();

    OptionalDouble averagePrice = cars.stream()
        .mapToDouble(car -> car.getPrice())
        .average();

    System.out.println("Average price is : " + averagePrice);
  }

  @Test
  public void test() throws Exception {

  }
}



