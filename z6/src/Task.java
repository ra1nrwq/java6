import java.util.Date;

public class Task {
    private int id;
    private String description;
    private String category;
    private boolean isDone;
    private Date creationDate;

    public Task(int id, String description, String category, boolean isDone) {
        this.id = id;
        this.description = description;
        this.category = category;
        this.isDone = isDone;
        this.creationDate = new Date(); // Записывается дата создания
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public boolean isDone() {
        return isDone;
    }

    public void markAsDone() {
        this.isDone = true;
    }

    @Override
    public String toString() {
        return id + ". " + description + " (Категория: " + category + ", Статус: " + (isDone ? "Выполнено" : "Не выполнено") + ")";
    }
}
