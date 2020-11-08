package intromethods;

import java.util.Arrays;

public class TodoListMain {
    public static void main(String[] args) {

        TodoList tl= new TodoList();
        tl.addTodo("Megöntözni a virágokat");///
        tl.addTodo("Levinni a szemetet");
        tl.addTodo("Porszívózás");
        tl.addTodo("Mosogatás");
        System.out.println(tl);

        tl.finishTodos("Porszívózás");
        System.out.println(tl);

        tl.finishMoreTodos(Arrays.asList("Levinni a szemetet", "Megöntözni a virágokat"));
        System.out.println(tl);

        System.out.println(tl.todosToFinish());
        System.out.println(tl.numberOfFinishedTodos());



    }
}
