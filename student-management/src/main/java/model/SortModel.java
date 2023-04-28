package model;

import java.util.Comparator;

public class SortModel {
	public Comparator<Student> AscNameStudent() {
		return new Comparator<Student>() {
			@Override
			public int compare(Student s1,Student s2) {
				return s1.getName().compareTo(s2.getName());
			}
		};
	}
	public Comparator<Student> DescNameStudent() {
		return new Comparator<Student>() {
			@Override
			public int compare(Student s1,Student s2) {
				return s2.getName().compareTo(s1.getName());
			}
		};
	}
	public Comparator<Course> AscNameCourse() {
		return new Comparator<Course>() {
			@Override
			public int compare(Course s1,Course s2) {
				return s1.getName().compareTo(s2.getName());
			}
		};
	}
	public Comparator<Course> DescNameCourse() {
		return new Comparator<Course>() {
			@Override
			public int compare(Course s1,Course s2) {
				return s2.getName().compareTo(s1.getName());
			}
		};
	}
	public Comparator<Student> AscGrade() {
		return new Comparator<Student>() {
			@Override
			public int compare(Student s1,Student s2) {
				return Integer.compare(s1.getGrade(),s2.getGrade());
			}
		};
	}
	public Comparator<Student> DescGrade() {
		return new Comparator<Student>() {
			@Override
			public int compare(Student s1,Student s2) {
				return Integer.compare(s2.getGrade(),s1.getGrade());
			}
		};
	}
}