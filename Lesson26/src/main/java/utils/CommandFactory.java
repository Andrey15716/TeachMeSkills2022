package utils;

import commands.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private static final Map<String, BaseCommand> COMMAND_LIST = new HashMap<>();

    static {
        COMMAND_LIST.put(CommandsEnum.HOME_PAGE_COMMAND.getCommand(), new HomePageCommand());
        COMMAND_LIST.put(CommandsEnum.SIGN_IN_COMMAND.getCommand(), new SigningCommandImpl());
        COMMAND_LIST.put(CommandsEnum.CATEGORY_PAGE_COMMAND.getCommand(), new CategoryRedirectCommand());
        COMMAND_LIST.put(CommandsEnum.ADD_PRODUCT_TO_CART_COMMAND.getCommand(), new AddProductToCartCommandImpl());
        COMMAND_LIST.put(CommandsEnum.REDIRECT_SHOPPING_CART_COMMAND.getCommand(), new RedirectToShoppingCart());
        COMMAND_LIST.put(CommandsEnum.REDIRECT_PRODUCT_COMMAND.getCommand(), new RedirectProductPageCommandImpl());
        COMMAND_LIST.put(CommandsEnum.REGISTRATION_COMMAND.getCommand(), new RedirectRegistrationCommandImpl());
        COMMAND_LIST.put(CommandsEnum.REDIRECT_TO_PROFILE_COMMAND.getCommand(), new RedirectProfilePageCommandImpl());
        COMMAND_LIST.put(CommandsEnum.ORDER_COMMAND.getCommand(), new OrderProductCommandImpl());
        COMMAND_LIST.put(CommandsEnum.CONFIRM_REGISTRATION_COMMAND.getCommand(), new ConfirmRegistrationCommandImpl());
        COMMAND_LIST.put(CommandsEnum.SEARCH_COMMAND.getCommand(), new SearchCommandImpl());
    }

    public static BaseCommand defineCommand(HttpServletRequest request) {
        String commandKey = request.getParameter(RequestParamsEnum.COMMAND.getValue());
        if (commandKey == null || commandKey.isEmpty()) {
            commandKey = CommandsEnum.SIGN_IN_COMMAND.getCommand();
        }
        return COMMAND_LIST.get(commandKey);
    }
}