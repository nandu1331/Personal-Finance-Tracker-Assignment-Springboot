package com.java_backend.Finance_Tracker_Java_Springboot.controller;

import com.java_backend.Finance_Tracker_Java_Springboot.dto.EntryDto;
import com.java_backend.Finance_Tracker_Java_Springboot.dto.SummaryDto;
import com.java_backend.Finance_Tracker_Java_Springboot.Service.EntryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Finance Entry API", description = "APIs for tracking income and expenses")
public class EntryController {

    @Autowired
    private EntryService entryService;

    // Create a new entry
    @Operation(summary = "Create a new income/expense entry")
    @PostMapping("/entries")
    public ResponseEntity<EntryDto> createEntry(@Valid @RequestBody EntryDto entryDto) {
        EntryDto created = entryService.createEntry(entryDto);
        return ResponseEntity.ok(created);
    }

    // Get all entries with optional filters
    @Operation(summary = "Get all entries with optional filtering")
    @GetMapping("/entries")
    public ResponseEntity<List<EntryDto>> getEntries(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        List<EntryDto> entries = entryService.getEntries(category, type, startDate, endDate);
        return ResponseEntity.ok(entries);
    }

    // Get a single entry by ID
    @Operation(summary = "Get an entry by ID")
    @GetMapping("/entries/{id}")
    public ResponseEntity<EntryDto> getEntryById(@PathVariable Long id) {
        EntryDto entryDto = entryService.getEntryById(id);
        return ResponseEntity.ok(entryDto);
    }

    // Update an entry
    @Operation(summary = "Update an existing entry")
    @PutMapping("/entries/{id}")
    public ResponseEntity<EntryDto> updateEntry(@PathVariable Long id, @Valid @RequestBody EntryDto entryDto) {
        EntryDto updated = entryService.updateEntry(id, entryDto);
        return ResponseEntity.ok(updated);
    }

    // Delete an entry
    @Operation(summary = "Delete an entry")
    @DeleteMapping("/entries/{id}")
    public ResponseEntity<Void> deleteEntry(@PathVariable Long id) {
        entryService.deleteEntry(id);
        return ResponseEntity.noContent().build();
    }


}
