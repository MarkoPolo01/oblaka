package ru.matveyakulov.markoservcomeback.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.matveyakulov.markoservcomeback.domain.Request;
import ru.matveyakulov.markoservcomeback.dto.TranslateResponseDto;
import ru.matveyakulov.markoservcomeback.dto.yandex.languages.LanguageResponse;
import ru.matveyakulov.markoservcomeback.facade.MyFacade;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping
@RequiredArgsConstructor
public class MyController {

    private final MyFacade facade;

    @GetMapping("/translate")
    public TranslateResponseDto translate(@RequestParam String text, @RequestParam String targetLanguageCode) {
        return facade.translate(text, targetLanguageCode);
    }

    @GetMapping("/languages")
    public List<LanguageResponse.LanguageDto> getLanguages() {
        return facade.getLanguages();
    }

    @GetMapping("/requests")
    public List<Request> getRequests() {
        return facade.getRequests();
    }

}
