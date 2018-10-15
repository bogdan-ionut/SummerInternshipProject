package com.endava.internship.dataservice;

import com.endava.internship.convertor.EntityToDto.ToDtoReportedItemConverter;
import com.endava.internship.domain.ReportedItem;
import com.endava.internship.dto.ReportedItemDTO;
import com.endava.internship.exception.ReportedItemNotFoundException;
import com.endava.internship.exception.ReportedItemsNotFoundException;
import com.endava.internship.repository.ReportedItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.endava.internship.util.ExceptionMessage.CATEGORY_NAME_NULL_EXCEPTION;
import static com.endava.internship.util.ExceptionMessage.ITEM_NOT_FOUND_EXCEPTION;

/**
 * Class used for accessing data from repository
 */
@Service
public class ReportedItemDataService implements ReportedItemDataServiceInterface {

    @Autowired
    private ReportedItemRepository reportedItemRepository;

    @Autowired
    private ToDtoReportedItemConverter toDtoReportedItemConverter;

    /**
     * Removes an ReportedItem
     *
     * @param id - id of the ReportedItem
     */
    public void deleteItem(Long id) throws ReportedItemNotFoundException {
        try {
            reportedItemRepository.deleteById(id);
        } catch (EmptyResultDataAccessException exception) {
            throw new ReportedItemNotFoundException(ITEM_NOT_FOUND_EXCEPTION);
        }
    }

    /**
     * Method used for retrieving an object of type ReportedItem from the repository, converting it into a
     * ReportedItemDTO object and returning that ReportedItemDTO object
     *
     * @param id - id of the ReportedItem to be retrieved
     * @return ReportedItemDTO object converted from the ReportedItem object
     * @throws ReportedItemNotFoundException when the ReportedItem with the given id could not be found
     */
    @Override
    public ReportedItemDTO findById(Long id) throws ReportedItemNotFoundException {
        if (null == id) {
            throw new ReportedItemNotFoundException(ITEM_NOT_FOUND_EXCEPTION);
        }
        Optional<ReportedItem> reportedItem = reportedItemRepository.findById(id);
        if (reportedItem.isPresent()) {
            return toDtoReportedItemConverter.convert(reportedItem.get());
        } else {
            throw new ReportedItemNotFoundException(ITEM_NOT_FOUND_EXCEPTION);
        }
    }

    public List<ReportedItemDTO> findByCategoryName(String name) throws ReportedItemsNotFoundException {
        if (null == name) {
            throw new ReportedItemsNotFoundException(CATEGORY_NAME_NULL_EXCEPTION);
        }
        return toDtoReportedItemConverter.convertList(reportedItemRepository.findByCategoryName(name));
    }
}
