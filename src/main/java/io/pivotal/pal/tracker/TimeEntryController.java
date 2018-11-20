package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {

    private TimeEntryRepository timeEntryRepository;


    public TimeEntryController(@Autowired TimeEntryRepository timeEntryRepository){
        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping
    public ResponseEntity<TimeEntry>  create(@RequestBody TimeEntry timeEntry) {
        TimeEntry ret = timeEntryRepository.create(timeEntry);
        return new ResponseEntity<TimeEntry>(ret,HttpStatus.CREATED);
    }


    @GetMapping("{id}")
    public ResponseEntity<TimeEntry>  read(@PathVariable Long id) {
        TimeEntry ret = timeEntryRepository.find(id);
        return new ResponseEntity<TimeEntry>(ret,HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<TimeEntry>  update(@PathVariable long id, @RequestBody TimeEntry timeEntry) {
        TimeEntry ret = timeEntryRepository.update(id, timeEntry);
        return new ResponseEntity<TimeEntry>(ret,HttpStatus.OK);
    }


    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable long id) {
        TimeEntry ret = timeEntryRepository.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<TimeEntry>>  list() {
        List<TimeEntry> listTimeEntry = timeEntryRepository.list();
        return new ResponseEntity<List<TimeEntry>> (listTimeEntry ,HttpStatus.OK);
    }
}
