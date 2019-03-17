package com.app.studentmanagement.entity;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class CourseSubject {

	@EmbeddedId
	CourseSubjectID id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@MapsId("course_id")
	@JoinColumn(name = "course_id")
	Course course;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@MapsId("subject_id")
	@JoinColumn(name = "subject_id")
	Subject subject;

	public CourseSubject() {
		super();
	}

	public CourseSubject( Course course, Subject subject) {
		super();
		this.id = new CourseSubjectID(course.getId(), subject.getId());
		this.course = course;
		this.subject = subject;
	}

	public CourseSubjectID getId() {
		return id;
	}

	public void setId(CourseSubjectID id) {
		this.id = id;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "CourseSubject [id=" + id + ", course=" + course + ", subject=" + subject + "]";
	}
	
	
}
