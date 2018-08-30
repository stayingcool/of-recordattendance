package com.ca.attendancetracker.service;

import com.ca.attendancetracker.model.Attendance;
import com.ca.attendancetracker.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("attendanceService")
public class AttendanceServiceImpl implements AttendanceService {


    private AttendanceRepository attendanceRepository;

    @Override
    public Attendance createAttendance(Attendance attendance) {
        return attendanceRepository.createAttendance(attendance);
    }

    @Override
    public List<Attendance> getAttendance() {
        return attendanceRepository.getAttendance();
    }

    @Autowired
    public void setAttendanceRepository(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }
}
