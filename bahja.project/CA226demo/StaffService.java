package justAssigment.CA226demo;


import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class StaffService {
    private final Map<Long, Staff> Staffs=new ConcurrentHashMap<>();
    private final AtomicLong authid =new AtomicLong();

    public  Collection<Staff> getAllStaffs(){
        return Staffs.values();
    }

    public Staff getStaffById(Long id){
        return Staffs.get(id);
    }

    public void createStaff(Staff NewStaff){
        Long staffid=NewStaff.getId() !=null
                ? NewStaff.getId()
                : authid.incrementAndGet();
        NewStaff.setId(staffid);
        Staffs.put(staffid,NewStaff);
    }


    public Staff UpdateStaff(Long id, Staff newStaff) {
        if (Staffs.containsKey(id)) {
            Staff oldStaff = getStaffById(id);
            oldStaff.clone(newStaff.getName());
            oldStaff.setRole(newStaff.getRole());

            Staffs.put(id, oldStaff);
            return oldStaff;
        } else {
            return null;
        }
    }


    public void deleteStaff(Long id){
        Staffs.remove(id);
    }

}