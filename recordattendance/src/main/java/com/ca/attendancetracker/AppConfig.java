package com.ca.attendancetracker;

import com.ca.attendancetracker.repository.AttendanceRepositoryImpl;
import com.ca.attendancetracker.service.AttendanceService;
import com.ca.attendancetracker.service.AttendanceServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com"})
public class AppConfig {

    @Bean(name="attendanceService")
    public AttendanceService getAttendanceService(){
        AttendanceServiceImpl service = new AttendanceServiceImpl();
        service.setAttendanceRepository(getAttendanceRepository());
        return service;
    }

    @Bean(name="attendanceRepository")
    public AttendanceRepositoryImpl getAttendanceRepository(){
        return new AttendanceRepositoryImpl();
    }

}
