public class Main {
    public static void main(String[] args) {
        TodoList todoList = new TodoList();

        // Добавление задач
        todoList.addTask(new Task(1, "Купить молоко", "Покупки", false));
        todoList.addTask(new Task(2, "Позвонить маме", "Личное", false));
        todoList.addTask(new Task(3, "Подготовить отчет", "Работа", false));

        // Вывод всех задач
        todoList.displayAllTasks();

        // Отметка задачи как выполненной
        todoList.markTaskAsDone(1);

        // Поиск задач по ключевому слову
        todoList.searchTasks("отчет");

        // Вывод задач по категориям
        todoList.displayTasksByCategory();

        // Статистика по задачам
        todoList.displayStatistics();

        // Добавление новой задачи
        todoList.addTask(new Task(4, "Сходить в спортзал", "Здоровье", false));
        todoList.displayAllTasks();

        // Удаление задачи
        todoList.deleteTask(2);
        todoList.displayAllTasks();

        // Финальная статистика
        todoList.displayStatistics();
    }
}
