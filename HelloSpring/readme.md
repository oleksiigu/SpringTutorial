# Java Spring Tutorial
This tutorial consists of the set of lessons that demonstrate different Spring framework features.
Each lesson contains minimal simple code to understand some separated Spring feature. 
Below you can find the list of the lessons included into this tutorial which highlights 
annotations, interfaces, classes, methods used in each lesson. 
New terms are marked with bold.

## Lessons
### Lesson-001-Hello
Basic Java Spring application that introduces Spring 
and writes simple "Hello World" to console using Spring bean

##### Annotations:
**`@Configuration, @ComponentScan, @Component`**

##### Interfaces & Classes:
**`ApplicationContext, AnnotationConfigApplicationContext`**

##### Methods:
**`ApplicationContext.getBean`**

### Lesson-002-DI
Demonstrates dependency injection and beans lifecycle handlers

##### Annotations:
**`@Autowired, @PostConstruct, @PreDestroy,`**
`@Configuration, @ComponentScan, @Component` 

##### Interfaces & Classes: 
**`AbstractApplicationContext,`**
`AnnotationConfigApplicationContext`

##### Methods:
**`AbstractApplicationContext.getBeanDefinitionNames`**

### Lesson-003-DI-Interfaces
Demonstrates dependency injection using interfaces

##### Annotations:
`@Autowired, @PostConstruct, @Configuration, @ComponentScan, @Component` 

##### Interfaces & Classes: 
`AbstractApplicationContext, AnnotationConfigApplicationContext`

##### Methods:
`AbstractApplicationContext.getBeanDefinitionNames`

### Lesson-004-DI-Collections
Demonstrates dependency injection of beans collections

##### Annotations:
`@Autowired, @PostConstruct, @Configuration, @ComponentScan, @Component` 

##### Interfaces & Classes: 
`AbstractApplicationContext, AnnotationConfigApplicationContext`

##### Methods:
`AbstractApplicationContext.getBeanDefinitionNames`

### Lesson-005-Scheduling
Demonstrates using timers in Spring application and graceful shutdown

##### Annotations:
**`
@EnableScheduling, @Scheduled, @Bean,
`**
`@Autowired, @PostConstruct, @PreDestroy, @Configuration, @ComponentScan, @Component` 

##### Interfaces & Classes: 
**`ThreadPoolTaskScheduler,`**
`AbstractApplicationContext, AnnotationConfigApplicationContext`

##### Methods:
**`
ThreadPoolTaskScheduler.setPoolSize,
ThreadPoolTaskScheduler.setThreadNamePrefix,
ThreadPoolTaskScheduler.setWaitForTasksToCompleteOnShutdown,
ThreadPoolTaskScheduler.setAwaitTerminationSeconds,
`**
`AbstractApplicationContext.getBeanDefinitionNames`

### Lesson-006-Async
Demonstrates how to use asynchronous methods execution in Spring application and graceful shutdown

##### Annotations:
**`@EnableAsync, @Async,`**
`@Bean, @Autowired, @PostConstruct, @PreDestroy, @Configuration, @ComponentScan, @Component`

##### Interfaces & Classes: 
**`
ThreadPoolTaskExecutor, Consumer,
`**
`AbstractApplicationContext, AnnotationConfigApplicationContext`

##### Methods:
**`
ThreadPoolTaskExecutor.setCorePoolSize,
ThreadPoolTaskExecutor.setMaxPoolSize,
ThreadPoolTaskExecutor.setQueueCapacity,
ThreadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown,
ThreadPoolTaskExecutor.setAwaitTerminationSeconds,
`**
`AbstractApplicationContext.getBeanDefinitionNames`


### Lesson-007-Events
Demonstrates how to use events in Spring application and graceful shutdown

##### Annotations:
**`@EventListener,`**
`@EnableAsync, @Async, @Bean, @Autowired, @PostConstruct, @PreDestroy, @Configuration, @ComponentScan, @Component`

##### Interfaces & Classes: 
**`
ApplicationEventPublisher,
`**
`ThreadPoolTaskExecutor, AbstractApplicationContext, AnnotationConfigApplicationContext`

##### Methods:
**`
ApplicationEventPublisher.publishEvent,
`**
`
ThreadPoolTaskExecutor.setCorePoolSize,
ThreadPoolTaskExecutor.setMaxPoolSize,
ThreadPoolTaskExecutor.setQueueCapacity,
ThreadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown,
ThreadPoolTaskExecutor.setAwaitTerminationSeconds,
AbstractApplicationContext.getBeanDefinitionNames
`

### Lesson-008-Cache
Demonstrates how to use Spring caching

##### Annotations:
**`@EnableCaching, @Cacheable, @CachePut, @CacheEvict`**
`@Bean, @Autowired, @Configuration, @ComponentScan, @Component`

##### Interfaces & Classes: 
**`
SimpleCacheManager, ConcurrentMapCache,
`**
`AbstractApplicationContext, AnnotationConfigApplicationContext`

##### Methods:
**`SimpleCacheManager.setCaches`**
`ApplicationContext.getBean`


### Lesson-009-JPA
Demonstrates how to access MySQL database using Spring Data without using Spring Boot.

In order to run this project you need MySQL database with full access configured in PersistenceConfig.java

##### Annotations:
**`
@EnableJpaRepositories,
@EnableTransactionManagement,
@Repository,
@Query,
@Entity,
@Id,
@GeneratedValue,
@Transactional,
`**
`@Bean, @Autowired, @Configuration, @ComponentScan, @Component`

##### Interfaces & Classes: 
**`
JpaRepository,
DataSource,
LocalContainerEntityManagerFactoryBean,
HibernateJpaVendorAdapter,
PlatformTransactionManager,
JpaTransactionManager,
`**
`AbstractApplicationContext, AnnotationConfigApplicationContext`

##### Methods:
**`
JpaRepository.save,
JpaRepository.deleteById,
JpaRepository.getOne,
JpaRepository.findAll,
LocalContainerEntityManagerFactoryBean.setDataSource,
LocalContainerEntityManagerFactoryBean.setPackagesToScan,
LocalContainerEntityManagerFactoryBean.setJpaVendorAdapter,
LocalContainerEntityManagerFactoryBean.setJpaProperties,
DriverManagerDataSource.setDriverClassName,
DriverManagerDataSource.setUrl,
DriverManagerDataSource.setUsername,
DriverManagerDataSource.setPassword,
JpaTransactionManager.setEntityManagerFactory,
`**
`ApplicationContext.getBean`

## References

https://examples.javacodegeeks.com/enterprise-java/spring/spring-framework-tutorial-beginners-examples/

https://www.tutorialspoint.com/spring/

https://www.baeldung.com/spring-tutorial
