package com.endava.internship.dataservice;

import com.endava.internship.dto.ReportedItemDTO;
import com.endava.internship.exception.ReportedItemNotFoundException;
import com.endava.internship.exception.ReportedItemsNotFoundException;

import java.util.List;

/**
 * Interface used to abstract the implementation. It provides methods for:
 * -find ReportedItem by Id
 * -delete ReportedItem
 */
public interface ReportedItemDataServiceInterface {
    /**
     * Delete ReportedItem
     *
     * @param id id of the ReportedItem to be deleted
     * @throws ReportedItemNotFoundException when the ReportedItem could not be found.
     */
    void deleteItem(Long id) throws ReportedItemNotFoundException;

    /**
     * Method used for retrieving an object of type ReportedItem from the repository, converting it into a
     * ReportedItemDTO object and returning that ReportedItemDTO object
     *
     * @param id - id of the ReportedItem to be retrieved
     * @return ReportedItemDTO object converted from the ReportedItem object
     * @throws ReportedItemNotFoundException when the ReportedItem with the given id could not be found
     */
    ReportedItemDTO findById(Long id) throws ReportedItemNotFoundException;

    List<ReportedItemDTO> findByCategoryName(String name) throws ReportedItemsNotFoundException;
}
