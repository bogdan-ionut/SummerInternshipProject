package com.endava.internship.service;

import com.endava.internship.dataservice.ReportedItemDataService;
import com.endava.internship.dto.ReportedItemDTO;
import com.endava.internship.exception.ReportedItemNotFoundException;
import com.endava.internship.exception.ReportedItemsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service used for processing ReportedItem objects.
 */
@Service
public class ReportedItemService implements ReportedItemServiceInterface {

    @Autowired
    private ReportedItemDataService reportedItemDataService;

    /**
     * Removes a ReportedItem
     *
     * @param id - id of the ReportedItem
     */
    public void deleteItem(Long id) throws ReportedItemNotFoundException {
        reportedItemDataService.deleteItem(id);
    }

    /**
     * Method that uses the ReportedItemDataService to retrieve an object of type ReportedItemDTO with a specific id
     *
     * @param id - id of the ReportedItemDTO object to be found
     * @return ReportedItemDTO object
     * @throws ReportedItemNotFoundException when the ReportedItem is not found
     */
    public ReportedItemDTO findById(Long id) throws ReportedItemNotFoundException {
        return reportedItemDataService.findById(id);
    }


    public List<ReportedItemDTO> findByCategoryName(String name) throws ReportedItemsNotFoundException {
        return reportedItemDataService.findByCategoryName(name);
    }
}