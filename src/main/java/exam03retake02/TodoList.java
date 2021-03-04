package exam03retake02;

import java.util.ArrayList;
import java.util.List;

public class TodoList {
    /*
    Legyen egy TodoList osztály, mely több tennivalót tartalmaz! Egy List<Todo> attribútumban tartalmazza a tennivalókat.

Metódusai:

getNumberOfItemsLeft() - visszaadja a még el nem készült tennivalók számát
getMostImportantTodosText() - visszaadja a legyfontosabb tennivalókat. Nem feltétlen van 1-es prioritású.
deleteCompleted() - a listából kitörli az elvégzetteket

     */

    private List<Todo> todos= new ArrayList<>();

    public void addTodo(Todo todo) {
        todos.add(todo);
    }

    public List<Todo> getTodos() {
        return new ArrayList<>(todos);
    }

    public int getNumberOfItemsLeft() {
        int count= 0;
        for(Todo todo: todos){
            if(todo.getState()== State.NON_COMPLETED){
                count++;
            }
        }
        return count;
    }

    public List<String> getMostImportantTodosText() {
        List<String> result= new ArrayList<>();
        int searchedPrior= todos.get(0).getPriority();
        for(Todo todo: todos){
            if(todo.getPriority()== searchedPrior){
                result.add(todo.getText());
            }
            if(todo.getPriority()< searchedPrior){
                searchedPrior= todo.getPriority();
                result.clear();
                result.add(todo.getText());
            }
        }
        return result;
    }

    public void deleteCompleted() {
        List<Todo> modified= new ArrayList<>();
        for(Todo t: todos){
            if(t.getState()== State.NON_COMPLETED){
                modified.add(t);
            }
        }
        todos= modified;
    }
}
