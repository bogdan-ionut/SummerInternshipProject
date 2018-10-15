package com.endava.internship.service;

import com.endava.internship.dataservice.ItemMatchDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service for ItemMatch used for processing ItemMatch
 */
@Service
public class ItemMatchService implements ItemMatchServiceInterface{
    @Autowired
    private ItemMatchDataService dataService;

}

