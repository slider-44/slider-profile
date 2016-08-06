package com.acsp.merchant.bank.save.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.jooq.ConnectionProvider;
import org.jooq.DSLContext;
import org.jooq.ExecuteListenerProvider;
import org.jooq.SQLDialect;
import org.jooq.TransactionProvider;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.impl.DefaultExecuteListenerProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan
public class DataSourceConfig {

  @Value("${spring.datasource.username}")
  private String user;

  @Value("${spring.datasource.password}")
  private String password;

  @Value("${spring.datasource.url}")
  private String dataSourceUrl;

  @Value("${spring.datasource.dataSourceClassName}")
  private String dataSourceClassName;

  @Value("${spring.datasource.poolName}")
  private String poolName;

  @Value("${spring.datasource.connectionTimeout}")
  private int connectionTimeout;

  @Value("${spring.datasource.maxLifetime}")
  private int maxLifetime;

  @Value("${spring.datasource.maximumPoolSize}")
  private int maximumPoolSize;

  @Value("${spring.datasource.minimumIdle}")
  private int minimumIdle;

  @Value("${spring.datasource.idleTimeout}")
  private int idleTimeout;

  @Bean
  public DataSource primaryDataSource() {

    Properties dsProps = new Properties();
    dsProps.put("url", dataSourceUrl);
    dsProps.put("user", user);
    dsProps.put("password", password);

    // dsProps.put("prepStmtCacheSize",250);
    // dsProps.put("prepStmtCacheSqlLimit",2048);
    // dsProps.put("cachePrepStmts",Boolean.TRUE);
    // dsProps.put("useServerPrepStmts",Boolean.TRUE);

    Properties configProps = new Properties();
    configProps.put("dataSourceClassName", dataSourceClassName);
    configProps.put("poolName", poolName);
    configProps.put("maximumPoolSize", maximumPoolSize);
    configProps.put("minimumIdle", minimumIdle);
    configProps.put("minimumIdle", minimumIdle);
    configProps.put("connectionTimeout", connectionTimeout);
    configProps.put("idleTimeout", idleTimeout);
    configProps.put("dataSourceProperties", dsProps);

    HikariConfig hc = new HikariConfig(configProps);
    HikariDataSource ds = new HikariDataSource(hc);
    ds.addDataSourceProperty("cachePrepStmts", true);
    ds.addDataSourceProperty("prepStmtCacheSize", 250);
    ds.addDataSourceProperty("prepStmtCacheSqlLimit", 2048);
    ds.addDataSourceProperty("useServerPrepStmts", true);

    return ds;
  }

  @Bean
  public DataSourceTransactionManager transactionManager(DataSource dataSource) {

    return new DataSourceTransactionManager(dataSource);
  }

  @Bean
  public DSLContext dsl(org.jooq.Configuration config) {

    return new DefaultDSLContext(config);
  }

  @Bean
  public ConnectionProvider connectionProvider(DataSource dataSource) {

    return new DataSourceConnectionProvider(new TransactionAwareDataSourceProxy(dataSource));
  }

  @Bean
  public TransactionProvider transactionProvider() {

    return new SpringTransactionProvider();
  }

  @Bean
  public ExceptionTranslator exceptionTranslator() {

    return new ExceptionTranslator();
  }

  @Bean
  public ExecuteListenerProvider executeListenerProvider(ExceptionTranslator exceptionTranslator) {

    return new DefaultExecuteListenerProvider(exceptionTranslator);
  }

  @Bean
  public org.jooq.Configuration jooqConfig(ConnectionProvider connectionProvider,
                                           TransactionProvider transactionProvider,
                                           ExecuteListenerProvider executeListenerProvider) {

    return new DefaultConfiguration()
                                     .derive(connectionProvider)
                                     .derive(transactionProvider)
                                     .derive(executeListenerProvider)
                                     .derive(SQLDialect.ORACLE11G);
  }

}
