package by.epam.agency.factory;

import by.epam.agency.command.Command;
import by.epam.agency.command.constants.CommandType;
import by.epam.agency.command.impl.*;

public class CommandFactory {

    private CommandFactory() {

    }

    public static CommandFactory getInstance() {
        return CommandHolder.COMMAND_HOLDER_INSTANCE;
    }

    public Command doCommand(String typeParser) {
        Command command = new HomeCommand();
        if (typeParser == null || typeParser.isEmpty()) {
            return command;
        }
        CommandType type = CommandType.valueOf(typeParser.toUpperCase());
        switch (type) {
            case SIGN_IN:
                return new SignInCommand();
            case SIGN_UP:
                return new SignUpCommand();
            case REDIRECT:
                return new RedirectCommand();
            case SIGN_OUT:
                return new SignOutCommand();
            case HOME:
                return new HomeCommand();
            default:
                return new ErrorCommand();
        }
    }

    private static class CommandHolder {
        public static final CommandFactory COMMAND_HOLDER_INSTANCE = new CommandFactory();
    }
}
