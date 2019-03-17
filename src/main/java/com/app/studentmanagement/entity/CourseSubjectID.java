package com.app.studentmanagement.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CourseSubjectID implements Serializable{

	private static final long serialVersionUID = -7644965700555542973L;
	
	@Column(name = "course_id")
	Long courseID;
	
	@Column(name = "subject_id")
	Long subjectID;
	
	public CourseSubjectID() {
		
	}

	public CourseSubjectID(Long courseID, Long subjectID) {
		super();
		this.courseID = courseID;
		this.subjectID = subjectID;
	}

	public Long getCourseID() {
		return courseID;
	}

	public void setCourseID(Long courseID) {
		this.courseID = courseID;
	}

	public Long getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(Long subjectID) {
		this.subjectID = subjectID;
	}
	
}
