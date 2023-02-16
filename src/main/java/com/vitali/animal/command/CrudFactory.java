package com.vitali.animal.command;

import com.vitali.animal.util.Constants;
import lombok.NoArgsConstructor;

import javax.servlet.http.HttpServletRequest;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class CrudFactory {
    private static final CrudFactory INSTANCE = new CrudFactory();

    public CrudCommand defineCommand(HttpServletRequest request) {

        String action = request.getParameter(Constants.COMMAND);

        if (action == null || action.isEmpty()) {
            return null;
        }
        CrudEnum currentEnum = CrudEnum.valueOf(action.toUpperCase());
        return currentEnum.getCurrentCommand();

    }

    public static CrudFactory getInstance() {
        return INSTANCE;
    }

}
