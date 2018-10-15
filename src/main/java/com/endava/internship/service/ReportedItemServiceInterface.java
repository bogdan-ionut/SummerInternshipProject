package com.endava.internship.service;

import com.endava.internship.dto.ReportedItemDTO;
import com.endava.internship.exception.ReportedItemNotFoundException;
import com.endava.internship.exception.ReportedItemsNotFoundException;

import java.util.List;

/**
 * Interface used to abstract the implementation. It provides methods for:
 * -delete ReportedItem
 * - find one ReportedItem
 */
public interface ReportedItemServiceInterface {
    /**
     * Delete ReportedItem
     *
     * @param id id of the ReportedItem to be deleted
     * @throws ReportedItemNotFoundException when the ReportedItem could not be found.
     */
    void deleteItem(Long id) throws ReportedItemNotFoundException;

    /**
     * Method that uses the ReportedItemDataService to retrieve an object of type ReportedItemDTO with a specific id
     *
     * @param id - id of the ReportedItemDTO object to be found
     * @return ReportedItemDTO object
     * @throws ReportedItemNotFoundException when the ReportedItem is not found
     */
    ReportedItemDTO findById(Long id) throws ReportedItemNotFoundException;

    List<ReportedItemDTO> findByCategoryName(String name) throws ReportedItemsNotFoundException;
}
