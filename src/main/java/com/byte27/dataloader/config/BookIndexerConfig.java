package com.byte27.dataloader.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.core.io.Resource;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@ConfigurationProperties(prefix = "indexer")
@ConstructorBinding
@Validated
public class BookIndexerConfig {
    @NotNull
    private final Resource booksCsvPath;

    public BookIndexerConfig(Resource booksCsvPath) {
        this.booksCsvPath = booksCsvPath;
    }

    public Resource getBooksCsvPath() {
        return booksCsvPath;
    }
}
