package br.com.mateus.taskorganizer.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.mateus.taskorganizer.application.gateways.TaskRepository;
import br.com.mateus.taskorganizer.application.usecases.task.ReadAllTasksByUserId;
import br.com.mateus.taskorganizer.application.usecases.task.ReadTaskByIdAndUserId;
import br.com.mateus.taskorganizer.application.usecases.task.RemoveTaskByIdAndUserId;
import br.com.mateus.taskorganizer.application.usecases.task.SaveTask;
import br.com.mateus.taskorganizer.application.usecases.task.UpdateTask;
import br.com.mateus.taskorganizer.infra.gateways.task.TaskEntityMapper;
import br.com.mateus.taskorganizer.infra.gateways.task.TaskRepositoryImplMongoDB;
import br.com.mateus.taskorganizer.infra.persistence.task.TaskRepositoryMongoDB;

@Configuration
public class TaskPersistenceConfig {

    @Bean
    TaskEntityMapper getTaskEntityMapper() {
        return new TaskEntityMapper();
    }

    @Bean
    TaskRepository getTaskRepository(TaskRepositoryMongoDB repository, TaskEntityMapper entityMapper) {
        return new TaskRepositoryImplMongoDB(repository, entityMapper);
    }

    @Bean
    SaveTask createTask(TaskRepository repository) {
        return new SaveTask(repository);
    }

    @Bean
    ReadAllTasksByUserId readAllTaskByUserId(TaskRepository repository) {
        return new ReadAllTasksByUserId(repository);
    }

    @Bean
    ReadTaskByIdAndUserId readTaskByIdAndUserId(TaskRepository repository) {
        return new ReadTaskByIdAndUserId(repository);
    }
    
    @Bean
    RemoveTaskByIdAndUserId removeTaskByIdAndUserId(TaskRepository repository) {
        return new RemoveTaskByIdAndUserId(repository);
    }
    
    @Bean
    UpdateTask updateTask(TaskRepository repository) {
        return new UpdateTask(repository);
    }
}