package com.example.demo.services;

import com.example.demo.dto.CountForm;
import com.example.demo.dto.TableDto;
import com.example.demo.entity.CustomJson;
import com.example.demo.entity.Table;
import com.example.demo.repository.TableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class TableServicesImpl implements TableServices {

    private final TableRepository tableRepository;

    @Override
    public TableDto addCounter(CountForm count) {
        Table table = searchCurrent(count.getId());
        if (table == null) {
            throw new NullPointerException("Данные не найдены");
        }
        CustomJson current = table.getCustomJsonEntity();
        int addCounter = current.getCurrent() + count.getAdd();
        save(table, addCounter, current);
        return new TableDto(addCounter);
    }

    private void save(Table table, int addCounter, CustomJson currentCustomJson) {
        currentCustomJson.setCurrent(addCounter);
        table.setCustomJsonEntity(currentCustomJson);
        tableRepository.save(table);
    }

    private Table searchCurrent(int id) {
        Table table = null;
        Optional<Table> optional = tableRepository.findById(id);
        if (optional.isPresent()) {
            table = optional.get();
        }
        return table;
    }
}
