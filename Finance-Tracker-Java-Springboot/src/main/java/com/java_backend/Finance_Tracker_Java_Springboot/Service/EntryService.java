package com.java_backend.Finance_Tracker_Java_Springboot.Service;

import com.java_backend.Finance_Tracker_Java_Springboot.dto.EntryDto;
import com.java_backend.Finance_Tracker_Java_Springboot.dto.SummaryDto;
import com.java_backend.Finance_Tracker_Java_Springboot.entity.Entry;
import com.java_backend.Finance_Tracker_Java_Springboot.entity.EntryType;
import com.java_backend.Finance_Tracker_Java_Springboot.Exception.ResourceNotFoundException;
import com.java_backend.Finance_Tracker_Java_Springboot.Repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntryService {

    @Autowired
    private EntryRepository entryRepository;

    // Create a new entry
    public EntryDto createEntry(EntryDto entryDto) {
        Entry entry = mapToEntity(entryDto);
        Entry saved = entryRepository.save(entry);
        return mapToDto(saved);
    }

    // Get entry by id
    public EntryDto getEntryById(Long id) {
        Entry entry = entryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Entry not found with id " + id));
        return mapToDto(entry);
    }

    // Get all entries with optional filters
    public List<EntryDto> getEntries(String category, String typeStr, LocalDate startDate, LocalDate endDate) {
        EntryType type = null;
        if (typeStr != null) {
            try {
                type = EntryType.valueOf(typeStr.toUpperCase());
            } catch (IllegalArgumentException ex) {
                throw new IllegalArgumentException("Invalid entry type: " + typeStr);
            }
        }
        List<Entry> entries = entryRepository.findByFilters(category, type, startDate, endDate);
        return entries.stream().map(this::mapToDto).collect(Collectors.toList());
    }


}
