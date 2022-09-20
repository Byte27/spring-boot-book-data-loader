package com.byte27.dataloader;

import com.byte27.dataloader.config.BookIndexerConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(BookIndexerConfig.class)
public class SpringBootBookDataLoaderApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBookDataLoaderApplication.class, args);
	}

	private final BookIndexer bookIndexer;

	public SpringBootBookDataLoaderApplication(BookIndexer bookIndexer) {
		this.bookIndexer = bookIndexer;
	}

	@Override
	public void run(String... args) {
		bookIndexer.index();
	}
}
