package ru.tinkoff.edu.java;

import ru.tinkoff.edu.java.commands.Command;
import ru.tinkoff.edu.java.commands.CommandProvider;
import ru.tinkoff.edu.java.commands.UnsupportedCommand;
import ru.tinkoff.edu.java.commands.InvalidCommandArguments;
import ru.tinkoff.edu.java.tasks.InMemoryTaskStore;
import ru.tinkoff.edu.java.tasks.TaskStore;

import java.util.Scanner;

public class Application {

    private final Scanner scanner = new Scanner(System.in);
    private final TaskStore taskStore = new InMemoryTaskStore();
    private final CommandProvider commandProvider = new CommandProvider(taskStore);

    public void run(){
        boolean execute = true;
        while (execute){
            String input = scanner.nextLine();
            String[] args = input.split(" ");
            try {
                Command command = commandProvider.parseCommand(args);
                System.out.println(command.execute());
            } catch (InvalidCommandArguments e) {
                System.out.println("Invalid command arguments! Try this:");
                System.out.println(e.getHelpMessage());
            } catch (UnsupportedCommand e) {
                System.out.printf("Command '%s' is not supported!\n", e.getCommandName());
                System.out.println(commandProvider.help());
            } catch (RuntimeException e){
                System.out.println(e.getMessage());
                execute = false;
            }
        }
    }

}