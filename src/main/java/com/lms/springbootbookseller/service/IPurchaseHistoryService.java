package com.lms.springbootbookseller.service;

import com.lms.springbootbookseller.model.PurchaseHistory;
import com.lms.springbootbookseller.repository.projection.IPurchaseItem;

import java.util.List;

public interface IPurchaseHistoryService {
    PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory);

    List<IPurchaseItem> findPurchaseItemsOfUser(Long userId);
}
