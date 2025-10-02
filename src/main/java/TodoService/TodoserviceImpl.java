package TodoService;

import Model.Todo;
import TodoRepository.TodoRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service

 public class TodoServiceImpl implements TodoService {

  private final TodoRepository todoRepository;

  public TodoServiceImpl(TodoRepository todoRepository) {
   this.todoRepository = todoRepository;
  }

 @Override
  public void save(Todo todo) {
   todoRepository.save(todo);
  }

  @Override
  public void changeComplete(Todo todo, boolean complete) {
   todo.setCompleted(complete);
   todoRepository.save(todo);
  }

  @Override
  public Todo findById(Integer id) {
   return todoRepository.findById(id)
           .orElseThrow(()-> new NotFoundException("not.found"));
  }

 @Override
  public Page<Todo> findAll(Pageable pageable) {
   return todoRepository.findAll(pageable);
  }

  @Override
  public void deleteTodoById(Integer id) {
   todoRepository.deleteById(id);
  }
 }



