package com.example.demo.services;

import com.example.demo.dto.CountForm;
import com.example.demo.dto.TableDto;

public interface TableServices {
    TableDto addCounter(CountForm count);
}
