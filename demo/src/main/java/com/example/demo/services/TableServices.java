package com.example.demo.services;

import com.example.demo.DTO.CountForm;
import com.example.demo.DTO.TableDto;

public interface TableServices {
    TableDto addCounter(CountForm count);
}
