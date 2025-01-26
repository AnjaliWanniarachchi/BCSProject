package com.bcs.project.stpauls.service;

import com.bcs.project.stpauls.model.Batch;
import com.bcs.project.stpauls.repository.BatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BatchService {

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
        return batchRepository.findById(id);
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
