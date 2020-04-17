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

    public Command getCommand(String typeCommand) {
        if (typeCommand == null) {
            return new HomeCommand();
        }
        CommandType type = CommandType.valueOf(typeCommand.toUpperCase());
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
            case BLOCK_CLIENT:
                return new BlockClientCommand();
            case UNBLOCK_CLIENT:
                return new UnblockClientCommand();
            case GET_USERS_LIST:
                return new GetUsersListCommand();
            case CREATE_ADMIN:
                return new CreateAdminCommand();
            case UPDATE_ADMIN:
                return new UpdateAdminCommand();
            case UPDATE_CLIENT:
                return new UpdateClientCommand();
            case DELETE_CLIENT:
                return new DeleteClientCommand();
            case GET_TOURS_LIST:
                return new GetToursListCommand();
            case GET_HOT_TOURS:
                return new GetHotToursCommand();
            case UN_HOT_TOUR:
                return new UnHotTourCommand();
            case SET_HOT_TOUR:
                return new SetHotTourCommand();
            case DELETE_TOUR:
                return new DeleteTourCommand();
            case GET_BY_CITY:
                return new GetToursByCity();
            case GET_BY_TOUR_TYPE:
                return new GetToursByType();
            case ADD_TOUR:
                return new AddTourCommand();
            case UPDATE_TOUR:
                return new UpdateTourInfoCommand();
            case GET_UPDATE_TOUR_PAGE:
                return new GetUpdateTourPageCommand();
//            default:
//                return new ErrorCommand();
        }
        return null;

    }

    private static class CommandHolder {
        public static final CommandFactory COMMAND_HOLDER_INSTANCE = new CommandFactory();
    }
}
