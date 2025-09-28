package dev.maximilian.backend.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class FileMapper {

    private final ObjectMapper objectMapper;

    public File convertMultipartFileToFile(MultipartFile multipartFile) throws IOException {
        var file = new File(System.getProperty("java.io.tmpdir") + File.separator + multipartFile.getOriginalFilename());
        multipartFile.transferTo(file);
        return file;
    }

    public <T> Map<String, T> readClassFromFile(File file, Class<T> entityType) throws IOException {
        return objectMapper.readValue(file, objectMapper.getTypeFactory().constructMapType(Map.class, String.class, entityType));
    }

}
