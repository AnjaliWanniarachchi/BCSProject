package com.bcs.project.stpauls.service;

import com.bcs.project.stpauls.model.Batch;
import com.bcs.project.stpauls.repository.BatchRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BatchService {

    private static final Log log = LogFactory.getLog(BatchService.class);
    @Autowired
    private BatchRepository batchRepository;

    // Create or Update batch
    public Batch saveOrUpdateBatch(Batch batch) {
        return batchRepository.save(batch);
    }

    // Get all batches
    public List<Batch> getAllBatches() {
        return batchRepository.findAll();
    }

    // Get batch by ID
    public Optional<Batch> getBatchById(Long id) {
        if (id == null || id == 0) {
            throw new IllegalArgumentException("Invalid ID provided.");
        }
        System.out.println("trying to get batch with ID: " + id);
        Optional<Batch> batch = batchRepository.findById(id);
        System.out.println("Batch object" + batch);
        if (!batch.isPresent()) {
            return Optional.empty();  // Or throw a custom exception
        }
        return batch;
    }

    public Batch addBatch(Batch batch) {
        if (batch.getBatch_id() != null && batchRepository.existsById(batch.getBatch_id())) {
            throw new IllegalArgumentException("Batch with ID already exists");
        }
        return batchRepository.save(batch);
    }

    // Delete batch by ID
    public void deleteBatch(Long id) {
        batchRepository.deleteById(id);
    }
}
