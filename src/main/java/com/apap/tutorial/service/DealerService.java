package com.apap.tutorial.service;

import java.util.Optional;

import com.apap.tutorial.model.DealerModel;

/**
 * DealerService
 */
public interface DealerService {
    Optional<DealerModel> getDealerDetailById(Long id);

    DealerModel addDealer(DealerModel dealer);

    void deleteById(Long id);
}