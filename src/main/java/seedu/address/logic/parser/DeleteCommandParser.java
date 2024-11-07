package seedu.address.logic.parser;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.DeleteCommand;
import seedu.address.logic.commands.DeleteCompanyCommand;
import seedu.address.logic.commands.DeleteContactCommand;
import seedu.address.logic.commands.DeleteJobCommand;
import seedu.address.logic.parser.exceptions.ParseException;

import static seedu.address.logic.Messages.MESSAGE_INVALID_INDEX_RANGE;

/**
 * Parses input arguments and creates a new subclass of DeleteCommand object
 */
public class DeleteCommandParser implements Parser<DeleteCommand<?>> {
    /**
     * Parses the given {@code String} of arguments in the context of the DeleteContactCommand
     * and returns a DeleteCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public DeleteCommand<?> parse(String args) throws ParseException {


        String[] splitArgs = ParserUtil.parseRequiredNumberOfArguments(args, 2, DeleteCommand.MESSAGE_USAGE);

        String entityString = splitArgs[0]; // either "contact, "job" or "company"
        String indexString = splitArgs[1];


        String entity = ParserUtil.parseEntity(entityString);

        Index index;

        try {
            index = ParserUtil.parseIndex(indexString);
        } catch (ParseException e) {
            throw new ParseException(MESSAGE_INVALID_INDEX_RANGE);
        }
        switch (entity) {
        case DeleteContactCommand.ENTITY_WORD:
            return new DeleteContactCommand(index);
        case DeleteJobCommand.ENTITY_WORD:
            return new DeleteJobCommand(index);
        case DeleteCompanyCommand.ENTITY_WORD:
            return new DeleteCompanyCommand(index);
        default:

            String exceptionMessage = String.format(Messages.MESSAGE_OPERATION_NOT_ALLOWED,
                    DeleteCommand.COMMAND_WORD, entity);
            throw new ParseException(exceptionMessage);
        }
    }
}
