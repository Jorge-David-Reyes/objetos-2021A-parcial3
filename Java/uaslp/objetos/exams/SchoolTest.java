package uaslp.objetos.exams;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SchoolTest {

    @Test
    public void whenGroupIsCreated_sizeOfStudentsIsZeroAndCapacityIsGivenViaConstructor() {
        // Given:
        Group group = new Group(21);

        // When:
        List<Student> students = group.getStudents();

        // Then:
        // Validar que el número de alumnos añadidos al grupo es cero
        assertEquals(0, students.size());
        // Validar que el cupo del grupo se estableció desde el constructor correctamente
        assertEquals(21, group.getCapacity());
        // La disponibilidad del grupo corresponde al cupo total menos los alumnos añadidos
        assertEquals(21, group.getAvailability());
    }

    @Test
    public void givenGroupWithCapacity3With3Students_whenGetAvailability_thenReturnZero() {
        // Given:
        Group group = new Group(3);

        group.addStudent(new Student("Lucia López", 413231));
        group.addStudent(new Student("Mario Martinez", 12353));
        group.addStudent(new Student("Rosario Sánchez", 624324));

        // When:
        List<Student> students = group.getStudents();

        // Then:
        assertEquals(3, students.size());
        assertEquals(3, group.getCapacity());
        assertEquals(0, group.getAvailability());

        Student student = students.get(0);

        assertEquals("Lucia López", student.getName());
        assertEquals(413231, student.getCode());

        student = students.get(1);

        assertEquals("Mario Martinez", student.getName());
        assertEquals(12353, student.getCode());

        student = students.get(2);

        assertEquals("Rosario Sánchez", student.getName());
        assertEquals(624324, student.getCode());
    }

    @Test
    public void givenGroupWithCapacity3With3Students_whenAddAFourthStudent_thenGroupIsFullException() {
        // Given:
        Group group = new Group(3);

        group.addStudent(new Student("Lucia López", 413231));
        group.addStudent(new Student("Mario Martinez", 12353));
        group.addStudent(new Student("Rosario Sánchez", 624324));

        // When / Then:
        Assertions.assertThrows(GroupIsFullException.class, () -> group.addStudent(new Student("Francisco Rodríguez", 4112322)));
    }

    @Test
    public void givenScoresPerPartial_whenAverageIsRequested_thenAverageIsCorrect() throws InvalidPartialException {
        // Given:
        Student lucia = new Student("Lucia López", 413231);

        lucia.setScore(1, 90);
        lucia.setScore(2, 100);
        lucia.setScore(3, 80);

        // When:
        double average = lucia.getAverage();

        // Then:
        Assertions.assertEquals(90, average);
    }

    @Test
    public void givenScoresPerPartial_whenTryToSetAnInvalidPartial_thenInvalidPartialExceptionIsThrown() {
        // Given:
        Student lucia = new Student("Lucia López", 413231);

        // When / Then:
        Assertions.assertThrows(InvalidPartialException.class, () -> lucia.setScore(4, 80));
    }

    @Test
    public void givenScoresPerPartialWithMissingPartials_whenGetAverage_thenMissingScoreExceptionIsThrown() throws InvalidPartialException {
        // Given:
        Student lucia = new Student("Lucia López", 413231);

        lucia.setScore(1, 100);
        lucia.setScore(3, 100);

        // When / Then:
        Exception exception = Assertions.assertThrows(MissingScoreException.class, () -> lucia.getAverage());

        assertEquals("Missing partial 2", exception.getMessage());

    }

    @Test
    public void whenGetGroupAverage_thenAverageIsReturned() {
        // Given:
        Student lucia = Mockito.mock(Student.class);
        Student mario = Mockito.mock(Student.class);
        Student raul = Mockito.mock(Student.class);
        Group group = new Group(12);

        group.addStudent(lucia);
        group.addStudent(mario);
        group.addStudent(raul);

        Mockito.when(lucia.getAverage()).thenReturn(100.0);
        Mockito.when(mario.getAverage()).thenReturn(80.0);
        Mockito.when(raul.getAverage()).thenReturn(90.0);

        // When:
        double average = group.getAverage();

        // Then:
        assertEquals(90, average);

    }
}
