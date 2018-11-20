package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.List;

public class InMemoryTimeEntryRepository  implements TimeEntryRepository{
    private List<TimeEntry> timeEntryList = new ArrayList<TimeEntry>();

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        timeEntryList.add(timeEntry);
        return timeEntry;
    }

    @Override
    public TimeEntry find(long id) {
        TimeEntry retTimeEntry = null;
        for(TimeEntry timeEntry : timeEntryList){
            if(timeEntry.getId() == id){
                retTimeEntry = timeEntry;
                break;
            }
        }
        return retTimeEntry;
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
        TimeEntry itemTimeEntry = find(id);
        if(itemTimeEntry != null){
            itemTimeEntry.setDate(timeEntry.getDate());
            itemTimeEntry.setHours(timeEntry.getHours());
            itemTimeEntry.setProjectId(timeEntry.getProjectId());
            itemTimeEntry.setUserId(timeEntry.getUserId());
        }
        return itemTimeEntry;
    }

    @Override
    public TimeEntry delete(long id) {
        TimeEntry itemTimeEntry = find(id);
        timeEntryList.remove( itemTimeEntry );
        return itemTimeEntry;
    }

    @Override
    public List<TimeEntry> list() {
        return timeEntryList;
    }
}
