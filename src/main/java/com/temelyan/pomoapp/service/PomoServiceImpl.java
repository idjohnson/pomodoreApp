package com.temelyan.pomoapp.service;

import com.temelyan.pomoapp.model.Pomo;
import com.temelyan.pomoapp.repository.PomoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PomoServiceImpl implements PomoService {
    @Autowired
    PomoRepository pomoRepository;

    @Override
    public void add(Pomo pomo, int userId) {
        pomoRepository.save(pomo, userId);
    }
}
