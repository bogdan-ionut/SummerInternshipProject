package com.endava.internship.controller;

import com.endava.internship.dto.ReportedItemDTO;
import com.endava.internship.exception.ReportedItemNotFoundException;
import com.endava.internship.service.ReportedItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;


/**
 * Controller for operations on ReportedItem objects.
 * Possible operations: Delete, Find by Id;
 */
@RestController
public class ReportedItemController {

    @Autowired
    private ReportedItemService reportedItemService;

    /**
     * Method that retrieves one ReportedItemDTO object
     *
     * @param id - id of the ReportedItemDTO object
     * @return Http Status Code 200 for successful retrieval
     * Http Status Code 404 in unsuccessful cases
     */
    @GetMapping(value = "/getItem/{id}", produces = "application/json")
    public ResponseEntity<ReportedItemDTO> getReportedItem(@PathVariable("id") Long id) {
        try {
            ReportedItemDTO reportedItemDTO = reportedItemService.findById(id);
            return new ResponseEntity<>(reportedItemDTO, OK);
        } catch (ReportedItemNotFoundException e) {
            return new ResponseEntity<>(NOT_FOUND);
        }
    }

    /**
     * Removes an ReportedItem.
     *
     * @param id - id of the ReportedItem to be deleted
     * @return HTTP.Status 200 if the remove was successful
     * HTTP.Status 404 if it can't find the ReportedItem
     */
    @RequestMapping(value = "/removeItem/{id}", method = DELETE)
    public ResponseEntity<Void> deleteItem(@PathVariable("id") Long id) {
        try {
            reportedItemService.deleteItem(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ReportedItemNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}