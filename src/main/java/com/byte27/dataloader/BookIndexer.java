package com.byte27.dataloader;

import com.byte27.dataloader.books.Book;
import com.byte27.dataloader.books.BookRepository;
import com.byte27.dataloader.config.BookIndexerConfig;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

@Component
public class BookIndexer {
    private final BookIndexerConfig config;
    private final BookRepository repository;

    public BookIndexer(BookIndexerConfig config, BookRepository repository) {
        this.config = config;
        this.repository = repository;
    }

    public void index() {
        try (Reader in = new FileReader(config.getBooksCsvPath().getFile())) {
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.builder()
                    .setHeader().setSkipHeaderRecord(true)
                    .build()
                    .parse(in);

            for (CSVRecord csvRecord : records) {
                String title = csvRecord.get("title");
                Book book = new Book(title);

                if (!repository.existsByTitle(title)) {
                    repository.save(book);
                }
            }
        } catch (IOException e) {
            throw new BookIndexerException("Failed to index books", e);
        }
    }
}
