package com.ca.attendancetracker.repository;

import com.ca.attendancetracker.model.Attendance;

import java.util.List;

public interface AttendanceRepository {

    Attendance createAttendance(Attendance attendance);

    List<Attendance> getAttendance();

}


