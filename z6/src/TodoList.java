import java.util.*;

public class TodoList {
    private List<Task> tasks; // Список всех задач
    private Set<String> categories; // Уникальные категории
    private Map<String, List<Task>> tasksByCategory; // Группировка задач по категориям

    public TodoList() {
        tasks = new ArrayList<>();
        categories = new HashSet<>();
        tasksByCategory = new HashMap<>();
    }

    // Добавление задачи
    public void addTask(Task task) {
        tasks.add(task);
        categories.add(task.getCategory());

        tasksByCategory.putIfAbsent(task.getCategory(), new ArrayList<>());
        tasksByCategory.get(task.getCategory()).add(task);

        System.out.println("Задача \"" + task.getDescription() + "\" добавлена.");
    }

    // Отметить задачу как выполненную
    public void markTaskAsDone(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.markAsDone();
                System.out.println("Задача \"" + task.getDescription() + "\" отмечена как выполненная.");
                return;
            }
        }
        System.out.println("Задача с ID " + id + " не найдена.");
    }

    // Поиск задач по ключевым словам
    public void searchTasks(String keyword) {
        Iterator<Task> iterator = tasks.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.getDescription().contains(keyword)) {
                System.out.println("Найдена задача: " + task);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Задачи с ключевым словом \"" + keyword + "\" не найдены.");
        }
    }

    // Вывод всех задач
    public void displayAllTasks() {
        System.out.println("=== Вывод всех задач ===");
        if (tasks.isEmpty()) {
            System.out.println("Задачи отсутствуют.");
            return;
        }
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    // Вывод задач по категориям
    public void displayTasksByCategory() {
        System.out.println("=== Вывод задач по категориям ===");
        for (String category : categories) {
            System.out.println("Категория: " + category);
            List<Task> taskList = tasksByCategory.get(category);
            for (Task task : taskList) {
                System.out.println("- " + task);
            }
        }
    }

    // Статистика по задачам
    public void displayStatistics() {
        int completed = 0;
        int notCompleted = 0;
        for (Task task : tasks) {
            if (task.isDone()) {
                completed++;
            } else {
                notCompleted++;
            }
        }
        System.out.println("=== Статистика ===");
        System.out.println("Всего задач: " + tasks.size());
        System.out.println("Выполнено: " + completed);
        System.out.println("Не выполнено: " + notCompleted);
    }

    // Удаление задачи по ID
    public void deleteTask(int id) {
        Iterator<Task> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.getId() == id) {
                iterator.remove();
                tasksByCategory.get(task.getCategory()).remove(task);
                System.out.println("Задача \"" + task.getDescription() + "\" удалена.");
                return;
            }
        }
        System.out.println("Задача с ID " + id + " не найдена.");
    }
}
