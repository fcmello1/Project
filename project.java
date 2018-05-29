//Fabio Cervi de Mello
//Projeto

import java.util.ArrayList;
import java.util.Scanner;

class Presentation
{
	void welcome()
	{
		System.out.println("Hello and welcome to your personal task control.");
		System.out.println();
		System.out.println("These are your current tasks:");	
	}

	void options()
	{
		System.out.println("Please press one of the following options:");
		System.out.println("1 to add a new task;");
		System.out.println("2 to show your current task list;");
		System.out.println("3 to remove a task;");
		System.out.println("4 to add a completed task to the completed tasks list;");
		System.out.println("5 to display all completed taks;");
		System.out.println("6 to leave the program.");		
	}
}

class taskList
{
	ArrayList<String> tasks = new ArrayList<String>();
	ArrayList<String> completedTasks = new ArrayList<String>();
	
	void setArrayOfTasks()
	{
		tasks.add("Write report for project 1.");
		tasks.add("Implement project 2.");
		tasks.add("Study for the test.");
		tasks.add("Implement project 3.");
	}

	void printArrayOfTasks()
	{
		int i, j = 1;
		System.out.println("This is your current task list:");
		for (i = 0; i < tasks.size(); i++)
		{
			System.out.println(j + " - " + tasks.get(i));
			j++;
		}
		System.out.println();
	}

	void addTask()
	{
		Scanner input = new Scanner(System.in);
		String task;
		System.out.print("Please type in the new task: ");
		task = input.nextLine();
		tasks.add(task);
	}

	void removeTask()
	{
		Scanner input = new Scanner(System.in);
		int i, op;

		System.out.println("Please type the number of the task you want to remove: ");
		System.out.println();
		printArrayOfTasks();

		i = input.nextInt();
		i--;

		if(i > tasks.size())
		{
			System.out.println("Please type a valid value.");
			return;
		}

		System.out.println("Are you sure you want to remove that task? Please type 0 for no and 1 for yes.");
		op = input.nextInt();
		if(op == 1)
			tasks.remove(i);

		System.out.println();
	}

	void completeTask()
	{
		Scanner input = new Scanner(System.in);
		int i;

		System.out.println("Please type the number of the task you have completed: ");
		printArrayOfTasks();
		i = input.nextInt();
		i --;
		completedTasks.add(tasks.get(i));
		tasks.remove(i);
	}

	void printArrayOfCompleteTasks()
	{
		int i, j;
		j = 1;
		if (completedTasks.size() == 0)
			System.out.println("You don't have completed any tasks until now.");
		else
		{
			System.out.println("This is your current completed task list:");
			for(i = 0; i < completedTasks.size(); i++)
			{
				System.out.println(j + " - " + completedTasks.get(i));
				j++;
			}
		}
		System.out.println();
	}
}


class Program
{
	public static void main(String[] args)
	{
		taskList tl = new taskList();
		Presentation p = new Presentation();
		Scanner input = new Scanner(System.in);
		int op;

		p.welcome();
		tl.setArrayOfTasks();
		tl.printArrayOfTasks();
		p.options();

		op = input.nextInt();
		while (op == 1 || op == 2 || op == 3 || op == 4 || op == 5)
		{
			p.options();
			switch(op)
			{
				case 1:
					tl.addTask();
					break;
				case 2:
					tl.printArrayOfTasks();
					break;
				case 3:
					tl.removeTask();
					break;
				case 4:
					tl.printArrayOfTasks();
					break;
				case 5:
					tl.completeTask();
					break;
				case 6:
					tl.printArrayOfCompleteTasks();
					break;
				default:
					break;
			}
			op = input.nextInt();
		}
	}
}