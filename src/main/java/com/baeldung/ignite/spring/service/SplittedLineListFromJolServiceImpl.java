package com.baeldung.ignite.spring.service;

import com.baeldung.ignite.spring.converter.JolConverter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SplittedLineListFromJolServiceImpl implements SplittedLineListService {

    JolConverter jolConverter;

    @Override
    public List<String[]> getSplittedlineList(String filepath) {
        return jolConverter.readFromFile(filepath);
    }
}
