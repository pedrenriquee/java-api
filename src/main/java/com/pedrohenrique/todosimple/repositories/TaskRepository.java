package com.pedrohenrique.todosimple.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pedrohenrique.todosimple.models.Task;

@Repository
public interface TaskRepository  extends JpaRepository<Task, Long>{
    
 
    List<Task> findByUser_id(Long id);  


    //não funciounou porem há essa maneira tambem
    // @Query (value = "SELECT t FROM Task t WHERE t.User.id = :id ")
    // List<Task> findByUser_Id(@Param "id" Long id); 


    //tambem não funicou porem ha essa maneira em fazer tambem 
    // @Query (value = "SELECT * FROM task t WHERE t.user_id = :id", nativeQuery = true)
    // List<Task> findByUser_Id(@Param "id" Long id); 

}
