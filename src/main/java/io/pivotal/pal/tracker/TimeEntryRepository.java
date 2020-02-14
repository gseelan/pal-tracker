package io.pivotal.pal.tracker;

import java.util.List;

import org.springframework.stereotype.Repository;

public interface TimeEntryRepository {
	
	public void delete(Long id);
	public TimeEntry create(TimeEntry timeEntry);
	public TimeEntry find(Long id);
	public List<TimeEntry> list();
	public TimeEntry update(Long id, TimeEntry timeEntry);

}
