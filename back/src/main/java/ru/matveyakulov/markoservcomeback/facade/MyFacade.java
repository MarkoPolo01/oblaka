package ru.matveyakulov.markoservcomeback.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.matveyakulov.markoservcomeback.domain.Request;
import ru.matveyakulov.markoservcomeback.dto.TranslateResponseDto;
import ru.matveyakulov.markoservcomeback.dto.yandex.languages.LanguageResponse;
import ru.matveyakulov.markoservcomeback.service.ExcelHelper;
import ru.matveyakulov.markoservcomeback.service.S3Service;
import ru.matveyakulov.markoservcomeback.service.TranslateService;
import ru.matveyakulov.markoservcomeback.utils.Constant;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MyFacade {

    private final S3Service s3Service;
    private final TranslateService translateService;

    public TranslateResponseDto translate(String text, String targetLanguageCode) {
        s3Service.getFile();
        String sourceLanguageCode = translateService.getLanguageCode(text);
        String translatedText = translateService.translate(text, targetLanguageCode, sourceLanguageCode);
        String path = ExcelHelper.write(Request.builder()
                .sourceText(text)
                .sourceLanguageCode(sourceLanguageCode)
                .targetLanguageCode(targetLanguageCode)
                .translatedText(translatedText)
                .build());
        s3Service.uploadFile(path);
        return new TranslateResponseDto(translatedText);
    }

    public List<LanguageResponse.LanguageDto> getLanguages() {
        return translateService.getLanguages();
    }

    public List<Request> getRequests() {
        s3Service.getFile();
        return ExcelHelper.read(Constant.EXCEL_FILE_NAME);
    }
}
