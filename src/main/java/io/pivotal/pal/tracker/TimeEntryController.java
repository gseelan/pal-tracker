package io.pivotal.pal.tracker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeEntryController {

	private TimeEntryRepository timeEntryRepository;

	public TimeEntryController() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public TimeEntryController(TimeEntryRepository timeEntryRepository) {
		super();
		this.timeEntryRepository = timeEntryRepository;
	}

	@PostMapping("/time-entries")
	// @ResponseBody
	public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntry) {
		TimeEntry te = timeEntryRepository.create(timeEntry);
		ResponseEntity<TimeEntry> ert = ResponseEntity.status(HttpStatus.CREATED).body(te);
		return ert;
	}

	@GetMapping("/time-entries/{id}")
	public ResponseEntity<TimeEntry> read(@PathVariable Long id) {
		TimeEntry te = timeEntryRepository.find(id);
		return te == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
				: ResponseEntity.status(HttpStatus.OK).body(te);
	}

	@GetMapping("/time-entries")
	public ResponseEntity<List<TimeEntry>> list() {
		return ResponseEntity.status(HttpStatus.OK).body(timeEntryRepository.list());
	}

	@PutMapping("/time-entries/{id}")
	public ResponseEntity update(@PathVariable Long id, @RequestBody TimeEntry timeEntry) {
		TimeEntry te = timeEntryRepository.update(id, timeEntry);
		return te == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.status(HttpStatus.OK).body(te);
	}

	@DeleteMapping("/time-entries/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		timeEntryRepository.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
