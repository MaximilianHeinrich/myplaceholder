package dev.maximilian.backend.data.model.administration;

import org.springframework.web.multipart.MultipartFile;

public record FileUploadResponse(
        MultipartFile file,
        String name
) {
}
