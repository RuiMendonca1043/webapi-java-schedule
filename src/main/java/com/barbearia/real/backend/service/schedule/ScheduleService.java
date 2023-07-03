package com.barbearia.real.backend.service.schedule;

import com.barbearia.real.backend.model.client.ClientResponse;
import com.barbearia.real.backend.model.employee.EmployeeResponse;
import com.barbearia.real.backend.model.schedule.ScheduleRequest;
import com.barbearia.real.backend.model.schedule.ScheduleResponse;
import com.barbearia.real.backend.model.service.ServiceResponse;
import com.barbearia.real.backend.persistence.entity.Client;
import com.barbearia.real.backend.persistence.entity.Employee;
import com.barbearia.real.backend.persistence.entity.Schedule;
import com.barbearia.real.backend.persistence.repository.ClientRepository;
import com.barbearia.real.backend.persistence.repository.EmployeeRepository;
import com.barbearia.real.backend.persistence.repository.ScheduleRepository;
import com.barbearia.real.backend.persistence.repository.ServiceRepository;
import com.barbearia.real.backend.service.cliente.ClientService;
import com.barbearia.real.backend.service.employee.EmployeeService;
import com.barbearia.real.backend.service.service.ServiceService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleService implements IScheduleService{
    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public ScheduleResponse getById(String id) {
        Schedule s = scheduleRepository.findById(id).orElseThrow(()
        -> new ResourceNotFoundException("Not Found Schedule with this id: "+id));
        return createScheduleRes(s);
    }

    @Override
    public List<ScheduleResponse> getAll() {
        List<Schedule> list = scheduleRepository.findAll();
        List<ScheduleResponse> res = new ArrayList<>();
        for (Schedule s:list) {
            if (s.getTime().isAfter(LocalDateTime.now())){
                res.add(createScheduleRes(s));
            }
        }
        return res;
    }
    public List<ScheduleResponse> getAllByDay() {
        List<Schedule> list = scheduleRepository.findAll();
        List<ScheduleResponse> res = new ArrayList<>();
        for (Schedule s:list) {
            if (s.getTime().isAfter(LocalDateTime.now())){
                res.add(createScheduleRes(s));
            }
        }
        return res;
    }

    @Override
    public ScheduleResponse create(ScheduleRequest req) {
        Schedule s = createSchedule(req);
        if (!isTimeSlotAvailable(s)){
            return null;
        }
        updateDataBase();
        scheduleRepository.save(s);
        return createScheduleRes(s);
    }

    @Override
    public ScheduleResponse delete(String id) {
        Schedule s = scheduleRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Not Found Schedule with this id: "+id));
        scheduleRepository.delete(s);
        return createScheduleRes(s);
    }
    public void updateDataBase(){
        List<ScheduleResponse> list = getAll();
        for (ScheduleResponse r:
                list) {
            if (r.getDateTime().isBefore(LocalDateTime.now())){
                delete(r.getId());
            }
        }
    }

    private boolean isTimeSlotAvailable(Schedule schedule) {
        LocalDateTime targetTime = schedule.getTime();
        LocalDateTime startTime = targetTime.minusMinutes(29);
        LocalDateTime endTime = targetTime.plusMinutes(schedule.getService().getTime());
        List<Schedule> schedules = scheduleRepository.findAll();
        for (Schedule s : schedules) {
            if (!(s.getTime().isBefore(startTime) || s.getTime().isAfter(endTime))) {
                return false; // Encontrou uma marcação dentro do intervalo de tempo
            }
        }

        return true; // Não encontrou nenhuma marcação dentro do intervalo de tempo
    }

    private ScheduleResponse createScheduleRes(Schedule schedule){
        ScheduleResponse res = new ScheduleResponse();
        res.setId(schedule.getId());
        res.setDateTime(schedule.getTime());
        res.setService(createServiceRes(schedule.getService()));
        res.setEmployee(createEmployeeRes(schedule.getEmployee()));
        res.setClient(createClientRes(schedule.getClient()));
        return res;
    }
    private Schedule createSchedule(ScheduleRequest req){
        Schedule s = new Schedule();
        Client c = new Client();
        s.setTime(req.getTime());
        s.setService(getService(req.getServiceId()));
        s.setEmployee(getEmployee(req.getEmployeeId()));
        c.setName(req.getClientReq().getName());
        c.setEmail(req.getClientReq().getEmail());
        c.setPhoneNumber(req.getClientReq().getPhoneNumber());
        s.setClient(c);
        return s;
    }
    private ServiceResponse createServiceRes(com.barbearia.real.backend.persistence.entity.Service s){
        ServiceResponse res = new ServiceResponse();
        res.setId(s.getId());
        res.setTitle(s.getTitle());
        res.setDescription(s.getDescription());
        res.setPrice(s.getPrice());
        res.setTime(s.getTime());
        res.setType(s.getType());
        return res;
    }
    private EmployeeResponse createEmployeeRes(Employee e){
        EmployeeResponse res = new EmployeeResponse();
        res.setId(e.getId());
        res.setName(e.getName());
        return res;
    }
    private ClientResponse createClientRes(Client c){
        ClientResponse res = new ClientResponse();
        res.setId(c.getId());
        res.setName(c.getName());
        res.setEmail(c.getEmail());
        res.setPhoneNumber(c.getPhoneNumber());
        return res;
    }
    private com.barbearia.real.backend.persistence.entity.Service getService(String id){
        return serviceRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Not Found Service with this id: "+id));
    }
    private Employee getEmployee(String id){
        return employeeRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Not Found employee with this id: "+id));
    }


}
