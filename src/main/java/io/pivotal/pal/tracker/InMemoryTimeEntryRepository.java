package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

	private Map<Long, TimeEntry> timeEntryMap;

	public TimeEntry create(TimeEntry tet) {
		TimeEntry te = null;
		if (null == getTimeEntryMap()) {
			timeEntryMap = new HashMap<>();
		}
		if (null == tet.getId()) {
			tet = new TimeEntry(tet.getProjectId(), tet.getUserId(), tet.getDate(), tet.getHours());
		}

		te = new TimeEntry(tet.getId(), tet.getProjectId(), tet.getUserId(), tet.getDate(), tet.getHours());
		timeEntryMap.put(te.getId(), te);

		return timeEntryMap.get(te.getId());
	}

	public TimeEntry find(Long id) {
		if (null != getTimeEntryMap() && null != getTimeEntryMap().get(id)) {
			return getTimeEntryMap().get(id);
		}
		return null;
	}

	public void delete(Long id) {
		getTimeEntryMap().remove(id);
	}

	public Map<Long, TimeEntry> getTimeEntryMap() {
		return timeEntryMap;
	}

	public void setTimeEntryMap(Map<Long, TimeEntry> timeEntryMap) {
		this.timeEntryMap = timeEntryMap;
	}

	@Override
	public List<TimeEntry> list() {
		List<TimeEntry> timeEntryList = null;
		if (null != getTimeEntryMap()) {
			timeEntryList = new ArrayList<>(getTimeEntryMap().values());
		}
		return timeEntryList;
	}

	@Override
	public TimeEntry update(Long id, TimeEntry tet) {
		TimeEntry te = null;
		if (null != getTimeEntryMap() && getTimeEntryMap().get(id) != null) {
			te = new TimeEntry(id, tet.getProjectId(), tet.getUserId(), tet.getDate(), tet.getHours());
			getTimeEntryMap().put(id, te);
		}
		return te;
	}

}
