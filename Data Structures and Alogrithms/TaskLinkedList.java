// TaskLinkedList.java - Manage tasks using a singly linked list

class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    public Task(int id, String name, String status) {
        this.taskId = id;
        this.taskName = name;
        this.status = status;
        this.next = null;
    }

    public String toString() {
        return taskId + " - " + taskName + " [" + status + "]";
    }
}

class TaskList {
    private Task head;

    public void addTask(int id, String name, String status) {
        Task newTask = new Task(id, name, status);
        if (head == null) {
            head = newTask;
        } else {
            Task current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newTask;
        }
        System.out.println("Added: " + name);
    }

    public void showTasks() {
        System.out.println("\n--- Task List ---");
        Task current = head;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }

    public void searchTask(int id) {
        Task current = head;
        while (current != null) {
            if (current.taskId == id) {
                System.out.println("Found: " + current);
                return;
            }
            current = current.next;
        }
        System.out.println("Task not found.");
    }

    public void deleteTask(int id) {
        if (head == null) return;

        if (head.taskId == id) {
            System.out.println("Deleted: " + head.taskName);
            head = head.next;
            return;
        }

        Task current = head;
        while (current.next != null) {
            if (current.next.taskId == id) {
                System.out.println("Deleted: " + current.next.taskName);
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
        System.out.println("Task not found.");
    }
}

public class TaskLinkedList {
    public static void main(String[] args) {
        TaskList taskList = new TaskList();

        taskList.addTask(1, "Design UI", "Pending");
        taskList.addTask(2, "Write backend code", "In Progress");
        taskList.addTask(3, "Test app", "Pending");
        taskList.addTask(4, "Deploy", "Pending");

        taskList.showTasks();

        System.out.println("\nSearching for task ID 2:");
        taskList.searchTask(2);

        System.out.println("\nDeleting task ID 3:");
        taskList.deleteTask(3);

        taskList.showTasks();
    }
}

