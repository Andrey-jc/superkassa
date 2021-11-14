package com.example.demo.Controller;

import com.example.demo.DTO.CountForm;
import com.example.demo.DTO.TableDto;
import com.example.demo.services.TableServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class Controller {

    private final TableServices tableServices;

    @ResponseStatus(value =  HttpStatus.I_AM_A_TEAPOT)
    @PostMapping("/modify")
    public TableDto addCurrent(@RequestBody CountForm countForm) {
        return tableServices.addCounter(countForm);
    }
}
