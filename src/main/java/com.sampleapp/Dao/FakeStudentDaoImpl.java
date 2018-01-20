package com.sampleapp.Dao;

import com.sampleapp.Entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("fakeData")
public class FakeStudentDaoImpl implements StudentDao {

    private static Map<Integer, Student> students;

    static {
        students = new HashMap<Integer, Student>() {
            {
                put(1, new Student(1, "A", "CS"));
                put(2, new Student(2, "B", "CS"));
                put(3, new Student(3, "C", "CS"));
            }
        };
    }

    @Override
    public Collection<Student> getAllStudents() {
        return students.values();
    }

    @Override
    public Student getStudentById(int id) {
        return students.get(id);
    }

    @Override
    public Student updateStudentById(int id, Student student) {
        Student s = students.get(id);
        s.setName(student.getName());
        s.setCourse(student.getCourse());

        return s;
    }

    @Override
    public void deleteStudentById(int id) {
        students.remove(id);
    }

    @Override
    public Student createStudent(Student student) {
        int id = students.size() + 1;
        Student s = new Student(id, student.getName(), student.getCourse());
        students.put(id, s);
        return s;
    }
}