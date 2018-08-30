package com.ca.attendancetracker.service;

import com.ca.attendancetracker.model.Attendance;

import java.util.List;

public interface AttendanceService {
    Attendance createAttendance(Attendance attendance);

    List<Attendance> getAttendance();


}
