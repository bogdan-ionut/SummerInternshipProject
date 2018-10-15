package com.endava.internship.dataservice;

import com.endava.internship.repository.ItemMatchRepository;
import com.endava.internship.service.ItemMatchServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Class used for logic conversion between entities and dto
 * It is a cross-over layer between ItemMatch Service and Repository
 */
@Service
public class ItemMatchDataService implements ItemMatchServiceInterface {

    @Autowired
    private ItemMatchRepository itemMatchRepository;

}
