package com.openfaas.function;

import com.openfaas.model.IResponse;
import com.openfaas.model.IRequest;
import com.openfaas.model.Response;
import com.ca.attendancetracker.Application;

public class Handler implements com.openfaas.model.IHandler {

    public IResponse Handle(IRequest req) {
        Response res = new Response();
        Application app = new Application();

        if (app.run(req))
            res.setStatusCode(200);
        else
            res.setStatusCode(400);

        return res;
    }
}