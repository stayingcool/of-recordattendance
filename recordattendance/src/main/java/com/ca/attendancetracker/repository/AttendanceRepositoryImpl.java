package com.ca.attendancetracker.repository;

import com.ca.attendancetracker.model.Attendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository("attendanceRepository")
public class AttendanceRepositoryImpl implements AttendanceRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Attendance createAttendance(Attendance attendance) {
        try {
            jdbcTemplate.update("insert into sessions (id, name, userid) values (?,?,?)",
                    attendance.getId(), attendance.getName(), attendance.getUserid());
        } catch (DataAccessException e) {
            System.out.println("SQL Exception Occurred :-(  : " + e.getMessage());
            return null;
        }
        return attendance;
    }


    @Override
    public List<Attendance> getAttendance() {
        Attendance attendance = new Attendance();
        attendance.setName("Corner Canyon");
        attendance.setId("TestID");
        attendance.setUserid("ahmni01");
        List<Attendance> attendances = new ArrayList<>();
        attendances.add(attendance);
        return attendances;
    }

}
