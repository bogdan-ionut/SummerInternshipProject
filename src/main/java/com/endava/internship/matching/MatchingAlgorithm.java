package com.endava.internship.matching;

import com.endava.internship.dto.ReportedItemDTO;
import com.endava.internship.exception.ReportedItemNotFoundException;
import com.endava.internship.service.ReportedItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static com.endava.internship.util.ExceptionMessage.ITEM_MATCH_EXCEPTION;

/**
 * Class that contains methods used for matching objects
 */
@Component
public class MatchingAlgorithm {

    @Autowired
    private ReportedItemService reportedItemService;

    /**
     * Method used for getting the matching scores of every objects from a given list of ReportedItemDTO objects which might be possible matches
     *
     * @param reportedItem - ReportedItemDTO object which is to be matched against all items from the database
     * @return - a collection of ReportedItemDTO with their corresponding scores
     * @throws ReportedItemNotFoundException thrown by the retrievePossibleItems method
     */
    public HashMap<ReportedItemDTO, Float> getMatchingScore(ReportedItemDTO reportedItem) throws ReportedItemNotFoundException {
        List<ReportedItemDTO> retrievedItems = retrievePossibleItems(reportedItem);
        HashMap<ReportedItemDTO, Float> matchedItems = new HashMap<>();
        float score = 0;
        for (ReportedItemDTO retrievedItem : retrievedItems) {
            if (colourMatches(retrievedItem, reportedItem)) {
                score += 50;
            }
            if (locationMatches(retrievedItem, reportedItem)) {
                score += 15;
            }
            score += descriptionMatch(retrievedItem.getItemDetails().getGeneralDescription(), reportedItem.getItemDetails().getGeneralDescription());
            if (score > 20) {
                matchedItems.put(retrievedItem, score);
            }
            score = 0;
        }
        return matchedItems;
    }

    /**
     * Method that retrieves only the items that match by category, status(LOST/FOUND/etc) and date
     *
     * @param reportedItem the item(LOST/FOUND/STOLEN) to be matched against all the other ReportedItems from the database
     * @return a list of ReportedItemDTO objects which match the criteria
     * @throws ReportedItemNotFoundException in case the Status or Category name are not found
     */
    private List<ReportedItemDTO> retrievePossibleItems(ReportedItemDTO reportedItem) throws ReportedItemNotFoundException {
        List<ReportedItemDTO> retrievedItemsTemp = reportedItemService.findByStatusAndCategoryName(reportedItem.getStatus(), reportedItem.getCategory().getName());
        List<ReportedItemDTO> retrievedItems = new ArrayList<>();
        for (ReportedItemDTO retrievedItem : retrievedItemsTemp) {
            if (compareDates(retrievedItem, reportedItem, reportedItem.getStatus()) < 0) {
                retrievedItems.add(retrievedItem);
            }
        }
        return retrievedItems;
    }

    /**
     * Method used for Date validation, according to the Status(LOST/FOUND/STOLEN) of the ReportedItem
     * The eventDate of the found item must be later than the reportedDate of the lost item
     *
     * @param firstItem  - ReportedItem object
     * @param secondItem - ReportedItem object
     * @param objectType - the status of the ReportedItem
     * @return toReturn - int variable which is set to -1 in case the date constraint is respected or 1 in case it is not
     * @throws ReportedItemNotFoundException when the status type is MATCHED or ERROR
     */
    private int compareDates(ReportedItemDTO firstItem, ReportedItemDTO secondItem, String objectType) throws ReportedItemNotFoundException {
        int toReturn;
        switch (objectType) {
            case "FOUND":
                toReturn = (firstItem.getReportedDate().compareTo(secondItem.getItemDetails().getEventDate()) < 0) ? -1 : 1;
                break;
            case "LOST":
            case "STOLEN":
                toReturn = (secondItem.getReportedDate().compareTo(firstItem.getItemDetails().getEventDate()) < 0) ? -1 : 1;
                break;
            default:
                throw new ReportedItemNotFoundException(ITEM_MATCH_EXCEPTION);
        }
        return toReturn;
    }

    /**
     * Method used for comparing two strings corresponding to the color attribute of the ReportedItemDTO objects
     *
     * @param retrievedItem - ReportedItemDTO object to be compared
     * @param reportedItem  - ReportedItemDTO object to be compared
     * @return true if the color are the same or false if they are not the same
     */
    private boolean colourMatches(ReportedItemDTO retrievedItem, ReportedItemDTO reportedItem) {
        return retrievedItem.getItemDetails().getColour().equals(reportedItem.getItemDetails().getColour());
    }

    /**
     * Method used for comparing two strings corresponding to the location attribute of the ReportedItemDTO objects
     *
     * @param retrievedItem - ReportedItemDTO object to be compared
     * @param reportedItem  - ReportedItemDTO object to be compared
     * @return true if the locations are the same or false if they are not the same
     */
    private boolean locationMatches(ReportedItemDTO retrievedItem, ReportedItemDTO reportedItem) {
        return retrievedItem.getItemDetails().getLocation().equals(reportedItem.getItemDetails().getLocation());
    }

    /**
     * Method that retrieves the matching percentage of unique features between two reported items
     *
     * @param existingItemDescription - description of an already existing lost object from table
     * @param newItemDescription      - description of the newly entered found object
     * @return percentage - percentage between 0 - 35 % (0% meaning no matching at all and 35% meaning a perfect match)
     */
    private float descriptionMatch(String existingItemDescription, String newItemDescription) {
        if (null == existingItemDescription || null == newItemDescription) {
            return 0F;
        }
        List<String> lostItemDescription = Arrays.asList(existingItemDescription.toLowerCase().split(" "));
        List<String> foundItemDescription = Arrays.asList(newItemDescription.toLowerCase().split(" "));
        int counter = 0;
        for (String require : lostItemDescription) {
            if (foundItemDescription.contains(require)) {
                counter++;
            }
        }
        return counter / (float) lostItemDescription.size() * 35;
    }
}
