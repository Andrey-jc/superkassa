package com.example.demo.services;

import com.example.demo.DTO.CountForm;
import com.example.demo.DTO.TableDto;
import com.example.demo.entity.Json;
import com.example.demo.entity.Table;
import com.example.demo.repository.TableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class TableServicesImpl implements TableServices {

    private final TableRepository tableRepository;

    private void save(Table table, int addCounter, Json currentJson) {
        currentJson.setCurrent(addCounter);
        table.setJsonEntity(currentJson);
        tableRepository.save(table);
    }

    @Override
//    для синхронизации потоков
    public synchronized TableDto addCounter(CountForm count) {
        Table table = tableRepository.getById(count.getId());
        Json current = table.getJsonEntity();
        int addCounter = current.getCurrent() + count.getAdd();
        save(table, addCounter, current);
        return new TableDto(addCounter);
    }
}
