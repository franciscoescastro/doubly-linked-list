package edu.sdsu.doublylinkedlist.model;

import java.security.InvalidParameterException;

public class Student {
    private String name;
    private int redId;
    private float gpa;

    public Student() {
    }

    public Student(String name, int redId, float gpa) {
        setName(name);
        setRedId(redId);
        setGpa(gpa);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new InvalidParameterException();
        }
        this.name = name;
    }

    public int getRedId() {
        return redId;
    }

    public void setRedId(int redId) {
        if (redId <= 0) {
            throw new InvalidParameterException();
        }
        this.redId = redId;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        if (gpa < 0) {
            throw new InvalidParameterException();
        }
        this.gpa = gpa;
    }

    public boolean isOnProbation() {
        return gpa < 2.85f;
    }

    public boolean hasGPA4() {
        return gpa == 4;
    }

    @Override
    public boolean equals(Object obj) {
        Student student = (Student) obj;
        return name.equals(student.getName()) && redId == student.getRedId() && gpa ==
                student.getGpa();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Student [name=").append(name).append(", redId=")
                .append(redId).append(", gpa=").append(gpa).append("]");
        return builder.toString();
    }
}