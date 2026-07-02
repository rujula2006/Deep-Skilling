class Task {

    private int taskId;
    private String taskName;
    private String status;

    Task next;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }

    public int getTaskId() {
        return taskId;
    }

    public void displayTask() {
        System.out.println("Task ID: " + taskId);
        System.out.println("Task Name: " + taskName);
        System.out.println("Status: " + status);
        System.out.println();
    }
}

class TaskLinkedList {

    private Task head;

    public void addTask(Task newTask) {

        if (head == null) {
            head = newTask;
        } else {

            Task temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newTask;
        }

        System.out.println("Task added successfully.");
    }

    public Task searchTask(int taskId) {

        Task temp = head;

        while (temp != null) {

            if (temp.getTaskId() == taskId) {
                return temp;
            }

            temp = temp.next;
        }

        return null;
    }

    public void traverseTasks() {

        Task temp = head;

        while (temp != null) {
            temp.displayTask();
            temp = temp.next;
        }
    }

    public void deleteTask(int taskId) {

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.getTaskId() == taskId) {
            head = head.next;
            System.out.println("Task deleted successfully.");
            return;
        }

        Task current = head;
        Task previous = null;

        while (current != null && current.getTaskId() != taskId) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Task not found.");
        } else {
            previous.next = current.next;
            System.out.println("Task deleted successfully.");
        }
    }
}

public class TaskManagement {

    public static void main(String[] args) {

        TaskLinkedList taskList = new TaskLinkedList();

        taskList.addTask(new Task(101, "Complete Assignment", "Pending"));
        taskList.addTask(new Task(102, "Prepare Report", "In Progress"));
        taskList.addTask(new Task(103, "Attend Meeting", "Completed"));

        System.out.println("Task List:");
        taskList.traverseTasks();

        System.out.println("Searching Task 102:");

        Task task = taskList.searchTask(102);

        if (task != null) {
            task.displayTask();
        } else {
            System.out.println("Task not found.");
        }

        taskList.deleteTask(103);

        System.out.println("Task List After Deletion:");
        taskList.traverseTasks();
    }
}