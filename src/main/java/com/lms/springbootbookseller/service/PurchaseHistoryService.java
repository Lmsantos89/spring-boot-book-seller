package com.lms.springbootbookseller.service;

import com.lms.springbootbookseller.model.PurchaseHistory;
import com.lms.springbootbookseller.repository.IPurchaseHistoryRepository;
import com.lms.springbootbookseller.repository.projection.IPurchaseItem;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.time.LocalDateTime.now;

@Service
public class PurchaseHistoryService implements IPurchaseHistoryService{


    private final IPurchaseHistoryRepository purchaseHistoryRepository;

    public PurchaseHistoryService(IPurchaseHistoryRepository purchaseHistoryRepository) {
        this.purchaseHistoryRepository = purchaseHistoryRepository;
    }

    @Override
    public PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory){
        purchaseHistory.setPurchaseTime(now());

        return purchaseHistoryRepository.save(purchaseHistory);
    }

    @Override
    public List<IPurchaseItem> findPurchaseItemsOfUser(Long userId) {
        return purchaseHistoryRepository.findAllPurchasesOfUser(userId);
    }

}
