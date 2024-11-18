@Configuration
class DataSources {
    @Bean("datasource_v1")
    @Qualifier("datasource_v1")
    @ConfigurationProperties(prefix = "postgres")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
}

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:envs/application.properties")
@EnableJpaRepositories(
    entityManagerFactoryRef = "entityManager_v1",
    transactionManagerRef = "tx_v1",
    basePackages = {
        "com.jpa.db1.repository"
    }
)
class DB1Config {
    @Autowired
    Environment env;

    @Bean("entityManager_v1")
    @Qualifier("entityManager_v1")
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManager_v1(
            EntityManagerFactoryBuilder factoryBuilder,
            @Qualifier("datasource_v1") DataSource ds) {
        return factoryBuilder.dataSource(ds)
                .packages(new String[]{"com.jpa.db1.entity"}).build();
    }

    @Bean("tx_v1")
    @Primary
    @Qualifier("tx_v1")
    public PlatformTransactionManager tx_v1(
            @Qualifier("entityManager_v1") LocalContainerEntityManagerFactoryBean emf) {
        var dts = new JpaTransactionManager(emf.getObject());
        return dts;
    }
}