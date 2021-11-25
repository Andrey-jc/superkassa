package com.example.demo.controller;

import com.example.demo.dto.CountForm;
import com.example.demo.dto.TableDto;
import com.example.demo.services.TableServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final TableServices tableServices;

    @ResponseStatus(value =  HttpStatus.I_AM_A_TEAPOT)
    @PostMapping("/modify")
    public TableDto addCurrent(@RequestBody CountForm countForm) {
        return tableServices.addCounter(countForm);
    }
}
