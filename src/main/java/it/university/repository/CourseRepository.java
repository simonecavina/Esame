package it.university.repository;

import it.university.Interfaces.ICourseRepository;
import it.university.model.Course;
import java.util.*;

public class CourseRepository implements ICourseRepository{
    private Map<Integer, Course> data = new HashMap<>();

    @Override
    public void save(Course c) {
        data.put(c.getId(), c);
    }
    @Override
    public Course findById(Integer id) {
        return data.get(id);
    }
    @Override
    public List<Course> findAll() {
        return new ArrayList<>(data.values());
    }
}
