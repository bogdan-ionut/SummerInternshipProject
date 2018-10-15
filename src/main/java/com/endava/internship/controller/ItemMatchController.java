package com.endava.internship.controller;


import com.endava.internship.service.ItemMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for ItemMatch.
 * Possible operations: expose matching functionality, retrieve all matched objects
 */
@RestController
public class ItemMatchController {
    @Autowired
    private ItemMatchService service;

}
