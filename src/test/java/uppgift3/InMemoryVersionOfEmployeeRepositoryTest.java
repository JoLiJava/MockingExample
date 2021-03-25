package uppgift3;

import com.example.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InMemoryVersionOfEmployeeRepositoryTest {

    InMemoryVersionOfEmployeeRepository inMemoryVersionOfEmployeeRepository = new InMemoryVersionOfEmployeeRepository();

    @Test
    @DisplayName("Has saved Employee")
    void hasSavedEmployee() {
        Employee employee = new Employee("01", 2000);

        var actual = inMemoryVersionOfEmployeeRepository.save(employee);

        assertEquals(1, inMemoryVersionOfEmployeeRepository.employees.size());

    }

    @Test
    @DisplayName("Overwriting employee")
    void overwritingEmployee() {
        Employee employee1 = new Employee("01", 2000);
        Employee employee2 = new Employee("01", 3000);
        inMemoryVersionOfEmployeeRepository.save(employee1);

        inMemoryVersionOfEmployeeRepository.save(employee2);


        assertEquals(1, inMemoryVersionOfEmployeeRepository.findAll().size());
        assertEquals(3000, inMemoryVersionOfEmployeeRepository.findAll().get(0).getSalary());
    }

    @Test
    @DisplayName("Adding employee with no id")
    void addingEmployeeWithNoId() {
        Employee employee1 = new Employee("1", 2000);
        Employee employee2 = new Employee("0", 3000);
        inMemoryVersionOfEmployeeRepository.save(employee1);
        inMemoryVersionOfEmployeeRepository.save(employee2);


        assertEquals("2", inMemoryVersionOfEmployeeRepository.findAll().get(1).getId());
    }


}
