package com.tkgroupbd.pusti.api.services.systemsettings;

import com.tkgroupbd.pusti.api.data.models.entity.systemsettings.TimePass;
import com.tkgroupbd.pusti.api.data.payloads.requests.systemsettings.TimePassRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import com.tkgroupbd.pusti.api.data.repositories.systemsettings.TimePassRepository;
import com.tkgroupbd.pusti.api.exceptions.ResourceNotFoundException;
import com.tkgroupbd.pusti.api.utils.constant.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimePassServiceImpl implements TimePassService {

    @Autowired
    private TimePassRepository repository;

    @Override
    public MessageResponse createTimePass(TimePassRequest request) {
        TimePass timePass = new TimePass();

        timePass.setNumberOfDaysInMonth(request.getNumberOfDaysInMonth());
        timePass.setNumberOfHolidays(request.getNumberOfHolidays());
        timePass.setWorkingDaysInMonth(request.getWorkingDaysInMonth());
        timePass.setYearMonth(request.getYearMonth());
        timePass.setStatus(request.isStatus());
        timePass.setCreatedAt(request.getCreatedAt());
        timePass.setDeletedAt(request.getDeletedAt());
        timePass.setUpdatedAt(request.getUpdatedAt());
        timePass.setBrowser(request.getBrowser());
        timePass.setIp(request.getIp());

        repository.save(timePass);

        return new MessageResponse(Message.SUCCESS_CREATION);
    }

    @Override
    public Optional<TimePass> updateTimePass(Integer id, TimePassRequest request) {
        Optional<TimePass> result = repository.findById(id);

        if (result.isPresent()) {
            TimePass timePass = result.get();
            timePass.setNumberOfDaysInMonth(request.getNumberOfDaysInMonth());
            timePass.setNumberOfHolidays(request.getNumberOfHolidays());
            timePass.setWorkingDaysInMonth(request.getWorkingDaysInMonth());
            timePass.setYearMonth(request.getYearMonth());
            timePass.setStatus(request.isStatus());
            timePass.setCreatedAt(request.getCreatedAt());
            timePass.setDeletedAt(request.getDeletedAt());
            timePass.setUpdatedAt(request.getUpdatedAt());
            timePass.setBrowser(request.getBrowser());
            timePass.setIp(request.getIp());

            repository.save(timePass);
        } else {
            throw new ResourceNotFoundException("TimePass", "id", id);
        }

        return result;
    }

    @Override
    public void deleteTimePass(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public TimePass getTimePassById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TimePass", "id", id));
    }

    @Override
    public List<TimePass> getAllTimePass() {
        return repository.findAll();
    }

    @Override
    public Optional<TimePass> timePassStatusChange(Integer id, TimePassRequest request) {
        Optional<TimePass> result = repository.findById(id);

        if (result.isPresent()) {
            TimePass timePass = result.get();

            timePass.setStatus(request.isStatus());
            repository.save(timePass);
        } else {
            throw new ResourceNotFoundException("TimePass", "id", id);
        }
        return result;
    }
}
