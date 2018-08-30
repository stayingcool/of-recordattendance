package com.ca.attendancetracker;

import com.ca.attendancetracker.model.Attendance;
import com.ca.attendancetracker.service.AttendanceService;
import com.google.gson.Gson;
import com.openfaas.model.IRequest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    boolean status;

    public boolean run(IRequest req) {
        Gson gson = new Gson();
        ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:jdbc-config.xml");

        AttendanceService service = appContext.getBean("attendanceService", AttendanceService.class);

        Attendance attendance = gson.fromJson(req.getBody(), Attendance.class);

        try {
            if (service.createAttendance(attendance) != null) {
                System.out.println("Success: Completed adding attendance!");
                return status = true;
            } else {
                System.out.println("Failed: Failed to add attendance!");
                return status = false;
            }
        } catch (Exception e) {
            System.out.println("Exception Occurred :-(  : " + e.getMessage());
            return status = false;
        }
    }
}
