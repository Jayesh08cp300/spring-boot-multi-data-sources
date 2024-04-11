package com.example.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class TransactionManagerConfig {

	@Bean
	public ChainedTransactionManager chainedTransactionManager(
			@Qualifier("cardHolderTransactionManager") PlatformTransactionManager cardTransactionManager,
			@Qualifier("cardHolderTransactionManager") PlatformTransactionManager cardHolderTransactionManager,
			@Qualifier("memberTransactionManager") PlatformTransactionManager memberTransactionManager) {
		return new ChainedTransactionManager(cardTransactionManager, cardHolderTransactionManager, memberTransactionManager);
	}
}
