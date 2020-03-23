package by.epam.agency.factory;

import by.epam.agency.command.Command;
import by.epam.agency.command.impl.ErrorCommand;
import by.epam.agency.command.impl.LogInCommand;
import by.epam.agency.command.impl.SignInCommand;
import by.epam.agency.enums.CommandType;

public class CommandFactory {

    private CommandFactory() {

    }

    public static CommandFactory getInstance() {
        return CommandHolder.COMMAND_HOLDER_INSTANCE;
    }

    public Command doCommand(String typeParser) {
        CommandType type = CommandType.valueOf(typeParser.toUpperCase());
        switch (type) {
            case LOG_IN:
                return new LogInCommand();
            case SIGN_IN:
                return new SignInCommand();
            default:
                return new ErrorCommand();
        }
    }

    private static class CommandHolder {
        public static final CommandFactory COMMAND_HOLDER_INSTANCE = new CommandFactory();
    }
}
