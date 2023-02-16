package com.vitali.animal.command;

public enum CrudEnum {
    CREATE(new CreateCommand()),
    READ(new ReadCommand()),
    UPDATE(new UpdateCommand()),
    DELETE(new DeleteCommand());

    private final CrudCommand crudCommand;

    CrudEnum(final CrudCommand newCrudCommand) {
        crudCommand = newCrudCommand;
    }

    public CrudCommand getCurrentCommand() {
        return crudCommand;
    }
}
