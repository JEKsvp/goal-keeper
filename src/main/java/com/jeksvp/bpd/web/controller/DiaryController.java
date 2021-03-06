package com.jeksvp.bpd.web.controller;

import com.jeksvp.bpd.service.DiaryService;
import com.jeksvp.bpd.web.dto.response.diary.DiaryResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users/{username}/diary")
public class DiaryController {

    private final DiaryService diaryService;

    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    @GetMapping
    public DiaryResponse getDiaryById(@PathVariable String username) {
        return diaryService.getDiaryByUsername(username);
    }
}
