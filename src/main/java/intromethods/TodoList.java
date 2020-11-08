package intromethods;

import java.util.ArrayList;
import java.util.List;

public class TodoList {

    private List<Todo> todos= new ArrayList<>(); ///

    @Override
    public String toString() {
        return todos.toString();
    }

    public void addTodo(String caption){
        Todo newTodo= new Todo(caption);
        todos.add(newTodo);///
    }
    public void finishTodos(String caption){////
        for (Todo todo: todos) {
            if(todo.getCaption().equals(caption)){
                todo.finish();
            }
        }

    }
    public void finishMoreTodos(List<String> todosToFinish){///
        for(String finTodo: todosToFinish){
            finishTodos(finTodo);
        }

    }
    public List<String> todosToFinish(){///
        List<String> todosToFinish = new ArrayList<>();
        for (Todo todo: todos) {
            if (!todo.isFinished()) {
                todosToFinish.add(todo.getCaption());
            }
        }
        return todosToFinish;
    }
    public int numberOfFinishedTodos(){ //
        int sum = 0;
        for (Todo todo: todos) {
            if (todo.isFinished()) {
                sum++;
            }
        }
        return sum;
    }


}
