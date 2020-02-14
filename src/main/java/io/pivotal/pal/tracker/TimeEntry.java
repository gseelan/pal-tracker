package io.pivotal.pal.tracker;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class TimeEntry {

	private Long id;
	private long projectId;
	private long userId;
	private LocalDate date;
	private int hours;

	private static Long co = (long) 0;

	public static Long getCo() {
		return co;
	}

	public static void setCo(Long co) {
		TimeEntry.co = co;
	}

	public TimeEntry() {
		// TODO Auto-generated constructor stub
	}

	public TimeEntry(long projectId, long userId, LocalDate date, int hours) {
		this(++co, projectId, userId, date, hours);
	}

	public TimeEntry(long id, long projectId, long userId, LocalDate date, int hours) {
		super();
		this.id = id;
		this.projectId = projectId;
		this.userId = userId;
		this.date = date;
		this.setHours(hours);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.getId().hashCode();
	}
	

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof TimeEntry && this instanceof TimeEntry) {
			TimeEntry o = (TimeEntry) obj;
			return this.getId() == o.getId();
		}
		return false;
	}

}
