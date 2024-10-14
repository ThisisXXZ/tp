package findoursep;

import allocator.Allocator;
import student.Student;
import studentlist.StudentList;
import ui.UI;
import university.UniversityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AllocatorTest {

    private StudentList studentList;
    private Allocator allocator;

    @BeforeEach
    public void setUp() {
        Student student1 = new Student("1", 3.8f, new ArrayList<>(Arrays.asList(1, 2, 3)));
        Student student2 = new Student("2", 3.5f, new ArrayList<>(Arrays.asList(3, 1, 2)));
        Student student3 = new Student("3", 3.9f, new ArrayList<>(Arrays.asList(3, 2, 1)));
        Student student4 = new Student("4", 3.6f, new ArrayList<>(Arrays.asList(3, 2, 1)));

        studentList = new StudentList(new UI());
        studentList.addStudent(student1);
        studentList.addStudent(student2);
        studentList.addStudent(student3);
        studentList.addStudent(student4);
        allocator = new Allocator(studentList);
    }

    @Test
    public void testAllocate() {
        StudentList allocatedStudents = allocator.allocate();

        assertTrue(allocatedStudents.getList().get(0).getSuccessfullyAllocated());
        assertFalse(allocatedStudents.getList().get(1).getSuccessfullyAllocated());
        assertTrue(allocatedStudents.getList().get(2).getSuccessfullyAllocated());
        assertTrue(allocatedStudents.getList().get(3).getSuccessfullyAllocated());

        // Check if universities have the correct number of spots left
        assertEquals(0, UniversityRepository.getUniversityByIndex(1).getSpotsLeft());
        assertEquals(0, UniversityRepository.getUniversityByIndex(2).getSpotsLeft());
        assertEquals(0, UniversityRepository.getUniversityByIndex(3).getSpotsLeft());

        // Check if students are allocated to the correct universities
        assertEquals(1, allocatedStudents.getList().get(0).getAllocatedUniversity());
        assertEquals(-1, allocatedStudents.getList().get(1).getAllocatedUniversity());
        assertEquals(3, allocatedStudents.getList().get(2).getAllocatedUniversity());
        assertEquals(2, allocatedStudents.getList().get(3).getAllocatedUniversity());
    }
}